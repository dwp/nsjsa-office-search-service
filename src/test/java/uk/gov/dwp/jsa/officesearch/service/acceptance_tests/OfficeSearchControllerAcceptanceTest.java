package uk.gov.dwp.jsa.officesearch.service.acceptance_tests;

import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import uk.gov.dwp.jsa.officesearch.service.AppInfo;
import uk.gov.dwp.jsa.officesearch.service.TestDataFixture;
import uk.gov.dwp.jsa.officesearch.service.config.WithVersionUriComponentsBuilder;
import uk.gov.dwp.jsa.officesearch.service.controllers.OfficeSearchController;
import uk.gov.dwp.jsa.officesearch.service.services.OfficeSearchService;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = OfficeSearchController.class)
public class OfficeSearchControllerAcceptanceTest {

    @MockBean
    private OfficeSearchService service;

    @MockBean(name = "appInfo")
    private AppInfo appInfo;

    @MockBean
    private WithVersionUriComponentsBuilder uriBuilder;

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setUp() {
        given(appInfo.getVersion()).willReturn(StringUtils.EMPTY);
        given(uriBuilder.cloneBuilder()).willReturn(new WithVersionUriComponentsBuilder(appInfo));
    }

    @Test
    public void getJobCentreForPostcode_ValidPostcode_JobCentreReturned() throws Exception {

        given(service.getJobCentreForPostcode(any())).willReturn(Optional.of(TestDataFixture.jobCentreResponse()));

        mockMvc.perform(get("/nsjsa/office/job-centre/postcode/w9 1fg")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success.length()").value("1"))
                .andExpect(jsonPath("$.success[0].path").value("/nsjsa/office/job-centre/postcode/w9%201fg"))
                .andExpect(jsonPath("$.success[0].data.jobCentreId").value("10000"))
                .andExpect(jsonPath("$.success[0].data.name").value("job centre name"))
                .andExpect(jsonPath("$.success[0].data.address.firstLine").value("first line"))
                .andExpect(jsonPath("$.success[0].data.address.secondLine").value("second line"))
                .andExpect(jsonPath("$.success[0].data.address.town").value("town"))
                .andExpect(jsonPath("$.success[0].data.address.postCode").value("postcode"))
                .andExpect(jsonPath("$.success[0].data.benefitCentre.benefitCentreId").value("20000"))
                .andExpect(jsonPath("$.success[0].data.benefitCentre.serviceId").value("sid1"))
                .andExpect(jsonPath("$.success[0].data.benefitCentre.name").value("benefit centre"))
                .andExpect(jsonPath("$.success[0].data.phoneNumbers[0].type").value("one"))
                .andExpect(jsonPath("$.success[0].data.phoneNumbers.length()").value("2"))
                .andExpect(jsonPath("$.success[0].data.phoneNumbers[0].number").value("1122334455"))
                .andExpect(jsonPath("$.success[0].data.phoneNumbers[1].type").value("two"))
                .andExpect(jsonPath("$.success[0].data.phoneNumbers[1].number").value("6677889900"))
                .andExpect(status().isOk());
    }

    @Test
    public void getJobCentreForPostcode_MissingPostcode_HttpStatus404() throws Exception {
        mockMvc.perform(get("/nsjsa/office/job-centre/postcode/w9 1xx")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.error.code").value("404 NOT_FOUND"))
                .andExpect(jsonPath("$.error.message").value("Not Found"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void getJobCentreForId_ValidId_JobCentreReturned() throws Exception {

        given(service.getJobCentreForId(anyLong())).willReturn(Optional.of(TestDataFixture.jobCentreResponse()));

        mockMvc.perform(get("/nsjsa/office/job-centre/123")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.success.length()").value("1"))
                .andExpect(jsonPath("$.success[0].path").value("/nsjsa/office/job-centre/123"))
                .andExpect(jsonPath("$.success[0].data.jobCentreId").value("10000"))
                .andExpect(jsonPath("$.success[0].data.name").value("job centre name"))
                .andExpect(jsonPath("$.success[0].data.address.firstLine").value("first line"))
                .andExpect(jsonPath("$.success[0].data.address.secondLine").value("second line"))
                .andExpect(jsonPath("$.success[0].data.address.town").value("town"))
                .andExpect(jsonPath("$.success[0].data.address.postCode").value("postcode"))
                .andExpect(jsonPath("$.success[0].data.benefitCentre.benefitCentreId").value("20000"))
                .andExpect(jsonPath("$.success[0].data.benefitCentre.serviceId").value("sid1"))
                .andExpect(jsonPath("$.success[0].data.benefitCentre.name").value("benefit centre"))
                .andExpect(jsonPath("$.success[0].data.phoneNumbers[0].type").value("one"))
                .andExpect(jsonPath("$.success[0].data.phoneNumbers.length()").value("2"))
                .andExpect(jsonPath("$.success[0].data.phoneNumbers[0].number").value("1122334455"))
                .andExpect(jsonPath("$.success[0].data.phoneNumbers[1].type").value("two"))
                .andExpect(jsonPath("$.success[0].data.phoneNumbers[1].number").value("6677889900"))
                .andExpect(status().isOk());
    }

    @Test
    public void getJobCentreForId_MissingId_HttpStatus404() throws Exception {
        mockMvc.perform(get("/nsjsa/office/job-centre/123")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.error.code").value("404 NOT_FOUND"))
                .andExpect(jsonPath("$.error.message").value("Not Found"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void getBenefitCentreForId_ValidId_BenefitCentreReturned() throws Exception {

        given(service.getBenefitCentreByJobCentreId(anyLong())).willReturn(Optional.of(TestDataFixture.benefitCentreResponse()));

        mockMvc.perform(get("/nsjsa/office/job-centre/123/benefit-centre")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.success.length()").value("1"))
                .andExpect(jsonPath("$.success[0].path").value("/nsjsa/office/job-centre/123/benefit-centre"))
                .andExpect(jsonPath("$.success[0].data.benefitCentreId").value("20000"))
                .andExpect(jsonPath("$.success[0].data.serviceId").value("sid1"))
                .andExpect(jsonPath("$.success[0].data.name").value("benefit centre"))
                .andExpect(status().isOk());
    }

    @Test
    public void getBenefitCentreForId_MissingId_HttpStatus404() throws Exception {
        mockMvc.perform(get("/nsjsa/office/job-centre/123/benefit-centre")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.error.code").value("404 NOT_FOUND"))
                .andExpect(jsonPath("$.error.message").value("Not Found"))
                .andExpect(status().isNotFound());
    }

}
