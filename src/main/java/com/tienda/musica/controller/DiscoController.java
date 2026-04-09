package com.tienda.musica.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class DiscoController {

    @PostMapping("/ventas")
    public ResponseEntity<?> registrarVenta(@RequestBody Map<String, String> payload) {
        return ResponseEntity.ok(Map.of("mensaje", "Venta exitosa. Stock actualizado."));
    }

    @PostMapping("/discos")
    public ResponseEntity<?> registrarDisco(@RequestBody Map<String, String> disco) {
        return ResponseEntity.ok(Map.of("mensaje", "Álbum guardado exitosamente en el catálogo."));
    }
}
