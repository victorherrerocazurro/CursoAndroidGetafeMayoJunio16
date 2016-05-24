package com.example.profesormanana.a03_comunicacionentreactividades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Lance la intencion de abrir la actividad secundaria
                Intent intent = new Intent(MainActivity.this, SegundaActivity.class);

                intent.putExtra("parametro", "este es el dato a transferir a la aqctividad secundaria");
                intent.putExtra("parametro2", "este es el dato a transferir a la aqctividad secundaria");

                MainActivity.this.startActivity(intent);

            }
        });

    }

}
