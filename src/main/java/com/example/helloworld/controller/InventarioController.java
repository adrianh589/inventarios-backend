package com.example.helloworld.controller;
import com.example.helloworld.model.Inventario;
import com.example.helloworld.service.Inventario.InventarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventarios")
public class InventarioController {

    private final InventarioService inventarioService;

    public InventarioController(InventarioService inventarioService) {
        this.inventarioService = inventarioService;
    }

    @GetMapping
    public ResponseEntity<?> getAllInventarios(@RequestParam(defaultValue = "1") int page,
                                              @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.status(HttpStatus.OK).body(inventarioService.getAll(page - 1, size));
    }

    @PostMapping
    public ResponseEntity<?> createInventario(@RequestBody Inventario inventario) {
        return inventarioService.saveInventario(inventario);
    }


    @PutMapping
    public ResponseEntity<?> updateEntregaInventario(@RequestBody Inventario inventario) {
        return inventarioService.updateEntregaInventario(inventario);
    }

}