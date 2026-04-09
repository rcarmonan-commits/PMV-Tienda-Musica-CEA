package com.tienda.musica.model;
import jakarta.persistence.*;

@Entity
public class Artista {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipo;
    private String nombre;
    private String pais;
    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
}
