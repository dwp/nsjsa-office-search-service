package uk.gov.dwp.jsa.officesearch.service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.gov.dwp.jsa.officesearch.service.models.db.JobCentre;
import uk.gov.dwp.jsa.officesearch.service.models.db.PostcodeCovered;
import uk.gov.dwp.jsa.officesearch.service.models.http.AddressResponse;
import uk.gov.dwp.jsa.officesearch.service.models.http.BenefitCentreResponse;
import uk.gov.dwp.jsa.officesearch.service.models.http.JobCentreResponse;
import uk.gov.dwp.jsa.officesearch.service.models.http.PhoneNumberResponse;
import uk.gov.dwp.jsa.officesearch.service.repositories.JobCentreRepository;
import uk.gov.dwp.jsa.officesearch.service.repositories.PostcodeCoveredRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OfficeSearchService {

    private PostcodeCoveredRepository postcodeCoveredRepository;
    private JobCentreRepository jobCentreRepository;

    @Autowired
    public OfficeSearchService(
            final PostcodeCoveredRepository postcodeCoveredRepository,
            final JobCentreRepository jobCentreRepository
    ) {
        this.postcodeCoveredRepository = postcodeCoveredRepository;
        this.jobCentreRepository = jobCentreRepository;
    }

    public Optional<JobCentreResponse> getJobCentreForPostcode(final String postcode) {
        String normalisedPostcode = PostcodeUtils.normalisePostcode(postcode);
        List<String> postcodePartials = PostcodeUtils.createPostcodePartials(normalisedPostcode);

        for (String postcodePartial: postcodePartials) {
            Optional<PostcodeCovered> postcodeCovered =
                    postcodeCoveredRepository.findFirstByPostcodeZoneIgnoreCase(postcodePartial);
            if (postcodeCovered.isPresent()) {
                return postcodeCovered
                        .map(PostcodeCovered::getJobCentre)
                        .map(this::toJobCentreResponse);
            }
        }
        return Optional.empty();
    }

    public Optional<JobCentreResponse> getJobCentreForId(final Long id) {
        return jobCentreRepository.findById(id)
                .map(this::toJobCentreResponse);
    }

    public Optional<BenefitCentreResponse> getBenefitCentreByJobCentreId(final Long id) {
        return jobCentreRepository.findById(id)
                .map(JobCentre::getBenefitCentre)
                .map(benefitCentre ->
                        new BenefitCentreResponse(
                                benefitCentre.getBenefitCentreId(),
                                benefitCentre.getServiceId(),
                                benefitCentre.getName()
                        ));
    }

    private JobCentreResponse toJobCentreResponse(final JobCentre jobCentre) {
        return new JobCentreResponse(
                jobCentre.getJobCentreId(),
                jobCentre.getName(),
                new AddressResponse(
                        jobCentre.getFirstLine(),
                        jobCentre.getSecondLine(),
                        jobCentre.getTown(),
                        jobCentre.getPostCode()
                ),
                new BenefitCentreResponse(
                        jobCentre.getBenefitCentre().getBenefitCentreId(),
                        jobCentre.getBenefitCentre().getServiceId(),
                        jobCentre.getBenefitCentre().getName()
                ),
                jobCentre.getPhoneNumbers()
                        .stream()
                        .map(phoneNumber -> new PhoneNumberResponse(
                                phoneNumber.getNumber(),
                                phoneNumber.getType()
                        ))
                        .collect(Collectors.toList()));
    }
}
