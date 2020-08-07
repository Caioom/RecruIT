package com.caio.recruit.resources;

import com.caio.recruit.services.interfaces.CalculadoraValeTransporteInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.caio.recruit.exceptions.CalculadoraException;
import com.caio.recruit.models.ValeTransporte;


@RestController
@RequestMapping("v1")
@CrossOrigin("*")
public class CalculadoraResource {

	private final CalculadoraValeTransporteInterface calculadoraService;

	public CalculadoraResource(final CalculadoraValeTransporteInterface calculadoraService) {
		this.calculadoraService = calculadoraService;
	}

	@PostMapping("vale")
	public ResponseEntity<String> calcularValeTransporte(@RequestBody ValeTransporte vale) {
		try {
			Double result = this.calculadoraService.calcular(vale);
			
			return ResponseEntity.ok().body(String.valueOf(result));
		} catch (CalculadoraException e) {
			return ResponseEntity.badRequest().body(String.valueOf(e.getMessage()));
		}
	}

	@GetMapping("vale")
	public ResponseEntity<String> calcularExcedente(@RequestParam("salario") Double salario, @RequestParam("vale") Double vale) {
		double excedente = 0;
		try {
			excedente = this.calculadoraService.calcular(salario, vale);
		} catch (CalculadoraException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}

		return ResponseEntity.ok(String.valueOf(excedente));
	}
}
