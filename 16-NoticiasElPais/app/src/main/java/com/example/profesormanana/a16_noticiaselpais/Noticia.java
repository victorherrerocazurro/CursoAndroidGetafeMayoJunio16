package com.example.profesormanana.a16_noticiaselpais;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by profesormanana on 13/6/16.
 */
public class Noticia implements Serializable {

    private String title;
    private String autor;
    private String descripcion;
    private String link;
    private Date fecha;

    public Noticia() {
    }

    public Noticia(String title, String autor, String descripcion, String link, Date fecha) {
        this.title = title;
        this.autor = autor;
        this.descripcion = descripcion;
        this.link = link;
        this.fecha = fecha;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Noticia{" +
                "fecha=" + fecha +
                ", title='" + title + '\'' +
                ", autor='" + autor + '\'' +
                '}';
    }
}
