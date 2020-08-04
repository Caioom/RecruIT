package com.caio.recruit.services;

import com.caio.recruit.models.Oportunidade;
import com.caio.recruit.repository.OportunidadeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;




import static com.caio.recruit.builders.OportunidadeBuilder.umaOportunidade;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
    public void deveCriarNovaOportunidade() {
        //cenario
        var oportunidade = umaOportunidade().agora();
        when(oportunidadeRepository.save(any(Oportunidade.class)))
                            .thenReturn(oportunidade);

        //acao
        this.oportunidadeService.salvar(oportunidade);

        //verificacao
        verify(oportunidadeRepository).save(oportunidade);
    }
}
