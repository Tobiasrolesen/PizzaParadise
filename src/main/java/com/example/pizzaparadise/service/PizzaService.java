package com.example.pizzaparadise.service;

import com.example.pizzaparadise.domain.Pizza;
import com.example.pizzaparadise.infrastructur.PizzaRepository;
import com.example.pizzaparadise.service.Validation.Validation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaService {

    private final PizzaRepository pizzaRepository;
    private final Validation validation;

    public PizzaService(PizzaRepository pizzaRepository, Validation validation) {
        this.pizzaRepository = pizzaRepository;
        this.validation = validation;
    }

    public List<Pizza> getAllPizzas() {
        return pizzaRepository.findAllPizza();
    }
}
