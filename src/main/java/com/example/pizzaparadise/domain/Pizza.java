package com.example.pizzaparadise.domain;

public class Pizza {

    private int id;
    private String name;
    private String details;
    private double price;
    private String pizzaBase;
    private String sauce;

    public Pizza(){
    }

    public Pizza(int id, String name, String details, double price, String pizzaBase, String sauce) {
        this.id = id;
        this.name = name;
        this.details = details;
        this.price = price;
        this.pizzaBase = pizzaBase;
        this.sauce = sauce;
    }

    public Pizza(String name, String details, double price, String pizzaBase, String sauce) {
        this.name = name;
        this.details = details;
        this.price = price;
        this.pizzaBase = pizzaBase;
        this.sauce = sauce;

    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDetails() {
        return details;
    }
    public void setDetails(String details) {
        this.details = details;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public String getPizzaBase() {
        return pizzaBase;
    }
    public void setPizzaBase(String pizzaBase) {
        this.pizzaBase = pizzaBase;
    }
    public String getSauce() {
        return sauce;
    }
    public void setSauce(String sauce) {
        this.sauce = sauce;
    }
}
