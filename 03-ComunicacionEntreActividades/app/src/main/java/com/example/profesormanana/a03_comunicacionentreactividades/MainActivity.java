package com.example.profesormanana.a03_comunicacionentreactividades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_SEGUNDA_ACTIVITY = 15;

    private Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boton = (Button) findViewById(R.id.button);


        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Lance la intencion de abrir la actividad secundaria
                Intent intent = new Intent(MainActivity.this, SegundaActivity.class);

                Bundle extras = intent.getExtras();

                intent.putExtra("parametro", "este es el dato a transferir a la aqctividad secundaria");
                intent.putExtra("persona", new Persona("Victor", new Direccion()));

                //MainActivity.this.startActivity(intent);
                MainActivity.this.startActivityForResult(intent, REQUEST_SEGUNDA_ACTIVITY);

            }
        });

        findViewById(R.id.editText).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Lance la intencion de abrir la actividad secundaria
                Intent intent = new Intent("com.example.profesormanana.a03_comunicacionentreactividades.ABRIR_TERCERA_ACTIVITY");

                Bundle extras = intent.getExtras();

                intent.putExtra("parametro", "este es el dato a transferir a la aqctividad secundaria");
                intent.putExtra("persona", new Persona("Victor", new Direccion()));

                //MainActivity.this.startActivity(intent);
                MainActivity.this.startActivityForResult(intent, REQUEST_SEGUNDA_ACTIVITY);

            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent datosRecibidosDesdeLaActividadSecundaria) {
        super.onActivityResult(requestCode, resultCode, datosRecibidosDesdeLaActividadSecundaria);

        switch (requestCode){
            case REQUEST_SEGUNDA_ACTIVITY:
                switch (resultCode){
                    case SegundaActivity.RESULTADO_CORRECTO:

                        Toast.makeText(this,datosRecibidosDesdeLaActividadSecundaria.getStringExtra("resultado"),Toast.LENGTH_SHORT).show();

                        break;
                }
                break;
        }

    }
}
