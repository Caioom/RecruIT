package com.caio.recruit.controllers;

import com.caio.recruit.dtos.OportunidadeDto;
import com.caio.recruit.models.Oportunidade;
import com.caio.recruit.services.OportunidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1")
@CrossOrigin("*")
public class ControllerOportunidade {

    @Autowired
    private OportunidadeService oportunidadeService;

    @PostMapping("oportunidade")
    public ResponseEntity<Void> cadastrarNovaOportunidade(@RequestBody OportunidadeDto oportunidadeDto) {
        var oportunidade = new Oportunidade(oportunidadeDto);

        this.oportunidadeService.salvar(oportunidade);
        return ResponseEntity.ok().build();
    }
}
