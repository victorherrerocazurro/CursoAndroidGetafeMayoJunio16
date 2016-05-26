package com.example.profesormanana.a05_adapterview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Necesitamos la coleccion
        List<Pelicula> peliculas =
                ServicioPeliculas.consultarTodasLasPeliculas();

        //Necesitamos el ListView que representará las peliculas
        ListView lvPeliculas = (ListView) findViewById(R.id.lvPeliculas);

        //Relacionar ListView con el List<Peliculas>
        //ArrayAdapter<Pelicula> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, peliculas);

        PeliculasArrayAdapter adapter = new PeliculasArrayAdapter(peliculas);

        lvPeliculas.setAdapter(adapter);

    }
}
