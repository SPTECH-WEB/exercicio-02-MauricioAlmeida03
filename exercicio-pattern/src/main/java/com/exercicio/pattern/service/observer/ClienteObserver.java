package com.exercicio.pattern.service.observer;

public class ClienteObserver implements ObservadorEntrega {
    @Override
    public void notificar() {
        System.out.println("Cliente notificado: sua entrega foi processada.");
    }
}
