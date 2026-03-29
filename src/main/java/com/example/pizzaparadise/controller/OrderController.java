package com.example.pizzaparadise.controller;

import com.example.pizzaparadise.domain.User;
import com.example.pizzaparadise.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("user")
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/createPizza")
    public String showPizzaForm() {
        return "createPizza";
    }

    @PostMapping("/createPizza")
    public String create(@RequestParam String base, @RequestParam String sauce, @RequestParam String topping, @ModelAttribute("user") User user){

        orderService.createCustomPizzaOrder(base, sauce, topping, user);
        return "redirect:/profile";
    }



}
