package com.exercicio.pattern.service.adapter;

public class TransportadoraAdapter {
    private final TransportadoraApi api;

    public TransportadoraAdapter(TransportadoraApi api) {
        this.api = api;
    }

    public Double calcularFreteExterno(Double peso) {
        return api.calcularPreco(peso);
    }
}
