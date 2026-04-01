package com.example.pizzaparadise.service.Validation;

public class ValidationExceptionOrder extends RuntimeException {
    public ValidationExceptionOrder(String message) {
        super(message);
    }
}
