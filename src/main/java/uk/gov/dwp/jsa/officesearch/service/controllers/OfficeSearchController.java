package uk.gov.dwp.jsa.officesearch.service.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.gov.dwp.jsa.officesearch.service.config.WithVersionUriComponentsBuilder;
import uk.gov.dwp.jsa.officesearch.service.models.http.BenefitCentreResponse;
import uk.gov.dwp.jsa.officesearch.service.models.http.JobCentreResponse;
import uk.gov.dwp.jsa.officesearch.service.models.http.api.ApiResponse;
import uk.gov.dwp.jsa.officesearch.service.services.OfficeSearchService;
import uk.gov.dwp.jsa.officesearch.service.services.ResponseBuilder;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;

@RestController
@RequestMapping("/nsjsa/" + WithVersionUriComponentsBuilder.VERSION_SPEL + "/office/job-centre")
public class OfficeSearchController {
    private static final Logger LOGGER = LoggerFactory.getLogger(OfficeSearchController.class);

    private final OfficeSearchService officeSearchService;

    @Autowired
    public OfficeSearchController(final OfficeSearchService officeSearchService) {
        this.officeSearchService = officeSearchService;
    }
    @GetMapping("/postcode/{postcode}")
    public ResponseEntity<ApiResponse<JobCentreResponse>> getJobCentreForPostcode(
            @PathVariable("postcode") final String postcode,
            final HttpServletRequest request
    ) {
        LOGGER.debug("Getting job centre for postcode: {}", postcode);

        JobCentreResponse jobCentreResponse = officeSearchService
                .getJobCentreForPostcode(postcode)
                .orElse(null);

        return generateResponse(
                request.getRequestURI(),
                jobCentreResponse
        );
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<ApiResponse<JobCentreResponse>> getJobCentreForId(
            @PathVariable final Long id,
            final HttpServletRequest request
    ) {
        LOGGER.debug("Getting job centre for id: {}", id);

        JobCentreResponse jobCentreResponse = officeSearchService
                .getJobCentreForId(id)
                .orElse(null);

        return generateResponse(
                request.getRequestURI(),
                jobCentreResponse
        );
    }

    @GetMapping("/{id}/benefit-centre")
    public ResponseEntity<ApiResponse<BenefitCentreResponse>> getBenefitCentreByJobCentreId(
            @PathVariable final Long id,
            final HttpServletRequest request
    ) {
        LOGGER.debug("Getting benefit centre for job centre id: {}", id);

        BenefitCentreResponse benefitCentreResponse = officeSearchService
                .getBenefitCentreByJobCentreId(id)
                .orElse(null);

        return generateResponse(
                request.getRequestURI(),
                benefitCentreResponse
        );
    }

    private <T> ResponseEntity<ApiResponse<T>> generateResponse(final String path, final T objectToReturn) {
        if (objectToReturn == null) {
            LOGGER.error("Error no object found in path {}", path);
            return buildErrorResponse();

        } else {
            return buildSuccessfulResponse(
                    path,
                    objectToReturn,
                    HttpStatus.OK
            );
        }
    }

    private <T> ResponseEntity<ApiResponse<T>> buildSuccessfulResponse(
            final String path,
            final T objectToReturn,
            final HttpStatus status
    ) {
        return new ResponseBuilder<T>()
                .withStatus(status)
                .withSuccessData(URI.create(path), objectToReturn)
                .build();
    }

    private <T> ResponseEntity<ApiResponse<T>> buildErrorResponse() {
        return new ResponseBuilder<T>()
                .withStatus(HttpStatus.NOT_FOUND)
                .withApiError(HttpStatus.NOT_FOUND.toString(), HttpStatus.NOT_FOUND.getReasonPhrase())
                .build();
    }

}
