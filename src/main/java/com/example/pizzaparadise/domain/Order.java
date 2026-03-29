package com.example.pizzaparadise.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Order {
    private int id;
    private User user;
    private Pizza pizza;
    private LocalDateTime date;
    private double totalPrice;

    public Order(int id, User user, Pizza pizza, LocalDateTime date, double totalPrice) {
        this.id = id;
        this.user = user;
        this.pizza = pizza;
        this.date = date;
        this.totalPrice = totalPrice;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public Pizza getPizza() {
        return pizza;
    }
    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public LocalDateTime getDate() {
        return date;
    }
    public void setDato(LocalDateTime date) {
        this.date = date;
    }
    public double getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
