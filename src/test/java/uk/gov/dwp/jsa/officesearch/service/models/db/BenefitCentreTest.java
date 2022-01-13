package uk.gov.dwp.jsa.officesearch.service.models.db;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

public class BenefitCentreTest {

    public static final long BENEFIT_CENTRE_ID = 1l;
    public static final String SERVICE_ID = "SERVICE_ID";
    public static final String NAME = "NAME";
    public static final LocalDateTime CREATED_TIMESTAMP = LocalDateTime.now();
    public static final LocalDateTime UPDATED_TIMESTAMP = LocalDateTime.now();
    public static final ArrayList<JobCentre> JOB_CENTRES = new ArrayList<>();

    @Test
    public void hasDefaultValues() {
        final BenefitCentre benefitCentre = new BenefitCentre();
        assertThat(benefitCentre.getBenefitCentreId(), is(nullValue()));
        assertThat(benefitCentre.getServiceId(), is(nullValue()));
        assertThat(benefitCentre.getName(), is(nullValue()));
        assertThat(benefitCentre.getCreatedTimestamp(), is(nullValue()));
        assertThat(benefitCentre.getUpdatedTimestamp(), is(nullValue()));
        assertThat(benefitCentre.getJobCentres(), is(JOB_CENTRES));
    }

    @Test
    public void constructorSetsFieldValues() {
        final BenefitCentre benefitCentre = new BenefitCentre(
                SERVICE_ID, NAME, CREATED_TIMESTAMP, UPDATED_TIMESTAMP);
        assertThat(benefitCentre.getBenefitCentreId(), is(nullValue()));
        assertThat(benefitCentre.getServiceId(), is(SERVICE_ID));
        assertThat(benefitCentre.getName(), is(NAME));
        assertThat(benefitCentre.getCreatedTimestamp(), is(CREATED_TIMESTAMP));
        assertThat(benefitCentre.getUpdatedTimestamp(), is(UPDATED_TIMESTAMP));
        assertThat(benefitCentre.getJobCentres(), is(JOB_CENTRES));
    }

    @Test
    public void setBenefitCentreId() {
        final BenefitCentre benefitCentre = new BenefitCentre();
        benefitCentre.setBenefitCentreId(BENEFIT_CENTRE_ID);
        assertThat(benefitCentre.getBenefitCentreId(), is(BENEFIT_CENTRE_ID));
    }

    @Test
    public void setServiceId() {
        final BenefitCentre benefitCentre = new BenefitCentre();
        benefitCentre.setServiceId(SERVICE_ID);
        assertThat(benefitCentre.getServiceId(), is(SERVICE_ID));
    }

    @Test
    public void setName() {
        final BenefitCentre benefitCentre = new BenefitCentre();
        benefitCentre.setName(NAME);
        assertThat(benefitCentre.getName(), is(NAME));
    }

    @Test
    public void setCreatedTimestamp() {
        final BenefitCentre benefitCentre = new BenefitCentre();
        benefitCentre.setCreatedTimestamp(CREATED_TIMESTAMP);
        assertThat(benefitCentre.getCreatedTimestamp(), is(CREATED_TIMESTAMP));
    }

    @Test
    public void setUpdatedTimestamp() {
        final BenefitCentre benefitCentre = new BenefitCentre();
        benefitCentre.setUpdatedTimestamp(UPDATED_TIMESTAMP);
        assertThat(benefitCentre.getUpdatedTimestamp(), is(UPDATED_TIMESTAMP));
    }

    @Test
    public void setJobCentres() {
        final BenefitCentre benefitCentre = new BenefitCentre();
        benefitCentre.setJobCentres(JOB_CENTRES);
        assertThat(benefitCentre.getJobCentres(), is(JOB_CENTRES));
    }
}
