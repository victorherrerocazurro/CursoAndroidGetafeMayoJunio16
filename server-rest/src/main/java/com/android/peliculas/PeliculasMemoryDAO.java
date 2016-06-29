package com.android.peliculas;

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
    
    public PeliculasMemoryDAO(){
    		Pelicula peli = new Pelicula();
    		listaPeliculas.put(contador.incrementAndGet(), peli);
    		peli.setId(contador.get());
    		peli.setTitulo("Deadpool");
    		peli.setDirector("Tim miller");
    		peli.setSinopsis("Va de un tio que le mola la sangre");
    		Pelicula peli2 = new Pelicula();
    		listaPeliculas.put(contador.incrementAndGet(), peli2);
    		peli2.setId(contador.get());
    		peli2.setTitulo("Deadpool2");
    		peli2.setDirector("Tim miller2");
    		peli2.setSinopsis("Va de un tio que le mola la sangre2");
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
