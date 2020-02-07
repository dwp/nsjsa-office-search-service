package uk.gov.dwp.jsa.officesearch.service.models.http;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

public class AddressResponseTest {

    public static final String FIRST_LINE = "FIRST_LINE";
    public static final String SECOND_LINE = "SECOND_LINE";
    public static final String POSTCODE = "POSTCODE";
    public static final String TOWN = "TOWN";

    @Test
    public void hasDefaultFieldValues() {
        final AddressResponse address = new AddressResponse(null, null, null, null);
        assertThat(address.getFirstLine(), is(nullValue()));
        assertThat(address.getSecondLine(), is(nullValue()));
        assertThat(address.getPostCode(), is(nullValue()));
        assertThat(address.getTown(), is(nullValue()));
    }

    @Test
    public void constuctorSetsFieldValues() {
        final AddressResponse address = new AddressResponse(FIRST_LINE, SECOND_LINE, TOWN, POSTCODE);
        assertThat(address.getFirstLine(), is(FIRST_LINE));
        assertThat(address.getSecondLine(), is(SECOND_LINE));
        assertThat(address.getPostCode(), is(POSTCODE));
        assertThat(address.getTown(), is(TOWN));

    }

    @Test
    public void setFirstLine() {
        final AddressResponse address = new AddressResponse(null, null, null, null);
        address.setFirstLine(FIRST_LINE);
        assertThat(address.getFirstLine(), is(FIRST_LINE));
    }

    @Test
    public void setSecondLine() {
        final AddressResponse address = new AddressResponse(null, null, null, null);
        address.setSecondLine(SECOND_LINE);
        assertThat(address.getSecondLine(), is(SECOND_LINE));
    }

    @Test
    public void setPostCode() {
        final AddressResponse address = new AddressResponse(null, null, null, null);
        address.setPostCode(POSTCODE);
        assertThat(address.getPostCode(), is(POSTCODE));
    }

    @Test
    public void setTown() {
        final AddressResponse address = new AddressResponse(null, null, null, null);
        address.setTown(TOWN);
        assertThat(address.getTown(), is(TOWN));
    }

}