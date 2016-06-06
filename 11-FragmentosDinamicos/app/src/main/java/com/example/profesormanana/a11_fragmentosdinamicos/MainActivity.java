package com.example.profesormanana.a11_fragmentosdinamicos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//Internamente se invoca el onCreateView de los fragmentos

        final View fragmentoDetalle = findViewById(R.id.fragmentDetalle);

        if (fragmentoDetalle != null) {

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            transaction.add(R.id.fragmentDetalle, new NoCorreosFragment());

            transaction.commit();
        }

        //final DetalleCorreoFragment fragmentoDetalle = (DetalleCorreoFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentDetalle);
        final ListadoCorreosFragment fragmentoListado = (ListadoCorreosFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentListado);

        fragmentoListado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CorreoElectronico item = (CorreoElectronico) parent.getAdapter().getItem(position);

                if (fragmentoDetalle != null){
                    //Es que estoy en tablet
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

                    DetalleCorreoFragment tmp = new DetalleCorreoFragment();

                    transaction.replace(R.id.fragmentDetalle, tmp);

                    transaction.commit();//El commit no es sincrono, no se ejecuta inmediatamente

                    //Esto no lo podemos hacer, ya que no teenmos la certeza de que se haya ejecutado en onCreateView del Fragmento
                    //tmp.actualizarDetalle(item);

                    getIntent().putExtra(DetalleCorreoFragment.DATO_CORREO_ELECTONICO, item);
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
