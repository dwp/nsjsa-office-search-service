package uk.gov.dwp.jsa.officesearch.service.models.db;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

public class JobCentreTest {

    public static final UUID JCP_ID = UUID.randomUUID();;
    public static final long JOB_CENTRE_ID = 1l;
    public static final String NAME = "NAME";
    public static final String FIRST_LINE = "FIRST_LINE";
    public static final String SECOND_LINE = "SECOND_LINE";
    public static final String TOWN = "TOWN";
    public static final String POST_CODE = "POST_CODE";
    public static final LocalDateTime CREATED_TIMESTAMP = LocalDateTime.now();
    public static final LocalDateTime UPDATED_TIMESTAMP = LocalDateTime.now();
    public static final BenefitCentre BENEFIT_CENTRE = new BenefitCentre();
    public static final ArrayList<PostcodeCovered> POSTCODES_COVERED = new ArrayList<>();
    public static final ArrayList<PhoneNumber> PHONE_NUMBERS = new ArrayList<>();

    @Test
    public void hasDefaultValues() {
        final JobCentre jobCentre = new JobCentre();
        assertThat(jobCentre.getId(), is(nullValue()));
        assertThat(jobCentre.getJobCentreId(), is(nullValue()));
        assertThat(jobCentre.getName(), is(nullValue()));
        assertThat(jobCentre.getFirstLine(), is(nullValue()));
        assertThat(jobCentre.getSecondLine(), is(nullValue()));
        assertThat(jobCentre.getTown(), is(nullValue()));
        assertThat(jobCentre.getPostCode(), is(nullValue()));
        assertThat(jobCentre.getCreatedTimestamp(), is(nullValue()));
        assertThat(jobCentre.getUpdatedTimestamp(), is(nullValue()));
        assertThat(jobCentre.getBenefitCentre(), is(nullValue()));
        assertThat(jobCentre.getPostcodesCovered(), is(POSTCODES_COVERED));
        assertThat(jobCentre.getPhoneNumbers(), is(PHONE_NUMBERS));
    }

    @Test
    public void constructorSetsFieldValues() {
        final JobCentre jobCentre = new JobCentre(
                NAME, FIRST_LINE, SECOND_LINE, TOWN, POST_CODE,
                BENEFIT_CENTRE, PHONE_NUMBERS, CREATED_TIMESTAMP, UPDATED_TIMESTAMP);
        assertThat(jobCentre.getId(), is(nullValue()));
        assertThat(jobCentre.getJobCentreId(), is(nullValue()));
        assertThat(jobCentre.getName(), is(NAME));
        assertThat(jobCentre.getFirstLine(), is(FIRST_LINE));
        assertThat(jobCentre.getSecondLine(), is(SECOND_LINE));
        assertThat(jobCentre.getTown(), is(TOWN));
        assertThat(jobCentre.getPostCode(), is(POST_CODE));
        assertThat(jobCentre.getCreatedTimestamp(), is(CREATED_TIMESTAMP));
        assertThat(jobCentre.getUpdatedTimestamp(), is(UPDATED_TIMESTAMP));
        assertThat(jobCentre.getBenefitCentre(), is(BENEFIT_CENTRE));
        assertThat(jobCentre.getPostcodesCovered(), is(POSTCODES_COVERED));
        assertThat(jobCentre.getPhoneNumbers(), is(PHONE_NUMBERS));
    }

    @Test
    public void setJcpId() {
        final JobCentre jobCentre = new JobCentre();
        jobCentre.setId(JCP_ID);
        assertThat(jobCentre.getId(), is(JCP_ID));
    }

    @Test
    public void setJobCentreId() {
        final JobCentre jobCentre = new JobCentre();
        jobCentre.setJobCentreId(JOB_CENTRE_ID);
        assertThat(jobCentre.getJobCentreId(), is(JOB_CENTRE_ID));
    }

    @Test
    public void setName() {
        final JobCentre jobCentre = new JobCentre();
        jobCentre.setName(NAME);
        assertThat(jobCentre.getName(), is(NAME));
    }

    @Test
    public void setFirstLine() {
        final JobCentre jobCentre = new JobCentre();
        jobCentre.setFirstLine(FIRST_LINE);
        assertThat(jobCentre.getFirstLine(), is(FIRST_LINE));
    }

    @Test
    public void setSecondLine() {
        final JobCentre jobCentre = new JobCentre();
        jobCentre.setSecondLine(SECOND_LINE);
        assertThat(jobCentre.getSecondLine(), is(SECOND_LINE));
    }

    @Test
    public void setTown() {
        final JobCentre jobCentre = new JobCentre();
        jobCentre.setTown(TOWN);
        assertThat(jobCentre.getTown(), is(TOWN));
    }

    @Test
    public void setPostCode() {
        final JobCentre jobCentre = new JobCentre();
        jobCentre.setPostCode(POST_CODE);
        assertThat(jobCentre.getPostCode(), is(POST_CODE));
    }

    @Test
    public void setCreatedTimestamp() {
        final JobCentre jobCentre = new JobCentre();
        jobCentre.setCreatedTimestamp(CREATED_TIMESTAMP);
        assertThat(jobCentre.getCreatedTimestamp(), is(CREATED_TIMESTAMP));
    }

    @Test
    public void setUpdatedTimestamp() {
        final JobCentre jobCentre = new JobCentre();
        jobCentre.setUpdatedTimestamp(UPDATED_TIMESTAMP);
        assertThat(jobCentre.getUpdatedTimestamp(), is(UPDATED_TIMESTAMP));
    }

    @Test
    public void setBenefitCentre() {
        final JobCentre jobCentre = new JobCentre();
        jobCentre.setBenefitCentre(BENEFIT_CENTRE);
        assertThat(jobCentre.getBenefitCentre(), is(BENEFIT_CENTRE));
    }

    @Test
    public void setPostcodesCovered() {
        final JobCentre jobCentre = new JobCentre();
        jobCentre.setPostcodesCovered(POSTCODES_COVERED);
        assertThat(jobCentre.getPostcodesCovered(), is(POSTCODES_COVERED));
    }

    @Test
    public void setPhoneNumbers() {
        final JobCentre jobCentre = new JobCentre();
        jobCentre.setPhoneNumbers(PHONE_NUMBERS);
        assertThat(jobCentre.getPhoneNumbers(), is(PHONE_NUMBERS));
    }
}
