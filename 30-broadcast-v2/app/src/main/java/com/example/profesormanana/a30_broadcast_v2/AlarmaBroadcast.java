package com.example.profesormanana.a30_broadcast_v2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Vibrator;
import android.widget.Toast;

/**
 * Created by profesormanana on 28/6/16.
 */
public class AlarmaBroadcast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"Acabó el tiempo!",Toast.LENGTH_SHORT).show();
        Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(2000);
        MediaPlayer player = MediaPlayer.create(context, R.raw.vaca);
        player.start();

    }
}
