package com.example.helloworld.service.Inventario;

import com.example.helloworld.model.Inventario;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

public interface InventarioService {
    Page<Inventario> getAll(int page, int size);
    Inventario getByNumeroSerie(String numeroSerie);
    ResponseEntity<?> saveInventario(Inventario inventario);
    ResponseEntity<?> updateEntregaInventario(Inventario inventario);
}
