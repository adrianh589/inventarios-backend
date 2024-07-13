CREATE DATABASE productosdb;

CREATE TABLE IF NOT EXISTS productos(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(256) NOT NULL
);

INSERT INTO productos (name) VALUES ('Tarjeta Credito'), ('Cheque'), ('Talonario');