package com.example.profesormanana.a06_pizzas;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE_NUEVA_PIZZA_ACTIVITY = 1;
    public static final String PIZZA = "pizza";

    private List<Pizza> pizzas;
    private PizzaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inicilizar el Boton
        findViewById(R.id.btAdd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Abrimos la actividad de Creacion de Pizza
                Intent intent = new Intent(MainActivity.this, NuevaPizzaActivity.class);

                startActivityForResult(intent, REQUEST_CODE_NUEVA_PIZZA_ACTIVITY);
            }
        });

        pizzas = new LinkedList<>();

        adapter = new PizzaAdapter(pizzas);

        //Inicilizar el ListView
        ((ListView)findViewById(R.id.lvPizzas)).setAdapter(adapter);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE_NUEVA_PIZZA_ACTIVITY){
            if(resultCode == Activity.RESULT_OK){
                //Añadir la pizza al listado de pizzas
                Pizza pizza = (Pizza) data.getSerializableExtra(PIZZA);

                pizzas.add(pizza);

                //Le decimos al ListView que el origen de datos ha sido actualizado

                adapter.notifyDataSetChanged();

            } else {
                //Ha habido un porblema y la pizza no se añade
            }
        }
    }
}
