package com.exercicio.pattern.service.strategy;

public class ExpressaStrategy implements FreteStrategy {
    @Override
    public Double calcularFrete(Double peso) {
        return peso * 10.0;
    }
}
