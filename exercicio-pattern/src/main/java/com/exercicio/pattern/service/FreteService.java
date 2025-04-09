package com.exercicio.pattern.service;

import com.exercicio.pattern.service.adapter.TransportadoraAdapter;
import com.exercicio.pattern.service.adapter.TransportadoraApi;
import com.exercicio.pattern.service.observer.ClienteObserver;
import com.exercicio.pattern.service.observer.EquipeObserver;
import com.exercicio.pattern.service.observer.NotificadorEntrega;
import com.exercicio.pattern.service.strategy.EconomicaStrategy;
import com.exercicio.pattern.service.strategy.ExpressaStrategy;
import com.exercicio.pattern.service.strategy.FreteStrategy;
import com.exercicio.pattern.service.strategy.TerceirizadaStrategy;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class FreteService {

    private final Map<String, FreteStrategy> estrategias = new HashMap<>();
    private final NotificadorEntrega notificadorEntrega;

    public FreteService(NotificadorEntrega notificadorEntrega) {
        estrategias.put("expressa", new ExpressaStrategy());
        estrategias.put("economica", new EconomicaStrategy());
        estrategias.put("terceirizada", new TerceirizadaStrategy(new TransportadoraAdapter(new TransportadoraApi())));
        this.notificadorEntrega = notificadorEntrega;

        // Registrar observadores
        notificadorEntrega.registrar(new ClienteObserver());
        notificadorEntrega.registrar(new EquipeObserver());
    }

    public double processarEntrega(double peso, String modalidade) {
        FreteStrategy strategy = estrategias.get(modalidade.toLowerCase());
        if (strategy == null) throw new IllegalArgumentException("Modalidade inválida");

        double valor = strategy.calcularFrete(peso);
        notificadorEntrega.notificarTodos();
        return valor;
    }
}
