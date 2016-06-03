package com.example.profesormanana.a10_fragmentos;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final DetalleCorreoFragment fragmentoDetalle = (DetalleCorreoFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentDetalle);
        final ListadoCorreosFragment fragmentoListado = (ListadoCorreosFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentListado);


        fragmentoListado.setOnItemSelectedListadoCorreos(new OnItemSelectedListadoCorreosListener() {
            @Override
            public void onItemSelected(CorreoElectronico item) {
                if (fragmentoDetalle != null){
                    //Es que estoy en tablet
                    fragmentoDetalle.actualizarDetalle(item);
                } else {
                    //Es que estoy en smartphone
                    Intent intent = new Intent(MainActivity.this,DetalleActivity.class);

                    intent.putExtra(DetalleCorreoFragment.DATO_CORREO_ELECTONICO, item);

                    startActivity(intent);
                }
            }
        });




    }
}
