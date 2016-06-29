package com.example.profesormanana.a21_sqlite;

import java.util.List;

/**
 * Created by profesormanana on 21/6/16.
 */
public interface IPeliculasDAO {

    void create(Pelicula pelicula);
    List<Pelicula> read();
    Pelicula read(Integer id);
    void update(Pelicula pelicula);
    void delete(Integer id);

}
