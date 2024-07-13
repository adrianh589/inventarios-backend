CREATE DATABASE PRODUCTOS_DB;

USE PRODUCTOS_DB ;

CREATE TABLE IF NOT EXISTS PRODUCTOS (
                                         id INT AUTO_INCREMENT NOT NULL,
                                         nombre_producto VARCHAR(256) NOT NULL,
    CONSTRAINT pk_productos PRIMARY KEY (id)
    );

INSERT INTO PRODUCTOS (nombre_producto) VALUES
                                            ('Tarjeta Credito'),
                                            ('Cheque'),
                                            ('Talonario');