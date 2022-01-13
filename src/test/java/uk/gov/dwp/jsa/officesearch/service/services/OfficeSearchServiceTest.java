package uk.gov.dwp.jsa.officesearch.service.services;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import uk.gov.dwp.jsa.officesearch.service.TestDataFixture;
import uk.gov.dwp.jsa.officesearch.service.models.http.BenefitCentreResponse;
import uk.gov.dwp.jsa.officesearch.service.models.http.JobCentreResponse;
import uk.gov.dwp.jsa.officesearch.service.repositories.JobCentreRepository;
import uk.gov.dwp.jsa.officesearch.service.repositories.PostcodeCoveredRepository;

import java.util.Optional;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class OfficeSearchServiceTest {

    private OfficeSearchService officeSearchService;

    @Mock
    private PostcodeCoveredRepository postcodeCoveredRepository;

    @Mock
    private JobCentreRepository jobCentreRepository;

    @Before
    public void setUp() {
        officeSearchService = new OfficeSearchService(
                postcodeCoveredRepository,
                jobCentreRepository
        );
    }

    @Test
    public void getJobCentreForPostcode_JobCentreExists_JobCentreReturned() {
        given(postcodeCoveredRepository.findFirstByPostcodeZoneIgnoreCase(TestDataFixture.NORMALISED_POST_CODE)).willReturn(Optional.of(TestDataFixture.postcodeCovered()));

        JobCentreResponse response = officeSearchService.getJobCentreForPostcode(TestDataFixture.POST_CODE).get();

        assertThat(response.getJobCentreId(), is(equalTo(TestDataFixture.JOB_CENTRE_ID)));
        assertThat(response.getName(), is(equalTo("job centre name")));
        assertThat(response.getAddress(), is(equalTo(TestDataFixture.addressResponse())));
        assertThat(response.getBenefitCentre(), is(equalTo(TestDataFixture.benefitCentreResponse())));
        assertThat(response.getPhoneNumbers(), is(equalTo(TestDataFixture.phoneNumbersResponse())));
    }

    @Test
    public void getJobCentreForPostcode_PostCodeWithSpaces_JobCentreReturned() {
        given(postcodeCoveredRepository.findFirstByPostcodeZoneIgnoreCase(TestDataFixture.NORMALISED_POST_CODE)).willReturn(Optional.of(TestDataFixture.postcodeCovered()));

        JobCentreResponse response = officeSearchService.getJobCentreForPostcode(TestDataFixture.POST_CODE_WITH_SPACES).get();

        assertThat(response.getJobCentreId(), is(equalTo(TestDataFixture.JOB_CENTRE_ID)));
        assertThat(response.getName(), is(equalTo("job centre name")));
        assertThat(response.getAddress(), is(equalTo(TestDataFixture.addressResponse())));
        assertThat(response.getBenefitCentre(), is(equalTo(TestDataFixture.benefitCentreResponse())));
        assertThat(response.getPhoneNumbers(), is(equalTo(TestDataFixture.phoneNumbersResponse())));
    }

    @Test
    public void getJobCentreForPostcode_JobCentreDoesNotExist_OptionalNotPresent() {

        Optional<JobCentreResponse> optionalResponse = officeSearchService.getJobCentreForPostcode(TestDataFixture.POST_CODE);

        assertThat(optionalResponse.isPresent(), is(equalTo(false)));
    }

    @Test
    public void getJobCentreForId_JobCentreExists_JobCentreReturned() {
        given(jobCentreRepository.findById(TestDataFixture.JOB_CENTRE_ID)).willReturn(Optional.of(TestDataFixture.jobCentre()));

        JobCentreResponse response = officeSearchService.getJobCentreForId(TestDataFixture.JOB_CENTRE_ID).get();

        assertThat(response.getJobCentreId(), is(equalTo(TestDataFixture.JOB_CENTRE_ID)));
        assertThat(response.getName(), is(equalTo("job centre name")));
        assertThat(response.getAddress(), is(equalTo(TestDataFixture.addressResponse())));
        assertThat(response.getBenefitCentre(), is(equalTo(TestDataFixture.benefitCentreResponse())));
        assertThat(response.getPhoneNumbers(), is(equalTo(TestDataFixture.phoneNumbersResponse())));
    }

    @Test
    public void getJobCentreForId_JobCentreDoesNotExist_OptionalNotPresent() {

        Optional<JobCentreResponse> optionalResponse = officeSearchService.getJobCentreForId(TestDataFixture.JOB_CENTRE_ID);

        assertThat(optionalResponse.isPresent(), is(equalTo(false)));
    }

    @Test
    public void getBenefitCentreByJobCentreId_JobCentreExists_BenefitCentreReturned() {
        given(jobCentreRepository.findById(TestDataFixture.JOB_CENTRE_ID)).willReturn(Optional.of(TestDataFixture.jobCentre()));

        BenefitCentreResponse response = officeSearchService.getBenefitCentreByJobCentreId(TestDataFixture.JOB_CENTRE_ID).get();

        assertThat(response, is(equalTo(TestDataFixture.benefitCentreResponse())));
    }

    @Test
    public void getBenefitCentreForId_JobCentreDoesNotExist_OptionalNotPresent() {

        Optional<BenefitCentreResponse> optionalResponse = officeSearchService.getBenefitCentreByJobCentreId(TestDataFixture.JOB_CENTRE_ID);

        assertThat(optionalResponse.isPresent(), is(equalTo(false)));
    }

}
