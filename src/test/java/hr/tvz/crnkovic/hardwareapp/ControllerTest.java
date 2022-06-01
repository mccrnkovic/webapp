package hr.tvz.crnkovic.hardwareapp;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.transaction.Transactional;

import java.net.URI;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ControllerTest {

    private MockMvc mockMvc;
    private static HardwareCommand hardwareCommand = new HardwareCommand("NEWHW", "22",
            29.99, Hardware.HardwareType.OTHER, 99);
    private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    public ControllerTest(MockMvc mockMvc) {
        this.mockMvc=mockMvc;
    }

    @Test
    void showAll() throws Exception {
        mockMvc.perform(get("/hardware"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
    }

    @Test
    void show() throws Exception {
        mockMvc.perform(get("/hardware/0")
                        .with(user("user")
                                .password("user")
                                .roles("USER"))
                        .with(csrf()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.code").value("0"))
                .andExpect(jsonPath("$.name").value("headphones"))
                .andExpect(jsonPath("$.price").value("229.0"));
    }

    @Test
    void findReviewsByHardwareCode() throws Exception {
        mockMvc.perform(get("/review").with(user("user")
                .password("user")
                .roles("USER"))
                        .param("code", "0")
                        .with(csrf()))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk());
    }

    @Test
    @Transactional
    void save() throws Exception {
        mockMvc.perform(post("/hardware").with(user("admin")
                .password("admin")
                .roles("ADMIN"))
                        .with(csrf())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(hardwareCommand))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isAccepted())
                .andExpect(jsonPath("$.code").value("22"))
                .andExpect(jsonPath("$.name").value("NEWHW"))
                .andExpect(jsonPath("$.price").value("29.99"));
    }

    @Test
    @Transactional
    void deleteHardware() throws Exception {
        mockMvc.perform(delete("/hardware/0")
                        .with(user("admin")
                                .password("admin")
                                .roles("ADMIN"))
                        .with(csrf()))
                .andExpect(status().isNoContent());
    }
}