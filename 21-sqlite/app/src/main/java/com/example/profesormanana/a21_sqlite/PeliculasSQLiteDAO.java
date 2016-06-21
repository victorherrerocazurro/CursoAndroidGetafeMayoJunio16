package com.example.profesormanana.a21_sqlite;

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
public class PeliculasSQLiteDAO extends SQLiteOpenHelper implements IPeliculasDAO {
    private static final String DATABASE_NAME;
    private static final int DATABASE_VERSION;
    private static final String TABLE_PELICULAS;
    private static final String PELICULAS_ID;
    private static final String PELICULAS_TITULO;
    private static final String PELICULAS_DIRECTOR;
    private static final String PELICULAS_SINOPSIS;

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
    public void create(Pelicula pelicula){
        Log.d(this.getClass().toString(),"Insertando pelicula : " + pelicula.toString());
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(PELICULAS_TITULO,pelicula.getTitulo());
        values.put(PELICULAS_DIRECTOR,pelicula.getDirector());
        values.put(PELICULAS_SINOPSIS,pelicula.getSinopsis());
        sqLiteDatabase.insert(TABLE_PELICULAS,null,values);
        //INSERT INTO PELICULAS(TITULO,DIRECTOR,SINOPSIS) VALUES (_,_,_);
    }
    @Override
    public List<Pelicula> read(){

        Log.d(this.getClass().toString(),"Listando peliculas");
        List<Pelicula> peliculas= new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query(TABLE_PELICULAS, new String[]{PELICULAS_ID, PELICULAS_TITULO, PELICULAS_DIRECTOR, PELICULAS_SINOPSIS}, null, null, null, null, null);
        while(cursor.moveToNext()){
            Pelicula pelicula = new Pelicula();
            pelicula.setId(cursor.getInt(cursor.getColumnIndex(PELICULAS_ID)));
            pelicula.setTitulo(cursor.getString(cursor.getColumnIndex(PELICULAS_TITULO)));
            pelicula.setDirector(cursor.getString(cursor.getColumnIndex(PELICULAS_DIRECTOR)));
            pelicula.setSinopsis(cursor.getString(cursor.getColumnIndex(PELICULAS_SINOPSIS)));
            peliculas.add(pelicula);
        }
        return peliculas;
    }
    @Override
    public Pelicula read(Integer id){

        Log.d(this.getClass().toString(),"Buscando pelicula con id " + id);
        Pelicula pelicula = null;
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        // SELECT ID,TITULO,DIRECTOR,SINOPSIS FROM PELICULAS WHERE ID = ?
        Cursor cursor = sqLiteDatabase.query(
                TABLE_PELICULAS,
                new String[]{PELICULAS_ID,PELICULAS_TITULO,PELICULAS_DIRECTOR, PELICULAS_SINOPSIS},
                PELICULAS_ID + " = ?",
                new String[]{id.toString()}, null, null, null);
        if(cursor.moveToNext()){
            pelicula = new Pelicula();
            pelicula.setId(cursor.getInt(cursor.getColumnIndex(PELICULAS_ID)));
            pelicula.setTitulo(cursor.getString(cursor.getColumnIndex(PELICULAS_TITULO)));
            pelicula.setDirector(cursor.getString(cursor.getColumnIndex(PELICULAS_DIRECTOR)));
            pelicula.setSinopsis(cursor.getString(cursor.getColumnIndex(PELICULAS_SINOPSIS)));

        }
        return pelicula;
    }
    @Override
    public void update(Pelicula pelicula){
        Log.d(this.getClass().toString(),"Actualizando pelicula con id " + pelicula.getId());
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(PELICULAS_TITULO,pelicula.getTitulo());
        values.put(PELICULAS_DIRECTOR,pelicula.getDirector());
        values.put(PELICULAS_SINOPSIS,pelicula.getSinopsis());
        sqLiteDatabase.update(TABLE_PELICULAS, values, PELICULAS_ID + " = ?", new String[]{pelicula.getId().toString()});
    }
    @Override
    public void delete(Integer id){
        Log.d(this.getClass().toString(),"Borrando pelicula con id = " + id);
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.delete(TABLE_PELICULAS, PELICULAS_ID + " = ?", new String[]{id.toString()});
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
