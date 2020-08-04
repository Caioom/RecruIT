package com.caio.recruit.services;

import org.springframework.stereotype.Service;

import com.caio.recruit.exceptions.CalculadoraException;
import com.caio.recruit.models.ValeTransporte;

@Service
public class CalculadoraService {

	public Double calcularVale(ValeTransporte vale) throws CalculadoraException {
		if(vale.getDiasTrabalhados() > 31) {
			throw new CalculadoraException("O funcionário não trabalha mais que 31 dias!");
		} else if(vale.getDiasTrabalhados() < 0 ||
						vale.getQtdOnibus() < 0 ||
						vale.getValorPassagem() < 0) {

			throw new CalculadoraException("Nenhum valor pode ser negativo!");
		}
		
		return vale.getValorPassagem() * vale.getDiasTrabalhados() * vale.getQtdOnibus();
	}

	public Double calcularExcedente(double valorValeTransporte, double salarioFuncionario) throws CalculadoraException {
		if(valorValeTransporte < 0 || salarioFuncionario < 0) {
			throw new CalculadoraException("Os valores não podem ser negativos!");
		}
		double salarioCobre = salarioFuncionario * 0.06;

		return valorValeTransporte - salarioCobre;
	}

}
