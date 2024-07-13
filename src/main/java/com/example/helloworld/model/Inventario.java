package com.example.helloworld.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "inventarios")
@Getter
@Setter
public class Inventario {

    @Id
    private String id;

    @Indexed(unique = true)
    private String numeroSerie;
    private boolean entregado;
    private Product product;
    private String nombreUsuario;
    private Date fechaCreacion;
    private Integer productoId;
}