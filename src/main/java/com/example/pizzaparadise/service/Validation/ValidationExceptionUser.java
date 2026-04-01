package com.example.pizzaparadise.service.Validation;

public class ValidationExceptionUser extends RuntimeException {
    public ValidationExceptionUser(String message) {
        super(message);
    }
}
