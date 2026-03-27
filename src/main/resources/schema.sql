DROP TABLE IF EXISTS users;

CREATE TABLE users (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       name VARCHAR(100) NOT NULL,
                       email VARCHAR(100) NOT NULL,
                       password VARCHAR(50) NOT NULL,
                       adress VARCHAR(150) NOT NULL,
                       bonusPoint INT NOT NULL DEFAULT 0

);
