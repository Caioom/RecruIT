package com.caio.recruit.dtos;

import com.caio.recruit.models.Empresa;
import com.caio.recruit.models.Oportunidade;

import java.util.List;

public class EmpresaDto {
    private String nome;
    private List<Oportunidade> oportunidades;

    public EmpresaDto() {}

    public EmpresaDto(Empresa empresa) {
        this.nome = empresa.getNome();
        this.oportunidades = empresa.getOportunidades();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Oportunidade> getOportunidades() {
        return oportunidades;
    }

    public void setOportunidades(List<Oportunidade> oportunidades) {
        this.oportunidades = oportunidades;
    }
}
