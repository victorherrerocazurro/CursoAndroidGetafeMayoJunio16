package com.example.profesormanana.a29_broadcast;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG;
    static {
        TAG = "MainActivity";
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            if(ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE)!= PackageManager.PERMISSION_GRANTED){
                Log.i(TAG,"No tengo permisos. Preguntando!");
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_PHONE_STATE},100);

            }else{
                Log.i(TAG,"Permisos correctos");
            }
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == 100){
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this,"Permiso concedido",Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this,"Permiso denegado",Toast.LENGTH_SHORT).show();
            }
        }
        //super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
