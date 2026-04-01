package com.example.pizzaparadise.service.Validation;

import com.example.pizzaparadise.domain.Order;
import com.example.pizzaparadise.domain.Pizza;
import com.example.pizzaparadise.domain.User;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class Validation {

    public void validateOrder(Order order){
        int id = order.getId();
        String user = order.getUser().getName();
        String date = order.getDate().toString();
        double totalPrice = order.getTotalPrice();

        if (id < 0) {
            throw new ValidationExceptionOrder("Order id is negative");
        }

        if (user == null || user.isEmpty()) {
            throw new ValidationExceptionOrder("Username cannot be empty empty");
        }

        if (date == null || date.isEmpty()) {
            throw new ValidationExceptionOrder("Date cannot be empty");
        }

        if (totalPrice < 0) {
            throw new ValidationExceptionOrder("Total price is negative");
        }
    }

    public void validatePizza(Pizza pizza){
        int id = pizza.getId();
        String name = pizza.getName();
        String base = pizza.getBase();
        String sauce = pizza.getSauce();
        String topping = pizza.getTopping();
        double price = pizza.getPrice();

        if (id < 0) {
            throw new ValidationExceptionPizza("Pizza id is negative");
        }

        if (name == null || name.isEmpty()) {
            throw new ValidationExceptionPizza("Pizza name cannot be empty");
        }

        if (base == null || base.isEmpty()) {
            throw new ValidationExceptionPizza("Pizza base is empty");
        }

        if (sauce == null || sauce.isEmpty()) {
            throw new ValidationExceptionPizza("Pizza sauce is empty");
        }

        if (topping == null || topping.isEmpty()) {
            throw new ValidationExceptionPizza("Pizza topping is empty");
        }

        if (price < 0) {
            throw new ValidationExceptionPizza("Pizza price is negative");
        }
    }

    public void validateUser(User user){
        int id = user.getId();
        String name = user.getName();
        String email = user.getEmail();
        String password = user.getPassword();
        String adress =  user.getAdress();
        int bonusPoint = user.getBonusPoint();

        if (id < 0) {
            throw new ValidationExceptionUser("User id is negative");
        }

        if (name == null || name.isEmpty()) {
            throw new ValidationExceptionUser("Username cannot be empty");
        }

        if (email == null || email.isEmpty()) {
            throw new ValidationExceptionUser("Email cannot be empty");
        }

        if (password == null || password.isEmpty()) {
            throw new ValidationExceptionUser("Password cannot be empty");
        }

        if (adress == null || adress.isEmpty()) {
            throw new ValidationExceptionUser("Adress cannot be empty");
        }

        if (bonusPoint < 0) {
            throw new ValidationExceptionUser("Bonus point is negative");
        }
    }
}

