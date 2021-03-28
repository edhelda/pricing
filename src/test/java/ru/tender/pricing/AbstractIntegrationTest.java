package ru.tender.pricing;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import ru.tender.pricing.repository.PricingRepository;

import javax.annotation.PostConstruct;

@ActiveProfiles("test")
@SpringBootTest(classes = PricingApplication.class)
public class AbstractIntegrationTest {

    @Autowired
    protected WebApplicationContext webApplicationContext;

    @Autowired
    protected PricingRepository pricingRepository;

    @Autowired
    protected ObjectMapper objectMapper;

    protected MockMvc mockMvc;

    @PostConstruct
    public void init() {
        this.mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .build();
    }
}
