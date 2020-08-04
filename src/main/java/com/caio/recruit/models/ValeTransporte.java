package com.caio.recruit.models;

import java.util.Objects;

public class ValeTransporte {
	private Double valorPassagem;
	private Integer diasTrabalhados;
	private Integer qtdOnibus;
	
	public ValeTransporte(Double valorPassagem, Integer diasTrabalhados, Integer qtdOnibus) {
		this.valorPassagem = valorPassagem;
		this.diasTrabalhados = diasTrabalhados;
		this.qtdOnibus = qtdOnibus;
	}
	
	public Double getValorPassagem() {
		return valorPassagem;
	}
	public void setValorPassagem(Double valorPassagem) {
		this.valorPassagem = valorPassagem;
	}
	public Integer getDiasTrabalhados() {
		return diasTrabalhados;
	}
	public void setDiasTrabalhados(Integer diasTrabalhados) {
		this.diasTrabalhados = diasTrabalhados;
	}
	public Integer getQtdOnibus() {
		return qtdOnibus;
	}
	public void setQtdOnibus(Integer qtdOnibus) {
		this.qtdOnibus = qtdOnibus;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ValeTransporte that = (ValeTransporte) o;
		return Objects.equals(valorPassagem, that.valorPassagem) &&
				Objects.equals(diasTrabalhados, that.diasTrabalhados) &&
				Objects.equals(qtdOnibus, that.qtdOnibus);
	}

	@Override
	public int hashCode() {
		return Objects.hash(valorPassagem, diasTrabalhados, qtdOnibus);
	}
}
