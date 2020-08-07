package com.caio.recruit.builders;

import com.caio.recruit.dtos.OportunidadeDto;
import com.caio.recruit.models.Empresa;

import java.time.LocalDateTime;

public class OportunidadeDtoBuilder {
    private OportunidadeDto oportunidadeDto;

    private OportunidadeDtoBuilder() {}

    public static OportunidadeDtoBuilder umaOportunidadeDto() {
        var builder = new OportunidadeDtoBuilder();
        builder.oportunidadeDto = new OportunidadeDto();
        builder.oportunidadeDto.setCargo("cargo");
        builder.oportunidadeDto.setAtribuicoes("attr. cargo");
        builder.oportunidadeDto.setBeneficios("benef. cargo");
        builder.oportunidadeDto.setDataCriacaoVaga("01/01/2021 00:00");
        builder.oportunidadeDto.setDataExpiracaoVaga("02/01/2021 00:00");
        builder.oportunidadeDto.setHoraEntrada("12:00");
        builder.oportunidadeDto.setHoraSaida("16:00");
        builder.oportunidadeDto.setLocalTrabalho("remoto");
        builder.oportunidadeDto.setSalario("1000");
        builder.oportunidadeDto.setEmpresa(new Empresa("empresa"));
        builder.oportunidadeDto.setVagas(5);
        builder.oportunidadeDto.setEhUrgente(false);
        return builder;
    }

    public OportunidadeDto agora() {
        return this.oportunidadeDto;
    }
}
