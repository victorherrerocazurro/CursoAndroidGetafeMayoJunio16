package com.example.profesormanana.a13_sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = getSharedPreferences("MisConfiguraciones", Context.MODE_PRIVATE);

        //Lectura

        lectura(sharedPreferences);

        //Fin lectura

        //Escritura

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("prefijo", "Adios");
        editor.putString("sufijo", " muy buenas");

        editor.commit();

        //Fin escritura

        lectura(sharedPreferences);

    }

    private void lectura(SharedPreferences sharedPreferences){
        String prefijo = sharedPreferences.getString("prefijo", "hola");
        String sufijo = sharedPreferences.getString("sufijo", "!!!!!");

        Toast.makeText(this, prefijo + " Victor " + sufijo, Toast.LENGTH_SHORT).show();

    }
}
