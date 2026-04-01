package com.example.pizzaparadise.controller;

import com.example.pizzaparadise.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import com.example.pizzaparadise.service.UserService;

@Controller
@SessionAttributes("user")
public class UserController {

    @ModelAttribute("user")
    public User user() {
        return new User();
    }

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String index(@ModelAttribute("user") User user){
        if (user != null && user.isCurrentLogin()) {
            return "homePageLoginTrue";
        }
        return "index";
    }

    @GetMapping("/createUser")
    public String createUser(Model model) {
        return "createUser";
    }

    @GetMapping("/login")
    public String showLoginPage(Model model){
        model.addAttribute("loginForm", new User());
        return "login";
    }

    @GetMapping("/profile")
    public String profile() {
        return "profile";
    }

    @PostMapping("/createUser")
    public String createUser(@ModelAttribute("user") User user, Model model) {
        try {
            userService.createUser(user);
            model.addAttribute("user", user);
            return "login";

        } catch(Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return "error";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("user") User loginForm, Model model) {
        User user = userService.login(loginForm);

        model.addAttribute("user", user);
        return "redirect:/";
    }

    @PostMapping("/logout")
    public String logout(@ModelAttribute("user") User user){
        user.setCurrentLogin(false);
        return "redirect:/";
    }

    @GetMapping("/homePageLoginTrue")
    public String homePageLoginTrue(Model model) {
        return "homePageLoginTrue";
    }
}
