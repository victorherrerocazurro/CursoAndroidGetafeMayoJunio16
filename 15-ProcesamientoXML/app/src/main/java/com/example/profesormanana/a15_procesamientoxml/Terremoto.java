package com.example.profesormanana.a15_procesamientoxml;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by profesormanana on 10/6/16.
 */
public class Terremoto implements Serializable{

    private String id;
    private String titulo;
    private Date fecha;
    private List<String> links = new LinkedList<>();
    private double latitud;
    private double longitud;

    public Terremoto() {
    }

    public Terremoto(String id, String titulo, Date fecha, List<String> links, double latitud, double longitud) {
        this.id = id;
        this.titulo = titulo;
        this.fecha = fecha;
        this.links = links;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<String> getLinks() {
        return links;
    }

    public void addLink(String link){
        links.add(link);
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    @Override
    public String toString() {
        return "Terremoto{" +
                "titulo='" + titulo + '\'' +
                ", fecha=" + fecha +
                ", latitud=" + latitud +
                ", longitud=" + longitud +
                '}';
    }
}
