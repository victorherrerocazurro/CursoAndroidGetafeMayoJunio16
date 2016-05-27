package com.example.profesormanana.a06_pizzas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.Arrays;
import java.util.List;

public class NuevaPizzaActivity extends AppCompatActivity {

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

                Intent intent = new Intent();

                intent.putExtra(MainActivity.PIZZA,pizza);

                setResult(RESULT_OK,intent);

                finish();

            }
        });

    }
}
