package uk.gov.dwp.jsa.officesearch.service.services;


import org.junit.Test;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class PostcodeUtilsTest {

    @Test
    public void normalisePostcode_PostcodeWithEmbeddedSpaces_SpacesAreRemoved() {
        assertThat(PostcodeUtils.normalisePostcode(" A B 1 2 C D "), is(equalTo("AB1 2CD")));
    }

    @Test
    public void normalisePostcode_PostcodeWithLowerCaseLetters_AllCharactersAreUpperCase() {
        assertThat(PostcodeUtils.normalisePostcode("ab1 2cd"), is(equalTo("AB1 2CD")));
    }

    @Test
    public void formatPostcode_PostcodeHasMoreThan3Character_SpaceIsInserted() {
        assertThat(PostcodeUtils.formatPostcode("AB12CD"), is(equalTo("AB1 2CD")));
    }

    @Test
    public void formatPostcode_PostcodeHas3Character_PostcodeIsUnchanged() {
        assertThat(PostcodeUtils.formatPostcode("AB1"), is(equalTo("AB1")));
    }

    @Test
    public void createPostcodePartials_PostcodePassedIn_PartialsAreReturned() {
        assertThat(PostcodeUtils.createPostcodePartials("AB1 2CD"), contains(
                "AB1 2CD",
                "AB1 2C",
                "AB1 2",
                "AB1",
                "AB",
                "A"
        ));
    }



}