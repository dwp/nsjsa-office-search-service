package uk.gov.dwp.jsa.officesearch.service;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class AppInfoTest {

    public static final String VERSION = "1";

    @Test
    public void getsUnknownVersionForEmptyString() {
        final AppInfo appInfo = new AppInfo("");
        assertThat(appInfo.getVersion(), is("unknown"));
    }

    @Test
    public void getsUnknownVersionForNull() {
        final AppInfo appInfo = new AppInfo(null);
        assertThat(appInfo.getVersion(), is("unknown"));
    }

    @Test
    public void getsVersion() {
        final AppInfo appInfo = new AppInfo(VERSION);
        assertThat(appInfo.getVersion(), is("v"+VERSION));
    }
}