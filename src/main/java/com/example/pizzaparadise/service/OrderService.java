package com.example.pizzaparadise.service;

import com.example.pizzaparadise.domain.Order;
import com.example.pizzaparadise.domain.Pizza;
import com.example.pizzaparadise.domain.User;
import com.example.pizzaparadise.infrastructur.OrderRepository;
import com.example.pizzaparadise.infrastructur.PizzaRepository;
import com.example.pizzaparadise.service.Validation.Validation;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final PizzaRepository pizzaRepository;
    private final Validation validation;

    public OrderService(OrderRepository orderRepository, PizzaRepository pizzaRepository, Validation validation) {
        this.orderRepository = orderRepository;
        this.pizzaRepository = pizzaRepository;
        this.validation = validation;
    }


    public void createCustomPizzaOrder(String base, String sauce, String topping, User user){


        Pizza customPizza = new Pizza (
                0,
                "Custom pizza",
                base,
                sauce,
                topping,
                109.95,
                "peperoni.jpg"
        );

        Order order = new Order(
                0,
                user,
                customPizza,
                LocalDateTime.now(),
                customPizza.getPrice()
        );

        orderRepository.save(order);
    }
}
