package com.example.pizzaparadise.controller;

import com.example.pizzaparadise.service.PizzaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("user")
public class PizzaController {
    private final PizzaService pizzaService;

    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @GetMapping("/pizza-list")
    public String showPizzas(Model model) {
        model.addAttribute("pizzas", pizzaService.getAllPizzas());
        return "pizza-list";
    }
}
