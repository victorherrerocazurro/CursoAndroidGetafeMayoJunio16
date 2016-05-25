package com.example.profesormanana.a04_ciclodevida;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //ESTADO: El objeto ha sido creado

    private TextView tvSaludo;

    private int contador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(this.getClass().getName(),"OnCreate");

        tvSaludo = (TextView) findViewById(R.id.tvSaludo);

        tvSaludo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DialogoActivity.class);

                startActivity(intent);

                contador++;

                ((TextView)v).setText("Contador: " + contador);
            }
        });

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SegundaActivity.class);

                startActivity(intent);
            }
        });

        if(savedInstanceState != null) {
            int contador = savedInstanceState.getInt("contador");

            tvSaludo.setText("Contador: " + contador);
        }

    }

    //ESTADO: El objeto ha sido Inicializado

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(this.getClass().getName(),"onStart");
    }

    //ESTADO: El objeto capta recursos

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(this.getClass().getName(),"onResume");
    }

    //ESTADO: Activo, es capaz de captar los evento de UI

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(this.getClass().getName(),"onPause");
    }

    // ESTADO: PAUSADO. Es visible de forma parcial, pero no es capaz de captar envento de UI,
    // por lo que no es ejecutable.

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(this.getClass().getName(),"onStop");
    }

    //ESTADO: PARADO. Se han liberado los recurso captados en el onStart. Normalmente se realiza la
    //captacion y liberacion de recursos en onResume y onPause, porque hay seguridad de invocacion

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(this.getClass().getName(),"onDestroy");
    }

    //ESTADO: El objeto reside en memoria, pero no tiene nadie que lo referencie, por lo que es
    //candidato a que el Garbage Collecto (GC) lo elimine.

    //Ciclo de vida alternativo

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(this.getClass().getName(),"onRestart");
    }

    //A emplear, solo cuando nos intere persistir caracteristicas del Objeto que no sean de tipo View,
    //ya que estas son persistidas directamente.

    //Almacenamiento del estado de la actividad, porque el objeto va a ser eliminado

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        Log.i(this.getClass().getName(),"onSaveInstanceState");

        outState.putInt("contador", contador);

    }

    //Restableciendo las caracteristicas del objeto, sobre un estado anterior que fue eliminado

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(this.getClass().getName(),"onRestoreInstanceState");


    }
}
