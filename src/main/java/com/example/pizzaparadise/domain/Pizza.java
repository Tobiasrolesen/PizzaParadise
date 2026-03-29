package com.example.pizzaparadise.domain;

public class Pizza {

    private int id;
    private String name;
    private String base;
    private String sauce;
    private String topping;
    private double price;
    private String img;

    public Pizza(){
    }

    public Pizza(int id, String name, String base, String sauce, String topping, double price, String img) {
        this.id = id;
        this.name = name;
        this.base = base;
        this.sauce = sauce;
        this.topping = topping;
        this.price = price;
        this.img = img;
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
    public String getImg() {
        return img;
    }
    public void setImg(String img) {
        this.img = img;
    }
}
