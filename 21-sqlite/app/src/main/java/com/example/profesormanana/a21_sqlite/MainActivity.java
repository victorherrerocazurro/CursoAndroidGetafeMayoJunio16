package com.example.profesormanana.a21_sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PeliculasLN negocio = new PeliculasLN(getBaseContext());
        Pelicula pelicula = new Pelicula();
        pelicula.setTitulo("Termineitor");
        pelicula.setDirector("Yeims cameron");
        pelicula.setSinopsis("Va de un robot asesino del futuro");
        negocio.create(pelicula);
        List<Pelicula> peliculas = negocio.read();
        Integer idPelicula = null;
        for(Pelicula peliculaActual : peliculas){
            Log.i(this.getClass().toString(),"Pelicula : " + peliculaActual);
            idPelicula = peliculaActual.getId();
        }
        Pelicula peliculaOriginal = negocio.read(idPelicula);
        peliculaOriginal.setSinopsis("Va de un roboto asesino que luego se hace gobernador de California");
        negocio.update(peliculaOriginal);
        peliculas = negocio.read();

        for(Pelicula peliculaActual : peliculas){
            Log.i(this.getClass().toString(),"Pelicula : " + peliculaActual);
        }
        negocio.delete(idPelicula);
        peliculas = negocio.read();

        for(Pelicula peliculaActual : peliculas){
            Log.i(this.getClass().toString(),"Pelicula : " + peliculaActual);
        }

        List<DataLog> logs = negocio.showLogs();
        for (DataLog log : logs){
            Log.d("datalog",logs.toString());
        }
        negocio.clearLogs();
    }
}
