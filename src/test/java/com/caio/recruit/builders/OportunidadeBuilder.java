package com.caio.recruit.builders;

import com.caio.recruit.models.Empresa;
import com.caio.recruit.models.Oportunidade;

import java.time.LocalDateTime;

public class OportunidadeBuilder {
    private Oportunidade oportunidade;

    private OportunidadeBuilder(){}

    public static OportunidadeBuilder umaOportunidade() {
        var builder = new OportunidadeBuilder();
        builder.oportunidade = new Oportunidade();
        builder.oportunidade.setCargo("cargo");
        builder.oportunidade.setAtribuicoes("attr. cargo");
        builder.oportunidade.setBeneficios("benef. cargo");
        builder.oportunidade.setDataCriacaoVaga(LocalDateTime.now());
        builder.oportunidade.setDataExpiracaoVaga(LocalDateTime.now());
        builder.oportunidade.setHoraEntrada("12:00");
        builder.oportunidade.setHoraSaida("16:00");
        builder.oportunidade.setLocalTrabalho("remoto");
        builder.oportunidade.setSalario("1000");
        builder.oportunidade.setEmpresa(new Empresa("empresa"));
        builder.oportunidade.setEhUrgente(false);
        return builder;
    }

    public OportunidadeBuilder semEmpresa() {
        this.oportunidade.setEmpresa(null);
        return this;
    }
    public Oportunidade agora() {
        return this.oportunidade;
    }
}
