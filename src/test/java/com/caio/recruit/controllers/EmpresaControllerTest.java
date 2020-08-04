package com.caio.recruit.controllers;

import com.caio.recruit.dtos.EmpresaDto;
import com.caio.recruit.models.Empresa;
import com.fasterxml.jackson.core.JsonProcessingException;
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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class EmpresaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void devePersistirNovaEmpresa() throws Exception {
        var empresa = new EmpresaDto();
        var mapper = new ObjectMapper();

        this.mockMvc.perform(post("/v1/empresa")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(mapper.writeValueAsString(empresa)))
                    .andExpect(status().isOk());
    }
}
