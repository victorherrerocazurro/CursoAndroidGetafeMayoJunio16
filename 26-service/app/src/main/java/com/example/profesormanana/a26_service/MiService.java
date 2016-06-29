package com.example.profesormanana.a26_service;


import android.app.IntentService;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

/**
 * Created by profesormanana on 27/6/16.
 */
public class MiService extends IntentService {

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     */
    public MiService() {

        super("MiService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        try {

            Log.d(this.getClass().toString(),"Inicializando onHandleIntent");
            showToastMessageOnMainThread("Inicializando onHandleIntent");
            Log.d(this.getClass().toString(),"Estoy realizando una tarea larga: 1 de 3");
            showToastMessageOnMainThread("Estoy realizando una tarea larga: 1 de 3");
            Thread.sleep(5000);
            Log.d(this.getClass().toString(),"Estoy realizando una tarea larga: 2 de 3");
            showToastMessageOnMainThread("Estoy realizando una tarea larga: 2 de 3");
            Thread.sleep(5000);
            Log.d(this.getClass().toString(),"Estoy realizando una tarea larga: 3 de 3");
            showToastMessageOnMainThread("Estoy realizando una tarea larga: 3 de 3");
            Thread.sleep(5000);
            showToastMessageOnMainThread("Tarea finalizada!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void showToastMessageOnMainThread(String message){
        Handler handler = new Handler(Looper.getMainLooper());
        final String msg = message ;
        handler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_SHORT).show();
            }
        });

    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(this.getClass().toString(),"Iniciando el servicio!");
        return super.onStartCommand(intent, flags, startId);
    }


}
