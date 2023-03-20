package com.example.C27peliculasAPI;

import java.util.ArrayList;
import java.util.List;

public class Pelicula {

    private String titulo;
    private String categoria;
    private Integer premios;
    private Integer id;



    public Pelicula(String titulo, String categoria, Integer premios, Integer id) {
        this.titulo = titulo;
        this.categoria = categoria;
        this.premios = premios;
        this.id = id;
    }

    //getters y setters
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

    public Integer getPremios() {
        return premios;
    }

    public void setPremios(Integer premios) {
        this.premios = premios;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



}

