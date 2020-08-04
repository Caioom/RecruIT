package com.caio.recruit.dtos;


import com.caio.recruit.models.Empresa;
import com.caio.recruit.models.Oportunidade;

import java.time.LocalDateTime;

public class OportunidadeDto {
    private Long id;
    private String cargo;
    private String atribuicoes;
    private String salario;
    private String beneficios;
    private String horaEntrada;
    private String horaSaida;
    private String localTrabalho;
    private String dataExpiracaoVaga;
    private String dataCriacaoVaga;
    private Empresa empresa;
    private Integer vagas;
    private boolean ehUrgente;

    public OportunidadeDto() {}

    public OportunidadeDto(Oportunidade oportunidade) {
        this.atribuicoes = oportunidade.getAtribuicoes();
        this.beneficios = oportunidade.getBeneficios();
        this.cargo = oportunidade.getCargo();
        this.dataCriacaoVaga = oportunidade.getDataCriacaoVaga().toString();
        this.dataExpiracaoVaga = oportunidade.getDataExpiracaoVaga().toString();
        this.ehUrgente = oportunidade.isEhUrgente();
        this.horaEntrada = oportunidade.getHoraEntrada();
        this.horaSaida = oportunidade.getHoraSaida();
        this.id = oportunidade.getId();
        this.localTrabalho = oportunidade.getLocalTrabalho();
        this.salario = oportunidade.getSalario();
        this.vagas = oportunidade.getVagas();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getAtribuicoes() {
        return atribuicoes;
    }

    public void setAtribuicoes(String atribuicoes) {
        this.atribuicoes = atribuicoes;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    public String getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(String beneficios) {
        this.beneficios = beneficios;
    }

    public String getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public String getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(String horaSaida) {
        this.horaSaida = horaSaida;
    }

    public String getLocalTrabalho() {
        return localTrabalho;
    }

    public void setLocalTrabalho(String localTrabalho) {
        this.localTrabalho = localTrabalho;
    }

    public String getDataExpiracaoVaga() {
        return dataExpiracaoVaga;
    }

    public void setDataExpiracaoVaga(String dataExpiracaoVaga) {
        this.dataExpiracaoVaga = dataExpiracaoVaga;
    }

    public String getDataCriacaoVaga() {
        return dataCriacaoVaga;
    }

    public void setDataCriacaoVaga(String dataCriacaoVaga) {
        this.dataCriacaoVaga = dataCriacaoVaga;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Integer getVagas() {
        return vagas;
    }

    public void setVagas(Integer vagas) {
        this.vagas = vagas;
    }

    public boolean isEhUrgente() {
        return ehUrgente;
    }

    public void setEhUrgente(boolean ehUrgente) {
        this.ehUrgente = ehUrgente;
    }
}
