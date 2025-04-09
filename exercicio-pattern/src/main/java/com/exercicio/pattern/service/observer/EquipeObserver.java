package com.exercicio.pattern.service.observer;

public class EquipeObserver implements ObservadorEntrega {
    @Override
    public void notificar() {
        System.out.println("Equipe notificada: Nova entrega processada!");
    }
}
