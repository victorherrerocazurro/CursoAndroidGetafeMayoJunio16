package com.example.profesormanana.a23_content_resolver;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    public static final String TABLE_PELICULAS;
    public static final String PELICULAS_ID;
    public static final String PELICULAS_TITULO;
    public static final String PELICULAS_DIRECTOR;
    public static final String PELICULAS_SINOPSIS;

    static {
        TABLE_PELICULAS = "PELICULAS";
        PELICULAS_ID = "ID" ;
        PELICULAS_TITULO = "TITULO";
        PELICULAS_DIRECTOR = "DIRECTOR";
        PELICULAS_SINOPSIS = "SINOPSIS";
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ContentResolver resolver = getContentResolver();
        String URL="content://com.example.profesormanana.a22_content_provider/Pelicula";
        Uri uri = Uri.parse(URL);
        ContentValues values = new ContentValues();
        values.put(PELICULAS_TITULO,"El señor de los arillos");
        values.put(PELICULAS_DIRECTOR,"Mortadelo y filemón");
        values.put(PELICULAS_SINOPSIS,"Pues va de llevar un anillo a mordor.");
        getContentResolver().insert(uri, values);
        Cursor cursor = getContentResolver().query(uri, new String[]{PELICULAS_ID, PELICULAS_TITULO}, null, null, null);
        while (cursor.moveToNext()){
            Pelicula peli = new Pelicula();
            peli.setTitulo(cursor.getString(cursor.getColumnIndex(PELICULAS_TITULO)));
            peli.setId(cursor.getInt(cursor.getColumnIndex(PELICULAS_ID)));
            Log.d(this.getClass().toString(),"Pelicula encontrada : " + peli);
        }
    }
}
