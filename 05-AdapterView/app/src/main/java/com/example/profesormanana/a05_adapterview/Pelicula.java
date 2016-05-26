package com.example.profesormanana.a05_adapterview;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by profesormanana on 26/5/16.
 */
public class Pelicula implements Serializable {

    private String titulo = null;
    private List<String> actores = new LinkedList<>();
    private Date fechaEstreno = null;

    public Pelicula(String titulo, List<String> actores, Date fechaEstreno){
        this.actores.addAll(actores);
        this.fechaEstreno = fechaEstreno;
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<String> getActores() {
        return actores;
    }

    public String getActor(int posicion){
        return actores.get(posicion);
    }

    public void addActor(String actor) {
        this.actores.add(actor);
    }

    public void addActores(List<String> actores) {
        this.actores.addAll(actores);
    }

    public Date getFechaEstreno() {
        return fechaEstreno;
    }

    public void setFechaEstreno(Date fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    @Override
    public String toString() {
        return this.getTitulo();
    }
}
