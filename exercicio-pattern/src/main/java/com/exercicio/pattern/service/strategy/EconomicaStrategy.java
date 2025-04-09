package com.exercicio.pattern.service.strategy;

public class EconomicaStrategy implements FreteStrategy {
    @Override
    public Double calcularFrete(Double peso) {
        return peso * 5.0;
    }
}
