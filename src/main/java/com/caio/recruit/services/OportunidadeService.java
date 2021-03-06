package com.caio.recruit.services;

import com.caio.recruit.exceptions.OportunidadeException;
import com.caio.recruit.models.Empresa;
import com.caio.recruit.models.Oportunidade;
import com.caio.recruit.repository.OportunidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OportunidadeService {

    @Autowired
    private OportunidadeRepository oportunidadeRepository;

    public Oportunidade salvar(Oportunidade oportunidade) throws OportunidadeException {
        if(oportunidade.getEmpresa() == null) {
            throw new OportunidadeException("A oportunidade deve ser de alguma empresa");
        }
        return this.oportunidadeRepository.save(oportunidade);
    }

    public void deletarOportunidade(Empresa empresa, Oportunidade oportunidade) throws OportunidadeException {
        var podeExcluir = empresa.getOportunidades().contains(oportunidade) ? true : false;
        if(podeExcluir) {
            this.oportunidadeRepository.delete(oportunidade);
        } else {
            throw new OportunidadeException("Não foi possível deletar essa oportunidade!");
        }
    }
}
