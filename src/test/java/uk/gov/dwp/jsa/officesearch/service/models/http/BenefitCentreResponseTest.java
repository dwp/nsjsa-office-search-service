package uk.gov.dwp.jsa.officesearch.service.models.http;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

public class BenefitCentreResponseTest {

    public static final long BENEFIT_CENTRE_ID = 1l;
    public static final String SERVICE_ID = "SERVICE_ID";
    public static final String NAME = "NAME";

    @Test
    public void hasDefaultValues() {
        final BenefitCentreResponse benefitCentre = new BenefitCentreResponse();
        assertThat(benefitCentre.getBenefitCentreId(), is(nullValue()));
        assertThat(benefitCentre.getServiceId(), is(nullValue()));
        assertThat(benefitCentre.getName(), is(nullValue()));
    }

    @Test
    public void constructorSetsFieldValues() {
        final BenefitCentreResponse benefitCentre = new BenefitCentreResponse(BENEFIT_CENTRE_ID,
                SERVICE_ID, NAME);
        assertThat(benefitCentre.getBenefitCentreId(), is(BENEFIT_CENTRE_ID));
        assertThat(benefitCentre.getServiceId(), is(SERVICE_ID));
        assertThat(benefitCentre.getName(), is(NAME));
    }

    @Test
    public void setBenefitCentreId() {
        final BenefitCentreResponse benefitCentre = new BenefitCentreResponse();
        benefitCentre.setBenefitCentreId(BENEFIT_CENTRE_ID);
        assertThat(benefitCentre.getBenefitCentreId(), is(BENEFIT_CENTRE_ID));
    }

    @Test
    public void setServiceId() {
        final BenefitCentreResponse benefitCentre = new BenefitCentreResponse();
        benefitCentre.setServiceId(SERVICE_ID);
        assertThat(benefitCentre.getServiceId(), is(SERVICE_ID));
    }

    @Test
    public void setName() {
        final BenefitCentreResponse benefitCentre = new BenefitCentreResponse();
        benefitCentre.setName(NAME);
        assertThat(benefitCentre.getName(), is(NAME));
    }

}