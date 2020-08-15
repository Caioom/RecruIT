package com.caio.recruit.services;

import com.caio.recruit.exceptions.OportunidadeException;
import com.caio.recruit.models.Empresa;
import com.caio.recruit.models.Oportunidade;
import com.caio.recruit.repository.OportunidadeRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;


import java.util.Arrays;

import static com.caio.recruit.builders.OportunidadeBuilder.umaOportunidade;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

public class OportunidadeServiceTest {

    @InjectMocks
    private OportunidadeService oportunidadeService;

    @Mock
    private OportunidadeRepository oportunidadeRepository;

    @BeforeEach
    public void setUp() {
        initMocks(this);
    }

    @Test
    public void deveCriarNovaOportunidade() throws JsonProcessingException, OportunidadeException {
        //cenario
        var oportunidade = umaOportunidade().agora();
        when(oportunidadeRepository.save(any(Oportunidade.class)))
                            .thenReturn(oportunidade);

        //acao
        this.oportunidadeService.salvar(oportunidade);

        //verificacao
        verify(oportunidadeRepository).save(oportunidade);
    }

    @Test
    public void naoDevePersistirOportunidadeSemUmaEmpresaResponsavel() {
        //cenario
        var oportunidade = umaOportunidade().semEmpresa().agora();

        //acao
        try {
            this.oportunidadeService.salvar(oportunidade);
            fail();
        } catch(OportunidadeException e) {
            //verificacao
            assertThat(e.getMessage()).isEqualTo("A oportunidade deve ser de alguma empresa");
        }
    }

    @Test
    public void deveApagarOportunidadePeloId() {
        //cenario
        var oportunidade = umaOportunidade().agora();
        oportunidade.setId(1L);

        //acao
        this.oportunidadeService.deletar(oportunidade.getId());

        //verificacao
        verify(this.oportunidadeRepository, times(1)).deleteById(oportunidade.getId());
    }

}
