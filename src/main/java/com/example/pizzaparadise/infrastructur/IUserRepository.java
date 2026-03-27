package com.example.pizzaparadise.infrastructur;

import com.example.pizzaparadise.domain.User;

public interface IUserRepository {

    User findUserByEmail(String email);
    void createUser(User user);


}
