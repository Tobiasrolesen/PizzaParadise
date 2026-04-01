package com.example.pizzaparadise.service;

import com.example.pizzaparadise.domain.User;
import com.example.pizzaparadise.infrastructur.UserRepository;

import com.example.pizzaparadise.service.Validation.ValidationExceptionUser;
import org.springframework.stereotype.Service;
import com.example.pizzaparadise.service.Validation.Validation;

@Service
public class UserService{

    private final UserRepository userRepository;
    private final Validation validation;

    public UserService(UserRepository userRepository, Validation validation) {
        this.userRepository = userRepository;
        this.validation = validation;
    }

    public User login(User loginUser) {
        User dbUser = userRepository.findUserByEmail(loginUser.getEmail());
        validation.validateUser(dbUser);

        if (!dbUser.getPassword().equals(loginUser.getPassword())) {
            throw new ValidationExceptionUser("Incorrect Username or Password");
        }

        dbUser.setCurrentLogin(true);
        return dbUser;
    }

    public void createUser(User user){
        validation.validateUser(user);
        userRepository.createUser(user);
    }
}
