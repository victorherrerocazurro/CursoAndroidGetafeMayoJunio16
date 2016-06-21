package com.example.profesormanana.a21_sqlite;

import android.content.Context;

import java.util.List;

/**
 * Created by profesormanana on 21/6/16.
 */
public class PeliculasLN {

    private IPeliculasDAO peliculasDAO;
    private IDataLogDAO dataLogDAO;

    public PeliculasLN(Context context) {
        peliculasDAO = FactoryDAO.getInstancePeliculasDAO(context);
        dataLogDAO = FactoryDAO.getInstanceDataLogDAO(context);
    }

    public void create(Pelicula pelicula) {
        dataLogDAO.create("Insertando pelicula : " + pelicula);
        peliculasDAO.create(pelicula);

    }


    public List<Pelicula> read() {
        List<Pelicula> peliculas = peliculasDAO.read();
        dataLogDAO.create("Mostrando todas las peliculas: " + peliculas);
        return peliculas;
    }


    public Pelicula read(Integer id) {
        Pelicula pelicula = peliculasDAO.read(id);
        dataLogDAO.create("Obteniendo pelicula con id : "+ id + " " + pelicula);
        return pelicula;
    }


    public void update(Pelicula pelicula) {
        dataLogDAO.create("Actualizando pelicula: Pelicula vieja: " + peliculasDAO.read(pelicula.getId()) + " Pelicula nueva :  " + pelicula);
        peliculasDAO.update(pelicula);

    }


    public void delete(Integer id) {
        dataLogDAO.create("Borrando pelicula: " + peliculasDAO.read(id));
        peliculasDAO.delete(id);
    }
    public List<DataLog> showLogs(){
        return dataLogDAO.showLogs();
    }
    public void clearLogs(){
        dataLogDAO.clearLogs();
    }
    public void deleteAll(){

        List<Pelicula> peliculas = peliculasDAO.read();
        for(Pelicula pelicula : peliculas){
            delete(pelicula.getId());
        }

    }
}
