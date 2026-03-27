package com.example.pizzaparadise.domain;

import java.util.List;

public class User {
    private int id;
    private String name;
    private String email;
    private String password;
    private String adress;
    private int bonusPoint = 0;
    private List<Order> orders;

    public User(){

    }

    public User(int id, String name, String email, String password, String adress, int bonusPoint, List<Order> orders) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.adress = adress;
        this.bonusPoint = bonusPoint;
        this.orders = orders;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getAdress() {
        return adress;
    }

    public int getBonusPoint() {
        return bonusPoint;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setBonusPoint(int bonusPoint) {
        this.bonusPoint = bonusPoint;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
