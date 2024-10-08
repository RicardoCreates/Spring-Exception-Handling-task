package de.neuefische.springexceptionhandlingtask;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureMockRestServiceServer;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.servlet.MockMvc;

import java.sql.Timestamp;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureMockRestServiceServer
public class SpringExceptionHandlingTaskApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MockRestServiceServer mockRestServiceServer;

    @Test
    void testGetAnimalSpecies_invalidSpecies() throws Exception {
        mockMvc.perform(get("/api/animals/cat"))
                .andExpect(status().isBadRequest())
                .andExpect(content().json("{\"message\":\"Only 'dog' is allowed\"}"))
                .andExpect(jsonPath("$.timestamp").exists());
    }


    @Test
    void testGetAllAnimals_noAnimals() throws Exception {
        mockMvc.perform(get("/api/animals"))
                .andExpect(status().isBadRequest())
                .andExpect(content().json("{\"message\":\"No Animals found\"}"));
    }

    @Test
    void testGetCarBrand_invalidBrand() throws Exception {
        mockMvc.perform(get("/api/cars/bmw"))
                .andExpect(status().isBadRequest())
                .andExpect(content().json("{\"message\":\"Only 'porsche' allowed\"}"))
                .andExpect(jsonPath("$.timestamp").exists());
    }

    @Test
    void testGetAllCars_noCars() throws Exception {
        mockMvc.perform(get("/api/cars"))
                .andExpect(status().isBadRequest())
                .andExpect(content().json("{\"message\":\"No Cars found\"}"));
    }
}
