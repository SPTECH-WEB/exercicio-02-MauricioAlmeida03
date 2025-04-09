package com.exercicio.pattern.service.observer;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NotificadorEntrega {
    private final List<ObservadorEntrega> observadores = new ArrayList<>();

    public void registrar(ObservadorEntrega observador) {
        observadores.add(observador);
    }

    public void notificarTodos() {
        observadores.forEach(ObservadorEntrega::notificar);
    }
}
