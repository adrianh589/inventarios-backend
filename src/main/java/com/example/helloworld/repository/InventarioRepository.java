package com.example.helloworld.repository;

import com.example.helloworld.model.Inventario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InventarioRepository extends MongoRepository<Inventario, String> {
    Inventario findByNumeroSerie(String numeroSerie);
    Page<Inventario> findAll(Pageable pageable);
}