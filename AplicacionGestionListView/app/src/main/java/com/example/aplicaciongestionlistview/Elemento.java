package com.example.aplicaciongestionlistview;

import java.util.Date;

public class Elemento {
    private int imagenResId;        // ID del recurso de imagen
    private String titulo;           // Título del elemento
    private String descripcion;      // Breve descripción del elemento
    private float puntuacion;        // Valor de la puntuación (de 0 a 5)
    private String fechaEntrega;       // Fecha de entrega del elemento

    // Constructor
    public Elemento(int imagenResId, String titulo, String descripcion, float puntuacion, String fechaEntrega) {
        this.imagenResId = imagenResId;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.puntuacion = puntuacion;
        this.fechaEntrega = fechaEntrega;
    }

    // Getters
    public int getImagenResId() { return imagenResId; }
    public String getTitulo() { return titulo; }
    public String getDescripcion() { return descripcion; }
    public float getPuntuacion() { return puntuacion; }
    public String getFechaEntrega() { return fechaEntrega; }

    @Override
    public String toString() {
        return "Elemento{" +
                "imagenResId=" + imagenResId +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", puntuacion=" + puntuacion +
                ", fechaEntrega=" + fechaEntrega +
                '}';
    }
}

