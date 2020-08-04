package com.caio.recruit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.caio.recruit.exceptions.CalculadoraException;
import com.caio.recruit.models.ValeTransporte;
import com.caio.recruit.services.CalculadoraService;

@RestController
@RequestMapping("v1")
@CrossOrigin("*")
public class ControllerCalculadora {
	
	@Autowired
	private CalculadoraService calculadoraService;

	@PostMapping("vale")
	public ResponseEntity<String> calcularValeTransporte(@RequestBody ValeTransporte vale) {
		try {
			Double result = this.calculadoraService.calcularVale(vale);
			
			return ResponseEntity.ok().body(String.valueOf(result));
		} catch (CalculadoraException e) {
			return ResponseEntity.badRequest().body(String.valueOf(e.getMessage()));
		}
	}

	@GetMapping("vale")
	public ResponseEntity<String> calcularExcedente(@RequestParam("salario") Double salario, @RequestParam("vale") Double vale) {
		double excedente = 0;
		try {
			excedente = this.calculadoraService.calcularExcedente(vale, salario);
		} catch (CalculadoraException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}

		return ResponseEntity.ok(String.valueOf(excedente));
	}
}
