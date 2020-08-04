package com.caio.recruit.controllers;

import com.caio.recruit.models.Oportunidade;
import com.caio.recruit.repository.OportunidadeRepository;
import com.caio.recruit.services.OportunidadeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static com.caio.recruit.builders.OportunidadeBuilder.umaOportunidade;
import static com.caio.recruit.builders.OportunidadeDtoBuilder.umaOportunidadeDto;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class ControllerOportunidadeTest {

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private ControllerOportunidade controllerOportunidade;

    @Mock
    private OportunidadeService oportunidadeService;

    @BeforeEach
    public void setUp() {
        initMocks(this);
    }

    @Test
    public void deveCriarNovaOportunidade() throws Exception {
        var oportunidadeDto = umaOportunidadeDto().agora();
        var objectMapper = new ObjectMapper();

        when(oportunidadeService.salvar(any(Oportunidade.class)))
                                        .thenReturn(umaOportunidade().agora());

        this.mockMvc.perform(
                    post("/v1/oportunidade")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(oportunidadeDto)))
                    .andExpect(status().isOk());
    }
}
