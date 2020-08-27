package com.caio.recruit.resources;

import static java.lang.Double.parseDouble;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.caio.recruit.models.ValeTransporte;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class CalculadoraResourceTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void deveCalcularValeTransporte() throws JsonProcessingException, Exception {
		int diasTrabalhados = 1;
		double valorPassagem = 4.0;
		int qtdOnibus = 2;
		ValeTransporte valeTransporte = new ValeTransporte(valorPassagem, diasTrabalhados, qtdOnibus);

		ObjectMapper objectMapper = new ObjectMapper();
    	
		MvcResult result = this.mockMvc.perform(
				post("/v1/vale")
							.contentType(MediaType.APPLICATION_JSON)
							.content(objectMapper.writeValueAsString(valeTransporte)))
							.andExpect(status().isOk())
							.andReturn();
		
		double valor = parseDouble(result.getResponse().getContentAsString());
		assertThat(valor).isEqualTo(8);
	}
	
	@Test
	public void naoDeveCalcularMaisDe31DiasDeTrabalho() throws JsonProcessingException, Exception {
		int diasTrabalhados = 32;
		double valorPassagem = 4.0;
		int qtdOnibus = 2;
		ValeTransporte valeTransporte = new ValeTransporte(valorPassagem, diasTrabalhados, qtdOnibus);

		ObjectMapper objectMapper = new ObjectMapper();
    	
		MvcResult result = this.mockMvc.perform(
				post("/v1/vale")
							.contentType(MediaType.APPLICATION_JSON)
							.content(objectMapper.writeValueAsString(valeTransporte)))
							.andExpect(status().isBadRequest())
							.andReturn();
		
		String message = result.getResponse().getContentAsString();
		assertThat(message).isEqualTo("O funcionário não trabalha mais que 31 dias!");
	}

	@Test
	public void deveCalcularExcedente() throws Exception {
		double salarioFuncionario = 1000;
		double valeTransporteValor = 100;

		MvcResult result = this.mockMvc.perform(get("/v1/vale?salario=" +
												salarioFuncionario +
												"&vale=" +
												valeTransporteValor))
												.andExpect(status().isOk())
												.andReturn();

		Double valor = Double.parseDouble(result.getResponse().getContentAsString());
		assertThat(valor).isEqualTo(40);
	}
}
