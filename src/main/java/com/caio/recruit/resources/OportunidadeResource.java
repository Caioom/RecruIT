package com.caio.recruit.resources;

import com.caio.recruit.dtos.OportunidadeDto;
import com.caio.recruit.exceptions.OportunidadeException;
import com.caio.recruit.models.Oportunidade;
import com.caio.recruit.services.OportunidadeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1")
@CrossOrigin("*")
public class OportunidadeResource {

    private final OportunidadeService oportunidadeService;

    public OportunidadeResource(final OportunidadeService oportunidadeService) {
        this.oportunidadeService = oportunidadeService;
    }

    @PostMapping("oportunidade")
    public ResponseEntity<String> cadastrarNovaOportunidade(@RequestBody OportunidadeDto oportunidadeDto) {
        var oportunidade = new Oportunidade(oportunidadeDto);
        try {
            this.oportunidadeService.salvar(oportunidade);
        } catch (OportunidadeException e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

        return ResponseEntity.ok().build();
    }
}
