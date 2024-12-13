package com.example.aplicaciongestionlistview;

import java.util.Date;

public class Elemento {
    private int id;
    private int imagenResId;        // ID del recurso de imagen
    private String titulo;           // Título del elemento
    private String descripcion;      // Breve descripción del elemento
    private float puntuacion;        // Valor de la puntuación (de 0 a 5)
    private String fechaEntrega;
    private String uriImagen; // Fecha de entrega del elemento

    // Constructor

    public Elemento(int id,String uriImagen, String titulo, String descripcion, float puntuacion, String fechaEntrega) {
        this.id=id;
        this.uriImagen=uriImagen;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.puntuacion = puntuacion;
        this.fechaEntrega = fechaEntrega;
    }
    public Elemento(String imagen, String titulo, String descripcion, float puntuacion, String fechaEntrega) {
        this.id=id;
        this.uriImagen=imagen;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.puntuacion = puntuacion;
        this.fechaEntrega = fechaEntrega;
    }

    // Getters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImagenResId() { return imagenResId; }
    public String getTitulo() { return titulo; }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPuntuacion(float puntuacion) {
        this.puntuacion = puntuacion;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setUriImagen(String uriImagen) {
        this.uriImagen = uriImagen;
    }

    public String getDescripcion() { return descripcion; }
    public float getPuntuacion() { return puntuacion; }
    public String getFechaEntrega() { return fechaEntrega; }

    public String getUriImagen() {
        return uriImagen;
    }

    public void setImagenResId(int imagenResId) {
        this.imagenResId = imagenResId;
    }

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

