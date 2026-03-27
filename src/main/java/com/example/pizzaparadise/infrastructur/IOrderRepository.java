package com.example.pizzaparadise.infrastructur;

import com.example.pizzaparadise.domain.Order;

import java.util.List;

public interface IOrderRepository {

    List<Order> saveOrder();
}
