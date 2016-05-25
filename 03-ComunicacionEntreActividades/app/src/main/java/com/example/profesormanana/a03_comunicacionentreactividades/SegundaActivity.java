package com.example.profesormanana.a03_comunicacionentreactividades;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.Serializable;

public class SegundaActivity extends AppCompatActivity {

    public static final int RESULTADO_CORRECTO = 10;
    public static final int REQUEST_TERCERA_ACTIVITY = 12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        String parametro = getIntent().getStringExtra("parametro");

        Persona persona = (Persona) getIntent().getSerializableExtra("persona");

        Toast toast = Toast.makeText(this,
                "Este es el parametro: " +
                        parametro +
                        ", y este el nombre de la persona: " +
                        persona.getNombre(), Toast.LENGTH_SHORT);

        toast.show();


        View view = findViewById(R.id.textView);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Lance la intencion de abrir la actividad secundaria
                Intent intent = new Intent(SegundaActivity.this, TerceraActivity.class);

                Bundle extras = intent.getExtras();

                intent.putExtra("parametro", "este es el dato a transferir a la aqctividad secundaria");
                intent.putExtra("persona", new Persona("Victor", new Direccion()));

                //MainActivity.this.startActivity(intent);
                SegundaActivity.this.startActivityForResult(intent, REQUEST_TERCERA_ACTIVITY);

            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Intent intent = new Intent();

        intent.putExtra("resultado", "Este es el resultado del a operacion");

        setResult(RESULTADO_CORRECTO, intent);

        finish();

    }
}
