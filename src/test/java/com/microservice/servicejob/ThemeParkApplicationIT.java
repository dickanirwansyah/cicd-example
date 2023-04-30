package com.microservice.servicejob;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.RunWith;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class ThemeParkApplicationIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getAllRides() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/ride")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }
    @Test
    public void getSingleRide() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/ride/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }
    @Test
    public void returnNotFoundForInvalidSingleRide() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/ride/90")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andReturn();
    }
    @Test
    public void addNewRide() throws Exception{
        String payload = "{\"name\" : \"Monorail\", \"description\" : \"level hight\", " +
                "\"thrilFactor\" : 100, \"vomitFactor\" : 90}";
        mockMvc.perform(MockMvcRequestBuilders.post("/ride")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }
}
