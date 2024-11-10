package org;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class MetricsControllerTest {
    @Autowired private MockMvc mockMvc;
    
    @Test
    public void testMetrics() throws Exception {
        mockMvc.perform(post("/api/v1/metrics/test"))
               .andExpect(status().isOk());
        
        mockMvc.perform(get("/api/v1/metrics"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.test").value(1));
    } // Teste não limpa o estado
}
