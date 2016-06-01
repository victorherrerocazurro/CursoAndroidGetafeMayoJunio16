package com.example.profesormanana.a08_pizzas_recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.Arrays;
import java.util.List;

public class NuevaPizzaActivity extends AppCompatActivity {

    //private Intent intentRespuesta = new Intent();
    public static final String PIZZA = "pizza";
    public static final String POSICION = "posicion";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_pizza);

        List<String> ingredientes = Arrays.asList(new String[]{"mozzarela", "tomate", "cebolla"});

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ingredientes);

        final Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);

        spinner1.setAdapter(adapter);

        final Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);

        spinner2.setAdapter(adapter);

        final Spinner spinner3 = (Spinner) findViewById(R.id.spinner3);

        spinner3.setAdapter(adapter);


        Pizza pizza = (Pizza) getIntent().getSerializableExtra(NuevaPizzaActivity.PIZZA);
        int posicion = getIntent().getIntExtra(NuevaPizzaActivity.POSICION, -1);

        if(posicion != -1){
            //Estamos en edicion
            spinner1.setSelection(adapter.getPosition(pizza.getIngredientes().get(0)));
            spinner2.setSelection(adapter.getPosition(pizza.getIngredientes().get(1)));
            spinner3.setSelection(adapter.getPosition(pizza.getIngredientes().get(2)));
            //TODO Falta el TextView del Nombre de la Pizza
            //intentRespuesta.putExtra(MainActivity.POSICION, posicion);
        }


        findViewById(R.id.btAdd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Pizza pizza = new Pizza(
                        Arrays.asList(new String[]{
                                spinner1.getSelectedItem().toString(),
                                spinner2.getSelectedItem().toString(),
                                spinner3.getSelectedItem().toString()
                        }), ""
                );

                //intentRespuesta.putExtra(MainActivity.PIZZA,pizza);
                //setResult(RESULT_OK, intentRespuesta);

                getIntent().putExtra(NuevaPizzaActivity.PIZZA,pizza);
                setResult(RESULT_OK, getIntent());

                finish();

            }
        });

    }
}
