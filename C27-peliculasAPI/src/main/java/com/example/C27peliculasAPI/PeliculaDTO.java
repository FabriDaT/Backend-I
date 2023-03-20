package com.example.C27peliculasAPI;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PeliculaDTO {

    private String titulo;
    private String categoria;

    public PeliculaDTO(String titulo, String categoria) {
        this.titulo = titulo;
        this.categoria = categoria;
    }

    public PeliculaDTO() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
