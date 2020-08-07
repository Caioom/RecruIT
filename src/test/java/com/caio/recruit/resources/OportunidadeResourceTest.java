package com.caio.recruit.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static com.caio.recruit.builders.OportunidadeDtoBuilder.umaOportunidadeDto;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class OportunidadeResourceTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void deveCriarNovaOportunidade() throws Exception {
        var oportunidadeDto = umaOportunidadeDto().agora();
        var objectMapper = new ObjectMapper();

        this.mockMvc.perform(
                    post("/v1/oportunidade")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(oportunidadeDto)))
                    .andExpect(status().isOk());
    }
}
