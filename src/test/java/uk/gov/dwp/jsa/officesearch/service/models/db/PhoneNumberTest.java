package uk.gov.dwp.jsa.officesearch.service.models.db;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

public class PhoneNumberTest {

    public static final UUID PHONE_NUMBER_ID = UUID.randomUUID();
    public static final String NUMBER = "NUMBER";
    public static final String TYPE = "TYPE";
    public static final LocalDateTime CREATED_TIMESTAMP = LocalDateTime.now();
    public static final LocalDateTime UPDATED_TIMESTAMP = LocalDateTime.now();

    @Test
    public void hasDefaultValues() {
        final PhoneNumber phoneNumber = new PhoneNumber();
        assertThat(phoneNumber.getNumber(), is(nullValue()));
        assertThat(phoneNumber.getType(), is(nullValue()));
        assertThat(phoneNumber.getCreatedTimestamp(), is(nullValue()));
        assertThat(phoneNumber.getUpdatedTimestamp(), is(nullValue()));
        assertThat(phoneNumber.getPhoneNumberId(), is(nullValue()));
    }

    @Test
    public void constructorSetsFieldValues() {
        final PhoneNumber phoneNumber = new PhoneNumber(NUMBER, TYPE, CREATED_TIMESTAMP, UPDATED_TIMESTAMP);
        assertThat(phoneNumber.getNumber(), is(NUMBER));
        assertThat(phoneNumber.getType(), is(TYPE));
        assertThat(phoneNumber.getCreatedTimestamp(), is(CREATED_TIMESTAMP));
        assertThat(phoneNumber.getUpdatedTimestamp(), is(UPDATED_TIMESTAMP));
        assertThat(phoneNumber.getPhoneNumberId(), is(nullValue()));
    }

    @Test
    public void setPhoneNumberId() {
        final PhoneNumber phoneNumber = new PhoneNumber();
        phoneNumber.setPhoneNumberId(PHONE_NUMBER_ID);
        assertThat(phoneNumber.getPhoneNumberId(), is(PHONE_NUMBER_ID));
    }

    @Test
    public void setNumber() {
        final PhoneNumber phoneNumber = new PhoneNumber();
        phoneNumber.setNumber(NUMBER);
        assertThat(phoneNumber.getNumber(), is(NUMBER));
    }

    @Test
    public void setType() {
        final PhoneNumber phoneNumber = new PhoneNumber();
        phoneNumber.setType(TYPE);
        assertThat(phoneNumber.getType(), is(TYPE));
    }

    @Test
    public void setCreatedTimestamp() {
        final PhoneNumber phoneNumber = new PhoneNumber();
        phoneNumber.setCreatedTimestamp(CREATED_TIMESTAMP);
        assertThat(phoneNumber.getCreatedTimestamp(), is(CREATED_TIMESTAMP));
    }

    @Test
    public void setUpdatedTimestamp() {
        final PhoneNumber phoneNumber = new PhoneNumber();
        phoneNumber.setUpdatedTimestamp(UPDATED_TIMESTAMP);
        assertThat(phoneNumber.getUpdatedTimestamp(), is(UPDATED_TIMESTAMP));
    }
}