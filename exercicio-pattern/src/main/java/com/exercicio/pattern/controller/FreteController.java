package com.exercicio.pattern.controller;

import com.exercicio.pattern.model.FreteModel;
import com.exercicio.pattern.service.FreteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fretes")
public class FreteController {

    private final FreteService freteService;

    public FreteController(FreteService freteService) {
        this.freteService = freteService;
    }

    @PostMapping
    public ResponseEntity<String> calcularFrete(@RequestBody FreteModel request) {
        double valor = freteService.processarEntrega(request.getPeso(), request.getModalidade());
        return ResponseEntity.ok("Valor do frete: R$ " + valor);
    }
}
