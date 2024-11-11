package com.example.aplicaciongestion;

public class Elemento {
    private int imagenResId;
    private String titulo;
    private String contenido;
    private float puntuacion;
    private String web;
    private String telefono;

    public Elemento(int imagenResId, String titulo, String contenido, float puntuacion, String web, String telefono) {
        this.imagenResId = imagenResId;
        this.titulo = titulo;
        this.contenido = contenido;
        this.puntuacion = puntuacion;
        this.web = web;
        this.telefono = telefono;
    }

    // Getters
    public int getImagenResId() { return imagenResId; }
    public String getTitulo() { return titulo; }
    public String getContenido() { return contenido; }
    public float getPuntuacion() { return puntuacion; }
    public String getWeb() { return web; }
    public String getTelefono() { return telefono; }
}
