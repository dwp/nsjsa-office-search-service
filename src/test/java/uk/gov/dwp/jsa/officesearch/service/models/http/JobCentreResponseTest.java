package uk.gov.dwp.jsa.officesearch.service.models.http;

import org.junit.Test;
import uk.gov.dwp.jsa.officesearch.service.models.db.BenefitCentre;
import uk.gov.dwp.jsa.officesearch.service.models.db.JobCentre;
import uk.gov.dwp.jsa.officesearch.service.models.db.PhoneNumber;
import uk.gov.dwp.jsa.officesearch.service.models.db.PostcodeCovered;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.*;

public class JobCentreResponseTest {

    public static final long JOB_CENTRE_ID = 1l;
    public static final String NAME = "NAME";
    public static final BenefitCentreResponse BENEFIT_CENTRE = new BenefitCentreResponse();
    public static final ArrayList<PostcodeCovered> POSTCODES_COVERED = new ArrayList<>();
    public static final ArrayList<PhoneNumberResponse> PHONE_NUMBERS = new ArrayList<>();
    public static final AddressResponse ADDRESS = new AddressResponse(null, null, null, null);


    @Test
    public void constructorSetsFieldValues() {
        final JobCentreResponse jobCentre = new JobCentreResponse(
                JOB_CENTRE_ID, NAME, ADDRESS, BENEFIT_CENTRE, PHONE_NUMBERS);
        assertThat(jobCentre.getJobCentreId(), is(JOB_CENTRE_ID));
        assertThat(jobCentre.getName(), is(NAME));
        assertThat(jobCentre.getAddress(), is(ADDRESS));
        assertThat(jobCentre.getBenefitCentre(), is(BENEFIT_CENTRE));
        assertThat(jobCentre.getPhoneNumbers(), is(PHONE_NUMBERS));
    }

    @Test
    public void setJobCentreId() {
        final JobCentreResponse jobCentre = new JobCentreResponse(null, null, null, null, null);
        jobCentre.setJobCentreId(JOB_CENTRE_ID);
        assertThat(jobCentre.getJobCentreId(), is(JOB_CENTRE_ID));
    }

    @Test
    public void setName() {
        final JobCentreResponse jobCentre = new JobCentreResponse(null, null, null, null, null);
        jobCentre.setName(NAME);
        assertThat(jobCentre.getName(), is(NAME));
    }

    @Test
    public void setAddtress() {
        final JobCentreResponse jobCentre = new JobCentreResponse(null, null, null, null, null);
        jobCentre.setAddress(ADDRESS);
        assertThat(jobCentre.getAddress(), is(ADDRESS));
    }

    @Test
    public void setBenefitCentre() {
        final JobCentreResponse jobCentre = new JobCentreResponse(null, null, null, null, null);
        jobCentre.setBenefitCentre(BENEFIT_CENTRE);
        assertThat(jobCentre.getBenefitCentre(), is(BENEFIT_CENTRE));
    }

    @Test
    public void setPhoneNumbers() {
        final JobCentreResponse jobCentre = new JobCentreResponse(null, null, null, null, null);
        jobCentre.setPhoneNumbers(PHONE_NUMBERS);
        assertThat(jobCentre.getPhoneNumbers(), is(PHONE_NUMBERS));
    }
}