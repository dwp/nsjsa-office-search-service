package uk.gov.dwp.jsa.officesearch.service.models.http;

import static org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode;

public class BenefitCentreResponse {

    private Long benefitCentreId;
    private String serviceId;
    private String name;

    public BenefitCentreResponse() {
    }

    public BenefitCentreResponse(
            final Long benefitCentreId,
            final String serviceId,
            final String name) {
        this.benefitCentreId = benefitCentreId;
        this.serviceId = serviceId;
        this.name = name;
    }

    public Long getBenefitCentreId() {
        return benefitCentreId;
    }

    public void setBenefitCentreId(final Long benefitCentreId) {
        this.benefitCentreId = benefitCentreId;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(final String serviceId) {
        this.serviceId = serviceId;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    @Override
    public boolean equals(final Object o) {
        return reflectionEquals(this, o);
    }

    @Override
    public int hashCode() {
        return reflectionHashCode(this);
    }
}
