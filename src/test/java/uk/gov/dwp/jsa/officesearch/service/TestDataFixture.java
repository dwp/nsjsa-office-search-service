package uk.gov.dwp.jsa.officesearch.service;

import uk.gov.dwp.jsa.officesearch.service.models.db.BenefitCentre;
import uk.gov.dwp.jsa.officesearch.service.models.db.JobCentre;
import uk.gov.dwp.jsa.officesearch.service.models.db.PhoneNumber;
import uk.gov.dwp.jsa.officesearch.service.models.db.PostcodeCovered;
import uk.gov.dwp.jsa.officesearch.service.models.http.AddressResponse;
import uk.gov.dwp.jsa.officesearch.service.models.http.BenefitCentreResponse;
import uk.gov.dwp.jsa.officesearch.service.models.http.JobCentreResponse;
import uk.gov.dwp.jsa.officesearch.service.models.http.PhoneNumberResponse;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class TestDataFixture {

    public static final String POST_CODE = "GG15FG";
    public static final String NORMALISED_POST_CODE = "GG1 5FG";
    public static final String POST_CODE_WITH_SPACES = " GG1 5F G ";
    public static final Long JOB_CENTRE_ID = 10000L;
    public static final Long BENEFIT_CENTRE_ID = 20000L;
    public static final String SERVICE_ID = "sid1";
    public static final LocalDateTime NOW = LocalDateTime.now();


    public static PostcodeCovered postcodeCovered() {
        PostcodeCovered postcodeCovered = new PostcodeCovered(
                POST_CODE_WITH_SPACES,
                NOW,
                NOW
        );
        postcodeCovered.setJobCentre(jobCentre());
        return postcodeCovered;
    }

    public static JobCentre jobCentre() {
        JobCentre jobCentre = new JobCentre(
                "job centre name",
                "first line",
                "second line",
                "town",
                "postcode",
                benefitCentre(),
                phoneNumbers(),
                NOW,
                NOW
        );
        jobCentre.setJobCentreId(JOB_CENTRE_ID);
        jobCentre.setBenefitCentre(benefitCentre());
        return jobCentre;
    }

    public static BenefitCentre benefitCentre() {
        BenefitCentre benefitCentre = new BenefitCentre(
                SERVICE_ID,
                "benefit centre",
                NOW,
                NOW
        );
        benefitCentre.setBenefitCentreId(BENEFIT_CENTRE_ID);
        return benefitCentre;
    }

    public static List<PhoneNumber> phoneNumbers() {
        return Arrays.asList(
          new PhoneNumber("1122334455", "one", NOW, NOW),
          new PhoneNumber("6677889900", "two", NOW, NOW)
        );
    }

    public static JobCentreResponse jobCentreResponse() {
        return new JobCentreResponse(
                JOB_CENTRE_ID,
                "job centre name",
                addressResponse(),
                benefitCentreResponse(),
                phoneNumbersResponse()
        );
    }

    public static AddressResponse addressResponse() {
        return new AddressResponse(
                "first line",
                "second line",
                "town",
                "postcode"
        );
    }

    public static BenefitCentreResponse benefitCentreResponse() {
        BenefitCentreResponse benefitCentreResponse = new BenefitCentreResponse(
                BENEFIT_CENTRE_ID,
                SERVICE_ID,
                "benefit centre"
        );
        return benefitCentreResponse;
    }

    public static List<PhoneNumberResponse> phoneNumbersResponse() {
        return Arrays.asList(
                new PhoneNumberResponse("1122334455", "one"),
                new PhoneNumberResponse("6677889900", "two")
        );
    }
}
