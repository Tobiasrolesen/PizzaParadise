package com.example.pizzaparadise.domain;

import java.time.LocalDate;
import java.time.LocalTime;

public class Order {
    private int id;
    private LocalTime dato;
    private double totalPrice;

    public Order(int id, LocalTime dato, double totalPrice) {
        this.id = id;
        this.dato = dato;
        this.totalPrice = totalPrice;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public LocalTime getDato() {
        return dato;
    }
    public void setDato(LocalTime dato) {
        this.dato = dato;
    }
    public double getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
