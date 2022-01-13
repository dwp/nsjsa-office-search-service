package uk.gov.dwp.jsa.officesearch.service.models.db;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

public class PostcodeCoveredTest {

    public static final UUID POSTCODE_COVERED_ID = UUID.randomUUID();
    public static final String POST_CODE_ZONE = "POST_CODE_ZONE";
    public static final LocalDateTime CREATED_TIMESTAMP = LocalDateTime.now();
    public static final LocalDateTime UPDATED_TIMESTAMP = LocalDateTime.now();
    public static final JobCentre JOB_CENTRE = new JobCentre();

    @Test
    public void hasDefaultValues() {
        final PostcodeCovered postcodeCovered = new PostcodeCovered();
        assertThat(postcodeCovered.getPostcodeCoveredId(), is(nullValue()));
        assertThat(postcodeCovered.getPostcodeZone(), is(nullValue()));
        assertThat(postcodeCovered.getCreatedTimestamp(), is(nullValue()));
        assertThat(postcodeCovered.getUpdatedTimestamp(), is(nullValue()));
        assertThat(postcodeCovered.getJobCentre(), is(nullValue()));
    }

    @Test
    public void constructorSetsFieldValues() {
        final PostcodeCovered postcodeCovered = new PostcodeCovered(POST_CODE_ZONE, CREATED_TIMESTAMP, UPDATED_TIMESTAMP);
        assertThat(postcodeCovered.getPostcodeCoveredId(), is(nullValue()));
        assertThat(postcodeCovered.getPostcodeZone(), is(POST_CODE_ZONE));
        assertThat(postcodeCovered.getCreatedTimestamp(), is(CREATED_TIMESTAMP));
        assertThat(postcodeCovered.getUpdatedTimestamp(), is(UPDATED_TIMESTAMP));
        assertThat(postcodeCovered.getJobCentre(), is(nullValue()));
    }

    @Test
    public void setPostcodeCoveredId() {
        final PostcodeCovered postcodeCovered = new PostcodeCovered();
        postcodeCovered.setPostcodeCoveredId(POSTCODE_COVERED_ID);
        assertThat(postcodeCovered.getPostcodeCoveredId(), is(POSTCODE_COVERED_ID));
    }

    @Test
    public void setPostcodeZone() {
        final PostcodeCovered postcodeCovered = new PostcodeCovered();
        postcodeCovered.setPostcodeZone(POST_CODE_ZONE);
        assertThat(postcodeCovered.getPostcodeZone(), is(POST_CODE_ZONE));
    }

    @Test
    public void setCreatedTimestamp() {
        final PostcodeCovered postcodeCovered = new PostcodeCovered();
        postcodeCovered.setCreatedTimestamp(CREATED_TIMESTAMP);
        assertThat(postcodeCovered.getCreatedTimestamp(), is(CREATED_TIMESTAMP));
    }

    @Test
    public void setUpdatedTimestamp() {
        final PostcodeCovered postcodeCovered = new PostcodeCovered();
        postcodeCovered.setUpdatedTimestamp(UPDATED_TIMESTAMP);
        assertThat(postcodeCovered.getUpdatedTimestamp(), is(UPDATED_TIMESTAMP));
    }

    @Test
    public void setJobCentre() {
        final PostcodeCovered postcodeCovered = new PostcodeCovered();
        postcodeCovered.setJobCentre(JOB_CENTRE);
        assertThat(postcodeCovered.getJobCentre(), is(JOB_CENTRE));
    }
}
