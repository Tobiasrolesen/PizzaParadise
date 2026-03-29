package com.example.pizzaparadise.infrastructur;

import com.example.pizzaparadise.domain.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository {
    private final JdbcTemplate jdbcTemplate;

    public OrderRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Order order) {
        String sql = "INSERT INTO orders (userId, base, sauce, topping, totalPrice, date) VALUES (?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(sql,
                order.getUser().getId(),
                order.getPizza().getBase(),
                order.getPizza().getSauce(),
                order.getPizza().getTopping(),
                order.getTotalPrice(),
                order.getDate()
        );
    }
}
