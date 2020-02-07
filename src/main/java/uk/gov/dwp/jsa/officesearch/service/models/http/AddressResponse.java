package uk.gov.dwp.jsa.officesearch.service.models.http;

import static org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode;

public class AddressResponse {

    private String firstLine;
    private String secondLine;
    private String town;
    private String postcode;

    public AddressResponse(
            final String firstLine,
            final String secondLine,
            final String town,
            final String postcode
    ) {
        this.firstLine = firstLine;
        this.secondLine = secondLine;
        this.town = town;
        this.postcode = postcode;
    }

    public String getFirstLine() {
        return firstLine;
    }

    public void setFirstLine(final String firstLine) {
        this.firstLine = firstLine;
    }

    public String getSecondLine() {
        return secondLine;
    }

    public void setSecondLine(final String secondLine) {
        this.secondLine = secondLine;
    }

    public String getTown() {
        return town;
    }

    public void setTown(final String town) {
        this.town = town;
    }

    public String getPostCode() {
        return postcode;
    }

    public void setPostCode(final String postcode) {
        this.postcode = postcode;
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
