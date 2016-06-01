package com.example.profesormanana.a08_pizzas_recyclerview;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_NUEVA_PIZZA_ACTIVITY = 1;
    private static final int REQUEST_CODE_EDITAR_PIZZA_ACTIVITY = 2;

    private PizzaAdapter pizzaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rvPizzas = (RecyclerView) findViewById(R.id.rvPizzas);

        List<Pizza> listadoPizzas = new LinkedList<>();

        pizzaAdapter = new PizzaAdapter(listadoPizzas);

        rvPizzas.setAdapter(pizzaAdapter);

        rvPizzas.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false));

        findViewById(R.id.btAdd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Abrimos la actividad de Creacion de Pizza
                Intent intent = new Intent(MainActivity.this, NuevaPizzaActivity.class);

                startActivityForResult(intent, REQUEST_CODE_NUEVA_PIZZA_ACTIVITY);
            }
        });

        //Gestionar los eventos de Swipe
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new PizzasCallback(new OnSwipeListener() {
            @Override
            public void onSwipeRight(RecyclerView.ViewHolder viewHolder) {
                //Borrado
                pizzaAdapter.removePizza(viewHolder.getAdapterPosition());
            }

            @Override
            public void onSwipeLeft(RecyclerView.ViewHolder viewHolder) {
                //Edicion
                //Abrimos la actividad de Edicion de la Pizza
                Intent intent = new Intent(MainActivity.this, NuevaPizzaActivity.class);

                Pizza pizza = pizzaAdapter.getPizza(viewHolder.getAdapterPosition());
                intent.putExtra(NuevaPizzaActivity.PIZZA, pizza);
                intent.putExtra(NuevaPizzaActivity.POSICION, viewHolder.getAdapterPosition());

                startActivityForResult(intent, REQUEST_CODE_EDITAR_PIZZA_ACTIVITY);
            }
        }));

        itemTouchHelper.attachToRecyclerView(rvPizzas);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE_NUEVA_PIZZA_ACTIVITY){
            if(resultCode == Activity.RESULT_OK){
                //Añadir la pizza al listado de pizzas
                Pizza pizza = (Pizza) data.getSerializableExtra(NuevaPizzaActivity.PIZZA);

                pizzaAdapter.addPizza(pizza);

            } else {
                //Ha habido un porblema y la pizza no se añade
            }
        } else if(requestCode == REQUEST_CODE_EDITAR_PIZZA_ACTIVITY){
            if(resultCode == Activity.RESULT_OK){
                Pizza pizza = (Pizza) data.getSerializableExtra(NuevaPizzaActivity.PIZZA);
                int posicion = data.getIntExtra(NuevaPizzaActivity.POSICION,-1);

                //Intercambio entre la pizza existente, que es la antigua version de la pizza y
                //la nueva pizza
                if (posicion != -1)
                {
                    pizzaAdapter.editPizza(posicion,pizza);
                }

            } else {
                //Ha habido un porblema y la pizza no se añade
            }

        }

    }
}
