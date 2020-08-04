package com.caio.recruit.controllers;

import com.caio.recruit.dtos.EmpresaDto;
import com.caio.recruit.models.Empresa;
import com.caio.recruit.services.EmpresaService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1")
@CrossOrigin("*")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @PostMapping("empresa")
    public ResponseEntity<Void> registrarNovaEmpresa(@RequestBody EmpresaDto empresaDto) {
        var empresa = new Empresa(empresaDto);

        this.empresaService.salvar(empresa);
        return ResponseEntity.ok().build();
    }
}
