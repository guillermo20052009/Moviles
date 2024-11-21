package com.example.guillermobarcenalopez_prueba3;
import java.util.Date;

public class Elemento {
    private int imagenResId;        // ID del recurso de imagen
    private String titulo;           // Título del elemento
    private String descripcion;      // Breve descripción del elemento
    // Fecha de entrega del elemento

    // Constructor
    public Elemento(int imagenResId, String titulo, String descripcion) {
        this.imagenResId = imagenResId;
        this.titulo = titulo;
        this.descripcion = descripcion;

    }

    // Getters
    public int getImagenResId() { return imagenResId; }
    public String getTitulo() { return titulo; }
    public String getDescripcion() { return descripcion; }

    @Override
    public String toString() {
        return "Elemento{" +
                "imagenResId=" + imagenResId +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}


