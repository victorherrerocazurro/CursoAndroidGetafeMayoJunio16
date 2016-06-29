package com.example.profesormanana.a21_sqlite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by profesormanana on 21/6/16.
 */
public class PeliculasMemoryDAO implements IPeliculasDAO{

    private static Map<Integer,Pelicula> listaPeliculas;
    private static AtomicInteger contador;
    static {
        listaPeliculas = new HashMap<>();
        contador = new AtomicInteger();
    }
    @Override
    public void create(Pelicula pelicula) {
        pelicula.setId(contador.incrementAndGet());
        listaPeliculas.put(pelicula.getId(),pelicula);
    }

    @Override
    public List<Pelicula> read() {
        return new ArrayList<>(listaPeliculas.values());
    }

    @Override
    public Pelicula read(Integer id) {
        return listaPeliculas.get(id);
    }

    @Override
    public void update(Pelicula pelicula) {
    	listaPeliculas.put(pelicula.getId(),pelicula);
    }

    @Override
    public void delete(Integer id) {
        listaPeliculas.remove(id);
    }
}
