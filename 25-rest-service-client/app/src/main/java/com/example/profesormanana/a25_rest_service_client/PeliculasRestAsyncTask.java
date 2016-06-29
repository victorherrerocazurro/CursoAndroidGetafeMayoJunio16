package com.example.profesormanana.a25_rest_service_client;


import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by profesormanana on 24/6/16.
 */
public class PeliculasRestAsyncTask extends AsyncTask<Void,Void,String>{

    private static final String SERVER_URL = "http://10.1.2.100:8080/ejemplo-rest/rest/peliculas";
    @Override
    protected String doInBackground(Void... params) {
        // Creación del cliente HTTP
        URL urlPeliculasRest = null;


        try {
            urlPeliculasRest = new URL(SERVER_URL);
            HttpURLConnection conexion = (HttpURLConnection) urlPeliculasRest.openConnection();
            //conexion.setRequestMethod("POST");
            conexion.setDoOutput(true);
            conexion.setUseCaches(false);
            conexion.setAllowUserInteraction(false);
            conexion.setRequestProperty("Content-Type","application/json; charset=utf8");
            conexion.connect();
            OutputStreamWriter writer = new OutputStreamWriter(conexion.getOutputStream());
            // defino la información que hay que enviar.
            Pelicula pelicula = new Pelicula();
            pelicula.setTitulo("Torrente");
            pelicula.setDirector("Santiago Segura");
            pelicula.setSinopsis("Va de una mascota alienigena simpatica y cariñosa");
            // {"id":null,"titulo":"Torrente","director":"Santiago Segura","sinopsis":"Va de una mascota cariñosa"}
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.serializeNulls();
            Gson gson = gsonBuilder.create();

            String peliculaString = gson.toJson(pelicula);
            writer.write(peliculaString);
            writer.flush();
           // writer.close();
           // conexion.getOutputStream().close();
            Log.d("Resultado",conexion.getResponseCode()+"");
            Log.d("Resultado",conexion.getResponseMessage()+"");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
