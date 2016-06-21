package com.example.profesormanana.a21_sqlite;

import android.content.Context;

/**
 * Created by profesormanana on 21/6/16.
 */
public class FactoryDAO {
    private static IPeliculasDAO peliculasDAO;
    private static IDataLogDAO dataLogDAO;

    public static IPeliculasDAO getInstancePeliculasDAO(Context context){
        if(peliculasDAO == null){
            // en el caso de que se lea la shared preference sql
            peliculasDAO = new PeliculasMemoryDAO();
        }
        return peliculasDAO;
    }
    public static IDataLogDAO getInstanceDataLogDAO(Context context){
        if(dataLogDAO == null){
            dataLogDAO = new DataLogSQLiteDAO(context);
        }
        return dataLogDAO;
    }
}
