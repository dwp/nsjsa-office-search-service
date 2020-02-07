package uk.gov.dwp.jsa.officesearch.service.models.http;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PhoneNumberResponseTest {

    public static final String NUMBER = "NUMBER";
    public static final String TYPE = "TYPE";

    @Test
    public void constructorSetsFieldValues() {
        final PhoneNumberResponse phoneNumber = new PhoneNumberResponse(NUMBER, TYPE);
        assertThat(phoneNumber.getNumber(), is(NUMBER));
        assertThat(phoneNumber.getType(), is(TYPE));
    }

    @Test
    public void setNumber() {
        final PhoneNumberResponse phoneNumber = new PhoneNumberResponse(null, null);
        phoneNumber.setNumber(NUMBER);
        assertThat(phoneNumber.getNumber(), is(NUMBER));
    }

    @Test
    public void setType() {
        final PhoneNumberResponse phoneNumber = new PhoneNumberResponse(null, null);
        phoneNumber.setType(TYPE);
        assertThat(phoneNumber.getType(), is(TYPE));
    }

}