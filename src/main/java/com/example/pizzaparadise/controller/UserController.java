package com.example.pizzaparadise.controller;

import com.example.pizzaparadise.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import com.example.pizzaparadise.service.UserService;

@Controller
@SessionAttributes("user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/createUser")
    public String createUser(Model model) {
        model.addAttribute("user", new User());
        return "createUser";
    }

    @PostMapping("/createUser")
    public String createUser(@ModelAttribute("user") User user, Model model) {
        try {
            userService.createUser(user);

            if (user == null) {
                model.addAttribute("error", "Invalid email or password");
                return "createUser";
            }

            model.addAttribute("user", user);
            return "index";

        } catch(Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return "error";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("user") User loginUser, Model model) {
        User user = userService.login(loginUser);

        if (user == null) {
            model.addAttribute("error", "Invalid email or password");
            return "login";
        }

        model.addAttribute("user", user);
        return "profile";
    }

    @GetMapping("/login")
    public String showLoginPage(Model model){
        model.addAttribute("user", new User());
        return "login";
    }

    @GetMapping("/profile")
    public String profile() {
        return "profile";
    }
}
