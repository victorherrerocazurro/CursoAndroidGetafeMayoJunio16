package com.example.profesormanana.a14_asynctask;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by profesormanana on 9/6/16.
 */
public class DescargaImagenAsyncTask extends AsyncTask<String, Integer, Bitmap> {

    private final ImageView imageView;
    private final Context contexto;

    //Contructor que proporcione la referencia a los elementos visuales que se necesitan para
    //procesar el resultado y el progreso

    public DescargaImagenAsyncTask(ImageView imageView, Context contexto) {
        this.imageView = imageView;
        this.contexto = contexto;
    }

    //O metodos de set de los elementos visuales

    //Metodo que se ejecuta en un hilo secundario
    @Override
    protected Bitmap doInBackground(String... params){

        //Mi tarea de larga duracion

        try {
            URL url = new URL(params[0]);

            URLConnection connection = url.openConnection();

            int imageSize = connection.getContentLength();

            InputStream is = connection.getInputStream();

            byte[] resultado = new byte[imageSize];

            byte[] buffer = new byte[1024];

            int byteTotalesLeidos = 0;

            int byteLeidosEnLaIteracion;

            while((byteLeidosEnLaIteracion = is.read(buffer)) != -1){

                System.arraycopy(buffer, 0, resultado, byteTotalesLeidos, byteLeidosEnLaIteracion);

                byteTotalesLeidos += byteLeidosEnLaIteracion;

                publishProgress(byteTotalesLeidos*100/imageSize);//Debe ser con juicio
            }

            return BitmapFactory.decodeByteArray(resultado, 0, imageSize);

        } catch (MalformedURLException e) {
            e.printStackTrace();
            //Aqui no se puede lanzar un Toast, o mostrar una notificacion
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    //Metodos que se ejecutan en MainThread


    //Preparamos la interfaz de usuario para la eminente ejecucion de la tarea de larga duracion
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    //Actualizar la UI con el resultado de la operacion de larga duracion
    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        if(bitmap != null) {
            imageView.setImageBitmap(bitmap);
        } else {
            Toast.makeText(contexto, "Ha habido un error en la descarga", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        Toast.makeText(contexto, "Se lleva de prograso: " + values[0], Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
        Toast.makeText(contexto, "Se ha cancelado la tarea", Toast.LENGTH_SHORT).show();
    }
}
