package com.tienda.musica.model;
import jakarta.persistence.*;

@Entity
public class Disco {
    @Id
    private String upc;
    private String titulo;
    private int stock;
    // Getters y Setters
    public String getUpc() { return upc; }
    public String getTitulo() { return titulo; }
    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }
}
