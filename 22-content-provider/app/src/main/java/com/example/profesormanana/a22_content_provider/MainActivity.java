package com.example.profesormanana.a22_content_provider;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ContentResolver resolver = getContentResolver();
        String URL="content://com.example.profesormanana.a22_content_provider/Pelicula";
        Uri uri = Uri.parse(URL);
        ContentValues values = new ContentValues();
        values.put(PeliculasSQLiteDAO.PELICULAS_TITULO,"El señor de los arillos");
        values.put(PeliculasSQLiteDAO.PELICULAS_DIRECTOR,"Mortadelo y filemón");
        values.put(PeliculasSQLiteDAO.PELICULAS_SINOPSIS,"Pues va de llevar un anillo a mordor.");
        getContentResolver().insert(uri, values);
        Cursor cursor = getContentResolver().query(uri, new String[]{PeliculasSQLiteDAO.PELICULAS_ID, PeliculasSQLiteDAO.PELICULAS_TITULO}, null, null, null);
        while (cursor.moveToNext()){
            Pelicula peli = new Pelicula();
            peli.setTitulo(cursor.getString(cursor.getColumnIndex(PeliculasSQLiteDAO.PELICULAS_TITULO)));
            peli.setId(cursor.getInt(cursor.getColumnIndex(PeliculasSQLiteDAO.PELICULAS_ID)));
            Log.d(this.getClass().toString(),"Pelicula encontrada : " + peli);
        }
    }
}
