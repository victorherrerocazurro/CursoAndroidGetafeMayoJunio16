package com.example.profesormanana.a18_dialogos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DetalleActivity extends AppCompatActivity implements MiInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
    }

    @Override
    public void establecerResultadoPersonalizado(String dato) {

    }
}
