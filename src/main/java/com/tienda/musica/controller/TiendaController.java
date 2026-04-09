package com.tienda.musica.controller;

import com.tienda.musica.model.Artista;
import com.tienda.musica.model.Disco;
import com.tienda.musica.repository.ArtistaRepository;
import com.tienda.musica.repository.DiscoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class TiendaController {

    @Autowired
    private ArtistaRepository artistaRepository;

    @Autowired
    private DiscoRepository discoRepository;

    // HU-005: Registrar Artista
    @PostMapping("/artistas")
    public ResponseEntity<?> registrarArtista(@RequestBody Artista artista) {
        Artista nuevoArtista = artistaRepository.save(artista);
        return ResponseEntity.ok("✅ CASO DE PRUEBA 03 EXITOSO: Artista/Grupo '" + nuevoArtista.getNombre() + "' registrado correctamente en BD maestra.");
    }

    // HU-003: Registrar Disco
    @PostMapping("/discos")
    public ResponseEntity<?> registrarDisco(@RequestBody Disco disco) {
        Disco nuevoDisco = discoRepository.save(disco);
        return ResponseEntity.ok("✅ CASO DE PRUEBA 01 EXITOSO: Disco '" + nuevoDisco.getTitulo() + "' registrado con código " + nuevoDisco.getUpc() + ". Stock inicial: " + nuevoDisco.getStock());
    }

    // HU-002: Procesar Venta
    @PostMapping("/ventas/{upc}")
    public ResponseEntity<?> procesarVenta(@PathVariable String upc) {
        Optional<Disco> discoOpt = discoRepository.findById(upc);
        
        if (discoOpt.isPresent()) {
            Disco disco = discoOpt.get();
            if (disco.getStock() > 0) {
                disco.setStock(disco.getStock() - 1);
                discoRepository.save(disco);
                return ResponseEntity.ok("✅ CASO DE PRUEBA 02 EXITOSO: Venta registrada. El inventario se ha descontado. Stock actualizado: " + disco.getStock() + " unidades restantes.");
            } else {
                return ResponseEntity.badRequest().body("❌ ERROR: Stock agotado para el producto " + upc);
            }
        } else {
            return ResponseEntity.badRequest().body("❌ ERROR: Disco no encontrado en el sistema.");
        }
    }
}
