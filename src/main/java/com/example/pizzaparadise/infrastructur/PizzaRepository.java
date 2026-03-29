package com.example.pizzaparadise.infrastructur;

import com.example.pizzaparadise.domain.Pizza;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PizzaRepository {

    private final JdbcTemplate jdbcTemplate;

    public PizzaRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Pizza> findAllPizza() {
        String sql = "select * from pizzas";

        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new Pizza(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("base"),
                        rs.getString("sauce"),
                        rs.getString("topping"),
                        rs.getDouble("price"),
                        rs.getString("img")
                )
        );
    }

    public Pizza findById(int id) {
        String sql = "select * from pizzas Where id = ?";

        return jdbcTemplate.queryForObject(sql, new Object[] {id}, (rs, rowNum) ->
                new Pizza(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("base"),
                        rs.getString("sauce"),
                        rs.getString("topping"),
                        rs.getDouble("price"),
                        rs.getString("img")
                )
        );
    }
}
