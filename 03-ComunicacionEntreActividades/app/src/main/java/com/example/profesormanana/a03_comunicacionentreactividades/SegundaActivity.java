package com.example.profesormanana.a03_comunicacionentreactividades;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class SegundaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        String parametro = getIntent().getStringExtra("parametro");

        Toast toast = Toast.makeText(this, "Este es el parametro: " + parametro, Toast.LENGTH_SHORT);

        toast.show();


    }
}
