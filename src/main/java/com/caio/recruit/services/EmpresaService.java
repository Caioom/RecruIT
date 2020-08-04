package com.caio.recruit.services;

import com.caio.recruit.models.Empresa;
import com.caio.recruit.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    public Empresa salvar(Empresa empresa) {
        return this.empresaRepository.save(empresa);
    }
}
