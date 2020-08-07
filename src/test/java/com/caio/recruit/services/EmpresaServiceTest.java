package com.caio.recruit.services;

import com.caio.recruit.models.Empresa;
import com.caio.recruit.repository.EmpresaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

public class EmpresaServiceTest {

    @InjectMocks
    private EmpresaService empresaService;

    @Mock
    private EmpresaRepository empresaRepository;

    @BeforeEach
    public void setUp() {
        initMocks(this);
    }

    @Test
    public void deveRegistrarNovaEmpresa() {
        //cenario
        var empresa = new Empresa("empresa");

        when(empresaRepository.save(any(Empresa.class)))
                                    .thenReturn(empresa);

        //acao
        empresaService.salvar(empresa);

        //verficacao
        verify(empresaRepository, times(1)).save(empresa);
    }
}
