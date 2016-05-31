package com.example.profesormanana.a06_pizzas;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_NUEVA_PIZZA_ACTIVITY = 1;
    public static final String PIZZA = "pizza";
    private static final int REQUEST_CODE_EDITAR_PIZZA_ACTIVITY = 2;
    public static final String POSICION = "posicion";

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
        ListView listView = (ListView) findViewById(R.id.lvPizzas);

        listView.setAdapter(adapter);

        //Ya no queremos esta funcionalidad asociada al click sobre el item, sino que lo queremos asociado
        //al menu contextual
        /*listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Borrar el registro de la coleccion y actualizar el ListView

                //Como coincide la posición en el List y la posición en el ListView, pordemos hacer
                //Esta implementacion se basa en la coleccion externa al adapter, que puede estar
                //ordenada de forma distinta a la que el adapter representa
                //pizzas.remove(position);
                //En realidad lo optimo es acudir al adaptador, ya que es el que conoce como se ordenan
                //Object item = adapter.getItem(position);
                //pizzas.remove(item);
                //El caso anterior, nos borraria la primera de las ocurrencias
                adapter.removeItem(position);
                //Se podria pasar dentro del removeItem
                adapter.notifyDataSetChanged();

            }
        });*/

        //Registra MainActivity como el Listener de longClick sobre el componente visual listView
        //reaalizando MainActivity siempre el mismo procesamiento para todos los componentes, que es
        //mostrar el menuContexual asociado
        registerForContextMenu(listView);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE_NUEVA_PIZZA_ACTIVITY){
            if(resultCode == Activity.RESULT_OK){
                //Añadir la pizza al listado de pizzas
                Pizza pizza = (Pizza) data.getSerializableExtra(PIZZA);

                adapter.add(pizza);

                //Le decimos al ListView que el origen de datos ha sido actualizado

                adapter.notifyDataSetChanged();

            } else {
                //Ha habido un porblema y la pizza no se añade
            }
        } else if(requestCode == REQUEST_CODE_EDITAR_PIZZA_ACTIVITY){
            if(resultCode == Activity.RESULT_OK){
                Pizza pizza = (Pizza) data.getSerializableExtra(PIZZA);
                int posicion = data.getIntExtra(POSICION,-1);

                //Intercambio entre la pizza existente, que es la antigua version de la pizza y
                //la nueva pizza
                if (posicion != -1)
                {
                    //Primera opcion de la edicion
                    adapter.removeItem(posicion);
                    adapter.add(posicion, pizza);

                    //Segunda opcion de edicion
                    //Pizza pizzaOld = (Pizza) adapter.getItem(posicion);
                    //pizzaOld.setNombre(pizza.getNombre());

                    //pizzaOld.actualizar(pizza);

                    adapter.notifyDataSetChanged();
                }

            } else {
                //Ha habido un porblema y la pizza no se añade
            }

        }
    }

    //Es el que implementa realmente el Listener de la creacion del menu contextual
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        //Inflar en menu de opciones
        getMenuInflater().inflate(R.menu.context_menu_lvpizzas,menu);

        int position = ((AdapterView.AdapterContextMenuInfo) menuInfo).position;

        Pizza pizza = (Pizza) adapter.getItem(position);

        menu.setHeaderTitle(pizza.getIngredientes().toString());

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        switch (item.getItemId()){
            case R.id.menuItemPizzaBorrar:
                adapter.removeItem(menuInfo.position);
                adapter.notifyDataSetChanged();
                break;
            case R.id.menuItemPizzaEditar:
                //Abrimos la actividad de Edicion de la Pizza
                Intent intent = new Intent(MainActivity.this, NuevaPizzaActivity.class);

                Pizza pizza = (Pizza) adapter.getItem(menuInfo.position);
                intent.putExtra(PIZZA, pizza);
                intent.putExtra(POSICION, menuInfo.position);

                startActivityForResult(intent, REQUEST_CODE_EDITAR_PIZZA_ACTIVITY);
                break;
        }


        return true;
    }
}
