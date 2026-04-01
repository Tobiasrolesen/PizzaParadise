package com.example.pizzaparadise.infrastructur;

import com.example.pizzaparadise.domain.Order;
import com.example.pizzaparadise.domain.Pizza;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepository {
    private final JdbcTemplate jdbcTemplate;

    public OrderRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Order order) {
        String sqlOrder = "INSERT INTO orders (userId, totalPrice, date) VALUES (?, ?, ?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(conn -> {
            PreparedStatement ps = conn.prepareStatement(sqlOrder, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, order.getUser().getId());
            ps.setDouble(2, order.getTotalPrice());
            ps.setObject(3, order.getDate());
            return ps;
        }, keyHolder);

        int orderId = keyHolder.getKey().intValue();

        String sqlItem = "INSERT INTO order_items (orderId, base, sauce, topping, price) VALUES (?, ?, ?, ?, ?)";

        for (Pizza p : order.getPizzas()) {
            jdbcTemplate.update(sqlItem, orderId, p.getBase(), p.getSauce(), p.getTopping(), p.getPrice());
        }
    }

    public List<Order> findOrdersByUserId(int userId) {
        String sql = "SELECT * FROM orders WHERE userId = ? ORDER BY DATE DESC";

        return jdbcTemplate.query(sql, new Object[]{userId}, (rs, rowNum) ->
                new Order(
                        rs.getInt("Id"),
                        null,
                        new ArrayList<>(),
                        rs.getTimestamp("date").toLocalDateTime(),
                        rs.getDouble("totalPrice")
                )
        );
    }

    public List<Pizza> findItemsByOrderId(int orderId) {
        String sql = "SELECT * FROM order_items WHERE orderId = ?";

        return jdbcTemplate.query(sql, new Object[]{orderId}, (rs, rowNum) ->
                new Pizza(
                        0,
                        "Custom",
                        rs.getString("base"),
                        rs.getString("sauce"),
                        rs.getString("topping"),
                        rs.getDouble("price"),
                        null
                )
        );
    }
}
