package com.caio.recruit.models;

import com.caio.recruit.dtos.OportunidadeDto;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

import static java.lang.Integer.parseInt;

@Entity
@Table(name = "oportunidade")
public class Oportunidade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "cargo")
    private String cargo;

    @Column(name = "atribuicoes")
    private String atribuicoes;

    @Column(name = "salario")
    private String salario;

    @Column(name = "beneficios")
    private String beneficios;

    @Column(name = "hora_entrada")
    private String horaEntrada;

    @Column(name = "hora_saida")
    private String horaSaida;

    @Column(name = "local_trabalho")
    private String localTrabalho;

    @Column(name = "data_expiracao_vaga")
    private LocalDateTime dataExpiracaoVaga;

    @Column(name = "data_criacao_vaga")
    private LocalDateTime dataCriacaoVaga;

    @ManyToOne(cascade = CascadeType.ALL)
    private Empresa empresa;

    @Column(name = "qtd_vagas")
    private Integer vagas;

    @Column(name = "eh_urgente")
    private boolean ehUrgente;

    public Oportunidade() {}

    public Oportunidade(OportunidadeDto dto) {
        this.atribuicoes = dto.getAtribuicoes();
        this.beneficios = dto.getBeneficios();
        this.cargo = dto.getCargo();
        this.dataCriacaoVaga = this.converterParaData(dto.getDataCriacaoVaga());
        this.dataExpiracaoVaga = this.converterParaData(dto.getDataExpiracaoVaga());
        this.ehUrgente = dto.isEhUrgente();
        this.horaEntrada = dto.getHoraEntrada();
        this.horaSaida = dto.getHoraSaida();
        this.id = dto.getId();
        this.localTrabalho = dto.getLocalTrabalho();
        this.salario = dto.getSalario();
        this.vagas = dto.getVagas();
        this.empresa = dto.getEmpresa();
    }

    private LocalDateTime converterParaData(String dataString) {
        String[] dataSplit = dataString.split(" ");
        var data = dataSplit[0];
        var horario = dataSplit[1];

        String[] diaMesAno = data.split("/");
        var ano = parseInt(diaMesAno[2]);
        var mes = parseInt(diaMesAno[1]);
        var dia = parseInt(diaMesAno[0]);

        String[] horaMinuto = horario.split(":");
        var hora = parseInt(horaMinuto[0]);
        var minuto = parseInt(horaMinuto[1]);

        var localDateTime = LocalDateTime.of(ano, mes, dia, hora, minuto);
        return localDateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDataCriacaoVaga(LocalDateTime dataCriacaoVaga) {
        this.dataCriacaoVaga = dataCriacaoVaga;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
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

    public LocalDateTime getDataExpiracaoVaga() {
        return dataExpiracaoVaga;
    }

    public void setDataExpiracaoVaga(LocalDateTime dataExpiracaoVaga) {
        this.dataExpiracaoVaga = dataExpiracaoVaga;
    }

    public LocalDateTime getDataCriacaoVaga() {
        return this.dataCriacaoVaga;
    }

    public boolean isEhUrgente() {
        return ehUrgente;
    }

    public void setEhUrgente(boolean ehUrgente) {
        this.ehUrgente = ehUrgente;
    }

    public Integer getVagas() {
        return vagas;
    }

    public void setVagas(Integer vagas) {
        this.vagas = vagas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Oportunidade oportunidade = (Oportunidade) o;
        return Objects.equals(cargo, oportunidade.cargo) &&
                Objects.equals(atribuicoes, oportunidade.atribuicoes) &&
                Objects.equals(salario, oportunidade.salario) &&
                Objects.equals(beneficios, oportunidade.beneficios) &&
                Objects.equals(horaEntrada, oportunidade.horaEntrada) &&
                Objects.equals(horaSaida, oportunidade.horaSaida) &&
                Objects.equals(localTrabalho, oportunidade.localTrabalho) &&
                Objects.equals(dataExpiracaoVaga, oportunidade.dataExpiracaoVaga) &&
                Objects.equals(dataCriacaoVaga, oportunidade.dataCriacaoVaga) &&
                Objects.equals(empresa, oportunidade.empresa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cargo, atribuicoes, salario, beneficios, horaEntrada, horaSaida, localTrabalho, dataExpiracaoVaga, dataCriacaoVaga, empresa);
    }
}