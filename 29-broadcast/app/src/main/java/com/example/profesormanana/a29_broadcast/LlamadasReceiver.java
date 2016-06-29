package com.example.profesormanana.a29_broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by profesormanana on 28/6/16.
 */
public class LlamadasReceiver extends BroadcastReceiver {
    private static String TAG;
    private static String ultimoEstado;
    static {
        TAG = "LlamadasReceiver";
    }
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        Log.d(TAG,"Evento de llamada recibido!");
        if(extras != null){
            String estado = extras.getString(TelephonyManager.EXTRA_STATE);
            if(!estado.equals(ultimoEstado)){
                ultimoEstado = estado;
                Toast.makeText(context,"Estado de la llamada: " +estado,Toast.LENGTH_SHORT).show();
                if(estado.equals(TelephonyManager.EXTRA_STATE_RINGING)){
                    String numeroTelefono = extras.getString(TelephonyManager.EXTRA_INCOMING_NUMBER);
                    Toast.makeText(context,"Telefono: "+ numeroTelefono,Toast.LENGTH_SHORT).show();
                }
            }
        }

    }
}
