package com.example.profesormanana.a21_sqlite;

import java.util.List;

public class GestionPeliculas {
	
	private static IPeliculasDAO dao;
	
	static{
		dao = FactoryDAO.getInstancePeliculasDAO();
	}
	
	public void create(Pelicula pelicula) {
        dao.create(pelicula);
    }

	

    public Pelicula[] readAll() {
    	List<Pelicula> peliculas = dao.read();
        return peliculas.toArray(new Pelicula[peliculas.size()]);
    }


    public Pelicula read(Integer id) {
        return dao.read(id);
    }


    public void update(Pelicula pelicula) {
    	dao.update(pelicula);
    }


    public void delete(Integer id) {
        dao.delete(id);
    }
}
