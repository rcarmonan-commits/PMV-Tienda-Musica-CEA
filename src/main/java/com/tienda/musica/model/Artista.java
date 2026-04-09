package com.tienda.musica.model;

import jakarta.persistence.*;

@Entity
public class Artista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipo; // Solista o Grupo
    private String nombre;
    private String pais;
    private String integrantes;

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getPais() { return pais; }
    public void setPais(String pais) { this.pais = pais; }
    public String getIntegrantes() { return integrantes; }
    public void setIntegrantes(String integrantes) { this.integrantes = integrantes; }
}
