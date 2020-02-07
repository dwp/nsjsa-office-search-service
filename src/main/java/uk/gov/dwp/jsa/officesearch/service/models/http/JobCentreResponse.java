package uk.gov.dwp.jsa.officesearch.service.models.http;

import java.util.List;

import static org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode;

public class JobCentreResponse {

    private Long jobCentreId;
    private String name;
    private AddressResponse address;
    private BenefitCentreResponse benefitCentre;
    private List<PhoneNumberResponse> phoneNumbers;

    public JobCentreResponse(
            final Long jobCentreId,
            final String name,
            final AddressResponse address,
            final BenefitCentreResponse benefitCentre,
            final List<PhoneNumberResponse> phoneNumbers
    ) {
        this.jobCentreId = jobCentreId;
        this.name = name;
        this.address = address;
        this.benefitCentre = benefitCentre;
        this.phoneNumbers = phoneNumbers;
    }


    public long getJobCentreId() {
        return jobCentreId;
    }

    public void setJobCentreId(final Long jobCentreId) {
        this.jobCentreId = jobCentreId;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public AddressResponse getAddress() {
        return address;
    }

    public void setAddress(final AddressResponse address) {
        this.address = address;
    }

    public BenefitCentreResponse getBenefitCentre() {
        return benefitCentre;
    }

    public void setBenefitCentre(final BenefitCentreResponse benefitCentre) {
        this.benefitCentre = benefitCentre;
    }

    public List<PhoneNumberResponse> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(final List<PhoneNumberResponse> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
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
