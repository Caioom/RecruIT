package com.caio.recruit.services;

import com.caio.recruit.models.Oportunidade;
import com.caio.recruit.repository.OportunidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OportunidadeService {

    @Autowired
    private OportunidadeRepository oportunidadeRepository;

    public Oportunidade salvar(Oportunidade oportunidade) {
        return this.oportunidadeRepository.save(oportunidade);
    }
}
