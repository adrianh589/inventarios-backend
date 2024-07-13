package com.example.helloworld.service.Inventario;

import com.example.helloworld.model.Inventario;
import com.example.helloworld.model.Product;
import com.example.helloworld.repository.InventarioRepository;
import com.example.helloworld.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InventarioImpl implements InventarioService {

    private final InventarioRepository inventarioRepository;
    private final ProductRepository productRepository;

    public InventarioImpl(InventarioRepository inventarioRepository, ProductRepository productRepository) {
        this.inventarioRepository = inventarioRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Page<Inventario> getAll(int page, int size) {
        // Define la configuración de orden descendente por el campo deseado, en este caso el id
        Sort.Order order = Sort.Order.desc("id");
        Sort sort = Sort.by(order);
        Pageable pageable = PageRequest.of(page, size, sort);
        return inventarioRepository.findAll(pageable);
    }

    @Override
    public Inventario getByNumeroSerie(String numeroSerie) {
        return inventarioRepository.findByNumeroSerie(numeroSerie);
    }

    @Override
    public ResponseEntity<?> saveInventario(Inventario inventario) {
        // Verificar si el número de serie ya existe
        Inventario inventarioEncontrado = inventarioRepository.findByNumeroSerie(inventario.getNumeroSerie());
        if (inventarioEncontrado != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("El número de serie ya existe");
        }

        // Verificar si el producto existe
        Optional<Product> optionalProduct = Optional.ofNullable(productRepository.findById(inventario.getProductoId()));
        if (optionalProduct.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró el producto con el id proporcionado");
        }

        // Asignar el producto al inventario
        inventario.setProduct(optionalProduct.get());

        // Guardar el inventario
        Inventario savedInventario = inventarioRepository.save(inventario);

        // Devolver respuesta con el inventario guardado y código 200
        return ResponseEntity.status(HttpStatus.OK).body(savedInventario);
    }

    @Override
    public ResponseEntity<?> updateEntregaInventario(Inventario inventario) {
        Optional<Inventario> inventarioEncontrado = this.inventarioRepository.findById(inventario.getId());

        if (inventarioEncontrado.isPresent()) {
            Inventario inventarioToUpdate = inventarioEncontrado.get();
            inventarioToUpdate.setEntregado(true);
            inventarioRepository.save(inventarioToUpdate);
            return ResponseEntity.ok(inventarioToUpdate);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró el inventario con el id proporcionado");
        }
    }
}
