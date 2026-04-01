package com.example.pizzaparadise.controller;

import com.example.pizzaparadise.domain.Order;
import com.example.pizzaparadise.domain.Pizza;
import com.example.pizzaparadise.domain.User;
import com.example.pizzaparadise.service.OrderService;
import com.example.pizzaparadise.service.PizzaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.List;

@Controller
@SessionAttributes({"user", "order"})
public class OrderController {

    private OrderService orderService;
    private PizzaService pizzaService;

    public OrderController(OrderService orderService, PizzaService pizzaService) {
        this.orderService = orderService;
        this.pizzaService = pizzaService;
    }

    @ModelAttribute("order")
    public Order order(User user){
        return orderService.startOrder(user);
    }

    @GetMapping("/order")
    public String showOrderPage(@ModelAttribute ("user") User user, Model model){

        //Order freshOrder = orderService.startOrder(user);
        //model.addAttribute("order", freshOrder);

        model.addAttribute("allPizzas", pizzaService.getAllPizzas());
        return "order";
    }

    @PostMapping("/add")
    public String addPizza(@RequestParam int pizzaId, @ModelAttribute ("order") Order order){
        Pizza p = pizzaService.findById(pizzaId);
        orderService.addPizza(order, p);
        return "redirect:/order";
    }

    @PostMapping("/complete")
    public String completeOrder(@ModelAttribute ("order") Order order, SessionStatus status){
        orderService.finalOrder(order);
        status.setComplete();

        return "redirect:/homePageLoginTrue";
    }

    @GetMapping("/orderHistory")
    public String orderHistory(@ModelAttribute ("user") User user, Model model){
        List<Order> orders = orderService.getOrderHistory(user);
        model.addAttribute("orders", orders);

        return "orderHistory";
    }
}
