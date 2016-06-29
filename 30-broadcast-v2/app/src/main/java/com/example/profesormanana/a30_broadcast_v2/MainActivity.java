package com.example.profesormanana.a30_broadcast_v2;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editTextTiempo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextTiempo = (EditText) findViewById(R.id.editTextNumeroSegundos);
        Button directo = (Button) findViewById(R.id.buttonDirecto);
        // Evento para mandar un broadcast esplícito
        directo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.example.profesormanana.a30_broadcast_v2");// Mando el mensaje donde haya suscrito al broadcastReceiver para que lo escuche
                sendBroadcast(intent);
            }
        });
        Button empezar = (Button) findViewById(R.id.buttonEmpezar);
        empezar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer segundos = Integer.parseInt(editTextTiempo.getText().toString());// Segundos en el campo de texto
                Intent intent = new Intent(getApplicationContext(),AlarmaBroadcast.class);// Intención para apuntar al BroadcastReceiver de la alarma
                // Intent que se dispara con posterioridad.
                PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(),11122121,intent,PendingIntent.FLAG_UPDATE_CURRENT);
                AlarmManager manager = (AlarmManager)getSystemService(ALARM_SERVICE);
                manager.set(AlarmManager.RTC,System.currentTimeMillis() + (segundos*1000),pendingIntent);
            }
        });
    }
}
