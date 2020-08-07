package com.caio.recruit.services.interfaces;

import com.caio.recruit.exceptions.CalculadoraException;
import com.caio.recruit.models.ValeTransporte;

public interface CalculadoraValeTransporteInterface {

    double calcular(ValeTransporte valeTransporte) throws CalculadoraException;

    double calcular(double salarioFuncionario, double valorVale) throws CalculadoraException;
}
