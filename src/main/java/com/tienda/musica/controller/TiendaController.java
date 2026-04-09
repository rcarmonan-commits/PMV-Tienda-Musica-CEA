package com.tienda.musica.controller;
import com.tienda.musica.model.*;
import com.tienda.musica.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class TiendaController {
    @Autowired private ArtistaRepository artRepo;
    @Autowired private DiscoRepository dscRepo;

    @PostMapping("/artistas")
    public String registrarArtista(@RequestBody Artista a) {
        artRepo.save(a);
        return "✅ TEST CASE 03: Artista guardado.";
    }

    @PostMapping("/discos")
    public String registrarDisco(@RequestBody Disco d) {
        dscRepo.save(d);
        return "✅ TEST CASE 01: Disco registrado.";
    }

    @PostMapping("/ventas/{upc}")
    public String venta(@PathVariable String upc) {
        Optional<Disco> d = dscRepo.findById(upc);
        if(d.isPresent() && d.get().getStock() > 0) {
            d.get().setStock(d.get().getStock() - 1);
            dscRepo.save(d.get());
            return "✅ TEST CASE 02: Venta exitosa. Stock: " + d.get().getStock();
        }
        return "❌ Error: Sin stock.";
    }
}
