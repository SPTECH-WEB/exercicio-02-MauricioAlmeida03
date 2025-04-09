package com.exercicio.pattern.service.strategy;

import com.exercicio.pattern.service.adapter.TransportadoraAdapter;

public class TerceirizadaStrategy implements FreteStrategy {
    private final TransportadoraAdapter adapter;

    public TerceirizadaStrategy(TransportadoraAdapter adapter) {
        this.adapter = adapter;
    }

    @Override
    public Double calcularFrete(Double peso) {
        return adapter.calcularFreteExterno(peso);
    }
}
