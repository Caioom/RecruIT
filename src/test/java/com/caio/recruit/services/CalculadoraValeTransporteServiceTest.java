package com.caio.recruit.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

import com.caio.recruit.services.interfaces.CalculadoraValeTransporteInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.caio.recruit.exceptions.CalculadoraException;
import com.caio.recruit.models.ValeTransporte;

public class CalculadoraValeTransporteServiceTest {
	
	private CalculadoraValeTransporteInterface calculadoraService;

	@BeforeEach
	public void setUp() {
		this.calculadoraService = new CalculadoraValeTransporteService();
	}

    @Test
    public void deveCalcularValorValeTransporte() throws CalculadoraException {
    	//cenario
    	int diasTrabalhados = 1;
    	double valorPassagem = 4.0;
    	int qtdOnibus = 2;
    	ValeTransporte valeTransporte = new ValeTransporte(valorPassagem, diasTrabalhados, qtdOnibus);

    	//acao 
    	double result = this.calculadoraService.calcular(valeTransporte);
    	
    	//verificacao
    	assertThat(result).isEqualTo(8);
    }
    
    @Test
    public void naoDeveCalcularMaisDe31DiasTrabalhados() {
    	//cenario 
		int diasTrabalhados = 32;
		double valorPassagem = 4.0;
		int qtdOnibus = 2;
		ValeTransporte valeTransporte = new ValeTransporte(valorPassagem, diasTrabalhados, qtdOnibus);

		//acao
    	try {
        	this.calculadoraService.calcular(valeTransporte);
        	fail();
    	} catch(CalculadoraException e) {
    		//verificacao
    		assertThat(e.getMessage()).isEqualTo("O funcionário não trabalha mais que 31 dias!");
    	}
    }

    @Test
	public void deveCalcularValorExcedenteAosSeisPorcentoDoSalarioFuncionario() throws CalculadoraException {
		//cenario
		double valorValeTransporte = 100;
		double salarioFuncionario = 1000;

		//acao
		double excedente = this.calculadoraService.calcular(salarioFuncionario, valorValeTransporte);

		//verificacao
		assertThat(excedente).isEqualTo(40);
	}

	@Test
	public void naoDeveCalcularValeDeValoresNegativos() {
		//cenario
		int diasTrabalhados = 0;
		double valorPassagem = -10;
		int qtdOnibus = -2;
		ValeTransporte valeTransporte = new ValeTransporte(valorPassagem, diasTrabalhados, qtdOnibus);

		//acao
		try {
			this.calculadoraService.calcular(valeTransporte);
			fail();
		} catch (CalculadoraException e) {
			//verificacao
			assertThat(e.getMessage()).isEqualTo("Nenhum valor pode ser negativo!");
		}
	}

	@Test
	public void naoDeveCalcularExcedenteDeValoresNegativos() {
		//cenario
		double salario = -10;
		double valorVale = -100;

		//acao
		try {
			this.calculadoraService.calcular(salario, valorVale);
		} catch (CalculadoraException e) {
			assertThat(e.getMessage()).isEqualTo("Os valores não podem ser negativos!");
		}
	}
}
