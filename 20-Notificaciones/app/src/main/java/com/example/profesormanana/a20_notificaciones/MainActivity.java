package com.example.profesormanana.a20_notificaciones;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final NotificationCompat.Builder builder = new NotificationCompat.Builder(this);

        Intent intent = new Intent(this, MainActivity.class);

        PendingIntent pendingIntentBorrar = PendingIntent.getActivity(this, 1, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        builder
                .setAutoCancel(true)
                .setContentTitle(getResources().getString(R.string.titulo_notificacion))
                .setContentIntent(pendingIntentBorrar)
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setStyle(new android.support.v4.app.NotificationCompat.BigPictureStyle().bigPicture(BitmapFactory.decodeResource(getResources(), android.R.drawable.ic_dialog_info)))
                .setTicker("Esto desaparece")
                .setShowWhen(true)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), android.R.drawable.ic_dialog_info))
                .addAction(android.R.drawable.ic_delete, "Borrar", pendingIntentBorrar);

        findViewById(R.id.texto).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                builder
                        .setContentText("El mensaje " + i++)
                        .setWhen(new Date().getTime())
                        .setProgress(100, i*10, false);


                Notification notificacion = builder.build();

                NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(MainActivity.this);

                notificationManagerCompat.notify(2, notificacion);

            }
        });

    }
}
