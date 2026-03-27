package com.example.pizzaparadise.service;

import com.example.pizzaparadise.infrastructur.PizzaRepository;
import org.springframework.stereotype.Service;

@Service
public class PizzaService {

    private final PizzaRepository pizzaRepository;

    public PizzaService(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }
}
