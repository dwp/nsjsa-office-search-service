package uk.gov.dwp.jsa.officesearch.service.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public final class PostcodeUtils {

    private static final int THREE = 3;

    private PostcodeUtils() {
    }

    public static String normalisePostcode(final String postcode) {
        final String squashedUpper = postcode
                .replaceAll("\\s+", "")
                .toUpperCase(Locale.ENGLISH);
        return formatPostcode(squashedUpper);
    }

    public static String formatPostcode(final String postcode) {
        final int postcodeSize = postcode.length();
        if (postcodeSize <= THREE) {
            return postcode;
        }
        return String.format(
                "%s %s",
                postcode.substring(0, postcodeSize - THREE),
                postcode.substring(postcodeSize - THREE)
        );
    }

    public static List<String> createPostcodePartials(final String postcode) {
        List<String> postCodePartials = new ArrayList<>();
        for (int i = postcode.length(); i > 0; i--) {
            final String partial = postcode.substring(0, i);
            if (!partial.endsWith(" ")) {
                postCodePartials.add(partial);
            }
        }
        return postCodePartials;
    }
}
