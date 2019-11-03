package com.vat.service;

import com.vat.config.WebAppInitializer;
import com.vat.config.WebConfig;
import com.vat.controller.VatController;
import org.apache.tomcat.util.http.parser.MediaType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(WebAppInitializer.class)
@RunWith(SpringJUnit4ClassRunner.class)
@SpringJUnitWebConfig(WebConfig.class)
public class VatServiceWebMockTest {
    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private VatService service;

    @Before
    public void setup() {
        // Setup MockMVC to use our Spring Configuration
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void getDeviceLandingTest() throws Exception {
        this.mockMvc
                .perform(get("/vat"))
                .andExpect(forwardedUrl("default"))
                .andExpect(status().isOk());
    }

    @Test
    public void whenGetRequestSentToAllHeaders_thenStatusOkAndTextReturned() throws Exception {
        mockMvc.perform(get("/vat").header("calculateVat", "Test"))
                .andExpect(status().isOk());
    }


}
