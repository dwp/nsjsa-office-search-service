package uk.gov.dwp.jsa.officesearch.service.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.vladmihalcea.hibernate.type.util.ObjectMapperSupplier;

public class OfficeSearchServiceObjectMapperProvider implements ObjectMapperSupplier {
    @Override
    public ObjectMapper get() {
        ObjectMapper objectMapper = new ObjectMapper().findAndRegisterModules();
        objectMapper.setDateFormat(new StdDateFormat());
        return objectMapper;
    }
}
