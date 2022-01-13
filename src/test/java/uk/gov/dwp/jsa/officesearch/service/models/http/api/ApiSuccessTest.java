package uk.gov.dwp.jsa.officesearch.service.models.http.api;

import org.junit.Test;

import java.net.URI;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ApiSuccessTest {

    public static final URI PATH = URI.create("http://www.dav.com");
    public static final Object DATA = new Object();

    @Test
    public void constuctorSetsFieldValues() {
        final ApiSuccess apiSuccess = new ApiSuccess(PATH, DATA);
        assertThat(apiSuccess.getPath(), is(PATH));
        assertThat(apiSuccess.getData(), is(DATA));
    }

    @Test
    public void setPath() {
        final ApiSuccess apiSuccess = new ApiSuccess(null, null);
        apiSuccess.setPath(PATH);
        assertThat(apiSuccess.getPath(), is(PATH));
    }

    @Test
    public void setData() {
        final ApiSuccess apiSuccess = new ApiSuccess(null, null);
        apiSuccess.setData(DATA);
        assertThat(apiSuccess.getData(), is(DATA));
    }
}
