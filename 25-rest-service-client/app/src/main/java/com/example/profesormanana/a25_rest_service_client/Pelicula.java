package com.example.profesormanana.a25_rest_service_client;

/**
 * Created by profesormanana on 20/6/16.
 */
public class Pelicula {

    private String titulo;
    private String director;
    private String sinopsis;


    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    @Override
    public String toString() {
        return "Peliculas{" +
                "id=" + id + '\'' +
                "titulo='" + titulo + '\'' +
                ", director='" + director + '\'' +
                ", sinopsis='" + sinopsis + '\'' +
                '}';
    }
}
