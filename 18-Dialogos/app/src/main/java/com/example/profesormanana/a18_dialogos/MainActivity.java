package com.example.profesormanana.a18_dialogos;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class MainActivity extends AppCompatActivity implements View.OnClickListener, MiInterface {

    private TextView botonBasico;

    private String[] datos = new String[]{"Rojo", "Verde", "Azul"};
    private TextView botonSeleccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonBasico = (TextView) findViewById(R.id.btBasico);
        botonSeleccion = (TextView) findViewById(R.id.btSeleccion);

        botonBasico.setOnClickListener(this);
        findViewById(R.id.btPersonalizado).setOnClickListener(this);
        botonSeleccion.setOnClickListener(this);
        findViewById(R.id.btFecha).setOnClickListener(this);
        findViewById(R.id.btProgreso).setOnClickListener(this);
        findViewById(R.id.btTiempo).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btBasico:

                AlertDialogFragment alertDialogFragment = new AlertDialogFragment();

                alertDialogFragment.setNegativeListener(new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Toast.makeText(MainActivity.this, "Se pulso el NO", Toast.LENGTH_SHORT).show();
                        botonBasico.setText("No");
                    }
                });

                alertDialogFragment.setPositiveListener(new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Toast.makeText(MainActivity.this, "Se pulso el Si", Toast.LENGTH_SHORT).show();
                        botonBasico.setText("Si");
                    }
                });

                alertDialogFragment.show(getSupportFragmentManager(), "AlertDialog");

                break;
            case R.id.btPersonalizado:

                PersonalizadoDialogFragment personalizadoDialogFragment = new PersonalizadoDialogFragment();

                personalizadoDialogFragment.show(getSupportFragmentManager(),"PersonalizadoDialog");

                break;
            case R.id.btSeleccion:
                SeleccionDialogFragment seleccionDialogFragment = new SeleccionDialogFragment();

                seleccionDialogFragment.setDatos(datos);

                seleccionDialogFragment.setMultiChoiceListener(new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        //Toast.makeText(MainActivity.this, "Se ha seleccionado: " + datos[which], Toast.LENGTH_SHORT).show();
                        botonSeleccion.setText(datos[which]);
                    }
                });

                seleccionDialogFragment.show(getSupportFragmentManager(), "SeleccionDialog");
                break;
            case R.id.btFecha:

                Calendar calendar = Calendar.getInstance();


                DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                    }
                }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));

                datePickerDialog.show();

                break;
            case R.id.btProgreso:

                ProgressDialog progressDialog = new ProgressDialog(this);

                progressDialog.setMax(100);

                progressDialog.setProgress(0);

                progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);

                progressDialog.show();

                for (int i = 0; i < 100; i = i + 10 ){
                    progressDialog.setProgress(i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }


                break;
            case R.id.btTiempo:

                break;
        }
    }

    @Override
    public void establecerResultadoPersonalizado(String dato){
        botonSeleccion.setText(dato);
    }
}
