package com.caio.recruit.resources;

import com.caio.recruit.dtos.EmpresaDto;
import com.caio.recruit.models.Empresa;
import com.caio.recruit.services.EmpresaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1")
@CrossOrigin("*")
public class EmpresaResource {
    private final EmpresaService empresaService;

    public EmpresaResource(final EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @PostMapping("empresa")
    public ResponseEntity<Void> registrarNovaEmpresa(@RequestBody EmpresaDto empresaDto) {
        var empresa = new Empresa(empresaDto);

        this.empresaService.salvar(empresa);
        return ResponseEntity.ok().build();
    }
}
