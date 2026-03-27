package com.example.pizzaparadise.infrastructur;

import com.example.pizzaparadise.domain.Pizza;

import java.util.List;
import java.util.Optional;

public interface IPizzaRepository {

    List<Pizza> findAllPizzas();
    Optional<Pizza> findPizzaById(int id);
}
