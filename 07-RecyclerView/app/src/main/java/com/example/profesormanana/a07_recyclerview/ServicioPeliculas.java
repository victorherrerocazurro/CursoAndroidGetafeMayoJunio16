package com.example.profesormanana.a07_recyclerview;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by profesormanana on 26/5/16.
 */
public class ServicioPeliculas {

    public static List<Pelicula> consultarTodasLasPeliculas(){
        LinkedList<Pelicula> peliculas = new LinkedList<>();
        List<String> actores = new LinkedList<>();
        actores.add("DiCaprio");
        actores.add("Winshlet");
        peliculas.add(new Pelicula("Titanic", actores, new Date()));

        actores = new LinkedList<>();

        actores.add("Mel Gibson");

        peliculas.add(new Pelicula("Mad Max", actores, new Date()));

        return peliculas;
    }

}
