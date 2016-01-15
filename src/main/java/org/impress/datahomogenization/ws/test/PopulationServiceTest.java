package org.impress.datahomogenization.ws.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.jayway.restassured.config.Config;

@WebAppConfiguration
@ContextConfiguration(classes=Config.class)
public class PopulationServiceTest extends ApplicationTests {
    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;
    
    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .build();
    }

    @Test
    public void validateGetCityPopulation() throws Exception {

        mockMvc.perform(get("/population/city/Abenbury"))
                .andExpect(status().isOk())
                .andExpect(
                        content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.name").value("Abenbury"));

    }  
    
    @Test
    public void validateGetPointPopulation() throws Exception {

        mockMvc.perform(get("/population/point?lat=36.95&long=14.5333"))
                .andExpect(status().isOk())
                .andExpect(
                        content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.population").value(61));

    }  
    
    @Test
    public void validateGetAreaPopulation() throws Exception {

        mockMvc.perform(get("/population/area?lat1=0&long1=70&lat2=0&long2=100&lat3=-80&long3=100&lat4=-80&long4=70"))
                .andExpect(status().isOk())
                .andExpect(
                        content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$[0].population").value(4089));

    }     
}
