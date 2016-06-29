package com.android.peliculas;


import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/peliculas")
public class PeliculaRestService {
private static IPeliculasDAO dao;
	
	static{
		dao = FactoryDAO.getInstancePeliculasDAO();
	}
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void create(Pelicula pelicula) {
        dao.create(pelicula);
    }

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
    public List<Pelicula> readAll() {

        return dao.read();
    }
	
	
	@Path("{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
    public Pelicula read(@PathParam("id") Integer id) {
        return dao.read(id);
    }

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
    public void update(Pelicula pelicula) {
		dao.update(pelicula);
    }

    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") Integer id) {
        dao.delete(id);
    }
}
