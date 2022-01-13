package uk.gov.dwp.jsa.officesearch.service.controllers;

import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;
import uk.gov.dwp.jsa.officesearch.service.TestDataFixture;
import uk.gov.dwp.jsa.officesearch.service.models.http.BenefitCentreResponse;
import uk.gov.dwp.jsa.officesearch.service.models.http.JobCentreResponse;
import uk.gov.dwp.jsa.officesearch.service.models.http.api.ApiResponse;
import uk.gov.dwp.jsa.officesearch.service.services.OfficeSearchService;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.sameInstance;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class OfficeSearchControllerTest {

    private static final String GET_URL = "http://localhost/nsjsa/v1/office/job-centre/postcode/" + TestDataFixture.POST_CODE;

    private OfficeSearchController controller;

    @Mock
    private OfficeSearchService officeSearchService;

    @Mock
    private HttpServletRequest httpServletRequest;

    @Before
    public void before() {
        controller = new OfficeSearchController(
                officeSearchService
        );

        given(httpServletRequest.getRequestURI()).willReturn(GET_URL);
    }

    @Test
    public void getJobCentreForPostcode_validClaimantId_httpStatusIs200() {
        given(officeSearchService.getJobCentreForPostcode(TestDataFixture.POST_CODE_WITH_SPACES)).willReturn(Optional.of(TestDataFixture.jobCentreResponse()));

        ResponseEntity<ApiResponse<JobCentreResponse>> response = controller.getJobCentreForPostcode(TestDataFixture.POST_CODE_WITH_SPACES, httpServletRequest);

        assertThat(response.getStatusCodeValue(), is(equalTo(200)));
    }

    @Test
    public void getJobCentreForPostcode_JobCentreExists_CorrectPathIsReturned() {
        given(officeSearchService.getJobCentreForPostcode(TestDataFixture.POST_CODE_WITH_SPACES)).willReturn(Optional.of(TestDataFixture.jobCentreResponse()));

        ResponseEntity<ApiResponse<JobCentreResponse>> response = controller.getJobCentreForPostcode(TestDataFixture.POST_CODE_WITH_SPACES, httpServletRequest);

        MatcherAssert.assertThat(response.getBody().getSuccess(), hasSize(1));
        MatcherAssert.assertThat(response.getBody().getSuccess().get(0).getPath().toString(), is(equalTo(GET_URL)));
    }

    @Test
    public void getJobCentreForPostcode_JobCentreExists_JobCentreResponseReturned() {
        JobCentreResponse jobCentreResponse = TestDataFixture.jobCentreResponse();
        given(officeSearchService.getJobCentreForPostcode(TestDataFixture.POST_CODE_WITH_SPACES)).willReturn(Optional.of(jobCentreResponse));

        ResponseEntity<ApiResponse<JobCentreResponse>> response = controller.getJobCentreForPostcode(TestDataFixture.POST_CODE_WITH_SPACES, httpServletRequest);

        MatcherAssert.assertThat(response.getBody().getSuccess().get(0).getData(), is(sameInstance(jobCentreResponse)));
    }

    @Test
    public void getJobCentreForPostcode_JobCentreDoesNotExist_HttpStatusIs404() {
        given(officeSearchService.getJobCentreForPostcode(TestDataFixture.POST_CODE_WITH_SPACES)).willReturn(Optional.empty());

        ResponseEntity<ApiResponse<JobCentreResponse>> response = controller.getJobCentreForPostcode(TestDataFixture.POST_CODE_WITH_SPACES, httpServletRequest);

        assertThat(response.getStatusCodeValue(), is(equalTo(404)));
    }

    @Test
    public void getJobCentreForPostcode_JobCentreDoesNotExist_ApiMessageIsNotFound() {
        given(officeSearchService.getJobCentreForPostcode(TestDataFixture.POST_CODE_WITH_SPACES)).willReturn(Optional.empty());

        ResponseEntity<ApiResponse<JobCentreResponse>> response = controller.getJobCentreForPostcode(TestDataFixture.POST_CODE_WITH_SPACES, httpServletRequest);

        assertThat(response.getBody().getError().getMessage(), is(equalTo("Not Found")));
    }

    @Test
    public void getJobCentreForId_validClaimantId_httpStatusIs200() {
        given(officeSearchService.getJobCentreForId(TestDataFixture.JOB_CENTRE_ID)).willReturn(Optional.of(TestDataFixture.jobCentreResponse()));

        ResponseEntity<ApiResponse<JobCentreResponse>> response = controller.getJobCentreForId(TestDataFixture.JOB_CENTRE_ID, httpServletRequest);

        assertThat(response.getStatusCodeValue(), is(equalTo(200)));
    }

    @Test
    public void getJobCentreForId_JobCentreExists_CorrectPathIsReturned() {
        given(officeSearchService.getJobCentreForId(TestDataFixture.JOB_CENTRE_ID)).willReturn(Optional.of(TestDataFixture.jobCentreResponse()));

        ResponseEntity<ApiResponse<JobCentreResponse>> response = controller.getJobCentreForId(TestDataFixture.JOB_CENTRE_ID, httpServletRequest);

        MatcherAssert.assertThat(response.getBody().getSuccess(), hasSize(1));
        MatcherAssert.assertThat(response.getBody().getSuccess().get(0).getPath().toString(), is(equalTo(GET_URL)));
    }

    @Test
    public void getJobCentreForId_JobCentreExists_JobCentreResponseReturned() {
        JobCentreResponse jobCentreResponse = TestDataFixture.jobCentreResponse();
        given(officeSearchService.getJobCentreForId(TestDataFixture.JOB_CENTRE_ID)).willReturn(Optional.of(jobCentreResponse));

        ResponseEntity<ApiResponse<JobCentreResponse>> response = controller.getJobCentreForId(TestDataFixture.JOB_CENTRE_ID, httpServletRequest);

        MatcherAssert.assertThat(response.getBody().getSuccess().get(0).getData(), is(sameInstance(jobCentreResponse)));
    }

    @Test
    public void getJobCentreForId_JobCentreDoesNotExist_HttpStatusIs404() {
        given(officeSearchService.getJobCentreForId(TestDataFixture.JOB_CENTRE_ID)).willReturn(Optional.empty());

        ResponseEntity<ApiResponse<JobCentreResponse>> response = controller.getJobCentreForId(TestDataFixture.JOB_CENTRE_ID, httpServletRequest);

        assertThat(response.getStatusCodeValue(), is(equalTo(404)));
    }

    @Test
    public void getJobCentreForId_JobCentreDoesNotExist_ApiMessageIsNotFound() {
        given(officeSearchService.getJobCentreForId(TestDataFixture.JOB_CENTRE_ID)).willReturn(Optional.empty());

        ResponseEntity<ApiResponse<JobCentreResponse>> response = controller.getJobCentreForId(TestDataFixture.JOB_CENTRE_ID, httpServletRequest);

        assertThat(response.getBody().getError().getMessage(), is(equalTo("Not Found")));
    }

    @Test
    public void getBenefitCentreForId_validClaimantId_httpStatusIs200() {
        given(officeSearchService.getBenefitCentreByJobCentreId(TestDataFixture.JOB_CENTRE_ID)).willReturn(Optional.of(TestDataFixture.benefitCentreResponse()));

        ResponseEntity<ApiResponse<BenefitCentreResponse>> response = controller.getBenefitCentreByJobCentreId(TestDataFixture.JOB_CENTRE_ID, httpServletRequest);

        assertThat(response.getStatusCodeValue(), is(equalTo(200)));
    }

    @Test
    public void getBenefitCentreForId_JobCentreExists_CorrectPathIsReturned() {
        given(officeSearchService.getBenefitCentreByJobCentreId(TestDataFixture.JOB_CENTRE_ID)).willReturn(Optional.of(TestDataFixture.benefitCentreResponse()));

        ResponseEntity<ApiResponse<BenefitCentreResponse>> response = controller.getBenefitCentreByJobCentreId(TestDataFixture.JOB_CENTRE_ID, httpServletRequest);

        MatcherAssert.assertThat(response.getBody().getSuccess(), hasSize(1));
        MatcherAssert.assertThat(response.getBody().getSuccess().get(0).getPath().toString(), is(equalTo(GET_URL)));
    }

    @Test
    public void getBenefitCentreForId_JobCentreExists_JobCentreResponseReturned() {
        BenefitCentreResponse benefitCentreResponse = TestDataFixture.benefitCentreResponse();
        given(officeSearchService.getBenefitCentreByJobCentreId(TestDataFixture.JOB_CENTRE_ID)).willReturn(Optional.of(benefitCentreResponse));

        ResponseEntity<ApiResponse<BenefitCentreResponse>> response = controller.getBenefitCentreByJobCentreId(TestDataFixture.JOB_CENTRE_ID, httpServletRequest);

        MatcherAssert.assertThat(response.getBody().getSuccess().get(0).getData(), is(sameInstance(benefitCentreResponse)));
    }

    @Test
    public void getBenefitCentreForId_JobCentreDoesNotExist_HttpStatusIs404() {
        given(officeSearchService.getBenefitCentreByJobCentreId(TestDataFixture.JOB_CENTRE_ID)).willReturn(Optional.empty());

        ResponseEntity<ApiResponse<BenefitCentreResponse>> response = controller.getBenefitCentreByJobCentreId(TestDataFixture.JOB_CENTRE_ID, httpServletRequest);

        assertThat(response.getStatusCodeValue(), is(equalTo(404)));
    }

    @Test
    public void getBenefitCentreForId_JobCentreDoesNotExist_ApiMessageIsNotFound() {
        given(officeSearchService.getBenefitCentreByJobCentreId(TestDataFixture.JOB_CENTRE_ID)).willReturn(Optional.empty());

        ResponseEntity<ApiResponse<BenefitCentreResponse>> response = controller.getBenefitCentreByJobCentreId(TestDataFixture.JOB_CENTRE_ID, httpServletRequest);

        assertThat(response.getBody().getError().getMessage(), is(equalTo("Not Found")));
    }
}
