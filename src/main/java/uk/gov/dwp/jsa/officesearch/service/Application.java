package uk.gov.dwp.jsa.officesearch.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;
import uk.gov.dwp.jsa.officesearch.service.config.OfficeSearchServiceObjectMapperProvider;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@ComponentScan(value = "uk.gov.dwp.jsa")
public class Application {

    public static void main(final String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public ObjectMapper objectMapper() {
        final OfficeSearchServiceObjectMapperProvider objectMapperProvider =
                new OfficeSearchServiceObjectMapperProvider();
        return objectMapperProvider.get();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
