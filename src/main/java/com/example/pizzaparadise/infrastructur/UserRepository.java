package com.example.pizzaparadise.infrastructur;

import com.example.pizzaparadise.domain.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository implements IUserRepository {

    private final JdbcTemplate jdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public User findUserByEmail(String email) {
        String sql = """
                SELECT id, name, email, password, adress, bonusPoint
                FROM users
                WHERE email = ?
                """;

        return jdbcTemplate.queryForObject(sql, new Object[]{email}, (rs, rowNum) ->
                new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("adress"),
                        rs.getInt("bonusPoint"),
                        null,
                        true
                )
        );
    }

    public void createUser(User user) {
        String sql = "INSERT INTO users(name,email,password,adress) VALUES (?,?,?,?)";

        jdbcTemplate.update(
                sql,
                user.getName(),
                user.getEmail(),
                user.getPassword(),
                user.getAdress()
        );
    }
}
