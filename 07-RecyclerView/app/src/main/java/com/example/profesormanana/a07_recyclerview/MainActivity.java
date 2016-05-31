package com.example.profesormanana.a07_recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rvPeliculas = (RecyclerView) findViewById(R.id.rvPeliculas);

        List<Pelicula> listadoPeliculas = ServicioPeliculas.consultarTodasLasPeliculas();

        RecyclerView.Adapter peliculasAdapter = new PeliculasAdapter(listadoPeliculas);

        rvPeliculas.setAdapter(peliculasAdapter);

        //rvPeliculas.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        rvPeliculas.setLayoutManager(new GridLayoutManager(this,1));

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new GenericItemTouchHelperCallback(peliculasAdapter));

        itemTouchHelper.attachToRecyclerView(rvPeliculas);

    }
}
