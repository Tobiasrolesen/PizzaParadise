DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS pizzas;
DROP TABLE IF EXISTS order_items;

CREATE TABLE users (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       name VARCHAR(100) NOT NULL,
                       email VARCHAR(100) NOT NULL,
                       password VARCHAR(50) NOT NULL,
                       adress VARCHAR(150) NOT NULL,
                       bonusPoint INT NOT NULL DEFAULT 0
);

CREATE TABLE pizzas (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        name VARCHAR(100) NOT NULL,
                        base VARCHAR(100) NOT NULL,
                        sauce VARCHAR (100) NOT NULL,
                        topping VARCHAR(100) NOT NULL,
                        price double NOT NULL,
                        img VARCHAR(255) NOT NULL
);

CREATE TABLE orders (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        userId INT NOT NULL,
                        totalPrice DOUBLE NOT NULL,
                        date DATETIME NOT NULL
);

CREATE TABLE order_items (
                             id INT AUTO_INCREMENT PRIMARY KEY,
                             orderId INT NOT NULL,
                             base VARCHAR(255),
                             sauce VARCHAR(255),
                             topping VARCHAR(255),
                             price DOUBLE
);


