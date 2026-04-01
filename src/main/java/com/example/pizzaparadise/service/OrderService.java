package com.example.pizzaparadise.service;

import com.example.pizzaparadise.domain.Order;
import com.example.pizzaparadise.domain.Pizza;
import com.example.pizzaparadise.domain.User;
import com.example.pizzaparadise.infrastructur.OrderRepository;
import com.example.pizzaparadise.infrastructur.PizzaRepository;
import com.example.pizzaparadise.service.Validation.Validation;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    public Order startOrder (User user){
        return new Order(
                0,
                user,
                new ArrayList<>(),
                LocalDateTime.now(),
                0
        );
    }

    public void addPizza(Order order, Pizza pizza){
        order.getPizzas().add(pizza);
        order.setTotalPrice(order.getTotalPrice() + pizza.getPrice());
    }

    public void finalOrder(Order order){
        orderRepository.save(order);
    }

    public List<Order> getOrderHistory(User user){
        List<Order> orders = orderRepository.findOrdersByUserId(user.getId());

        for (Order order : orders) {
            List<Pizza> pizzas = orderRepository.findItemsByOrderId(order.getId());
            order.getPizzas().addAll(pizzas);
        }
        return orders;
    }
}
