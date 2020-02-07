package uk.gov.dwp.jsa.officesearch.service;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ConstantsTest {

    @Test
    public void constantsFileExists() {
        assertThat(Constants.NO_SECURE_PROFILE, is("nosecure"));
    }

}