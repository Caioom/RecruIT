package com.caio.recruit.services;

import com.caio.recruit.exceptions.CalculadoraException;
import com.caio.recruit.models.ValeTransporte;
import com.caio.recruit.services.interfaces.CalculadoraValeTransporteInterface;
import org.springframework.stereotype.Service;

@Service
public class CalculadoraValeTransporteService implements CalculadoraValeTransporteInterface {
    @Override
    public double calcular(ValeTransporte valeTransporte) throws CalculadoraException {
        if(valeTransporte.getDiasTrabalhados() > 31) {
            throw new CalculadoraException("O funcionário não trabalha mais que 31 dias!");
        } else if(valeTransporte.getDiasTrabalhados() < 0 ||
                    valeTransporte.getValorPassagem() < 0 ||
                    valeTransporte.getQtdOnibus() < 0) {
            throw new CalculadoraException("Nenhum valor pode ser negativo!");
        }

        return valeTransporte.getDiasTrabalhados() * valeTransporte.getQtdOnibus() * valeTransporte.getValorPassagem();
    }

    @Override
    public double calcular(double salarioFuncionario, double valorVale) throws CalculadoraException {
        return valorVale - salarioFuncionario * 0.06;
    }
}
