package com.example.pizzaparadise.service;

import com.example.pizzaparadise.domain.User;
import com.example.pizzaparadise.infrastructur.UserRepository;

import org.springframework.stereotype.Service;

@Service
public class UserService{

    private final UserRepository userRepository;
    //private final validation validation;

    public UserService(UserRepository userRepository, ) {
        this.userRepository = userRepository;

    }

    public User login(User loginUser) {
        User dbUser = userRepository.findUserByEmail(loginUser.getEmail());

        if (dbUser == null) {
            throw new RuntimeException("User not found");
        }

        if (!dbUser.getPassword().equals(loginUser.getPassword())) {
            return null;
        }
        return dbUser;
    }

    public void createUser(User user){

        userRepository.createUser(user);
    }
}
