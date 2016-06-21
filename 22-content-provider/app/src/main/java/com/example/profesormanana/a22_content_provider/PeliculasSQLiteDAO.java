package com.example.profesormanana.a22_content_provider;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by profesormanana on 20/6/16.
 */
public class PeliculasSQLiteDAO extends SQLiteOpenHelper {
    private static final String DATABASE_NAME;
    private static final int DATABASE_VERSION;
    public static final String TABLE_PELICULAS;
    public static final String PELICULAS_ID;
    public static final String PELICULAS_TITULO;
    public static final String PELICULAS_DIRECTOR;
    public static final String PELICULAS_SINOPSIS;

    static {
        DATABASE_NAME = "PELICULAS";
        DATABASE_VERSION = 1;
        TABLE_PELICULAS = "PELICULAS";
        PELICULAS_ID = "ID" ;
        PELICULAS_TITULO = "TITULO";
        PELICULAS_DIRECTOR = "DIRECTOR";
        PELICULAS_SINOPSIS = "SINOPSIS";
    }
    public PeliculasSQLiteDAO(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(this.getClass().toString(),"Constuyendo la tabla " + TABLE_PELICULAS);
        db.execSQL("CREATE TABLE " + TABLE_PELICULAS + " (" +
                PELICULAS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                PELICULAS_TITULO + " TEXT, " +
                PELICULAS_DIRECTOR + " TEXT, " +
                PELICULAS_SINOPSIS + " TEXT);");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
