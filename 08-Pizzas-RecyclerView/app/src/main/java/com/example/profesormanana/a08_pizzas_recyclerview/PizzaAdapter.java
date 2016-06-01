package com.example.profesormanana.a08_pizzas_recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by profesormanana on 1/6/16.
 */
public class PizzaAdapter extends RecyclerView.Adapter<PizzaViewHolder> {

    private final List<Pizza> listadoPizzas;

    public PizzaAdapter(List<Pizza> listadoPizzas) {
        this.listadoPizzas = listadoPizzas;
    }

    @Override
    public PizzaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pizza_list_item, parent, false);
        return new PizzaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PizzaViewHolder holder, int position) {

        Pizza pizza = listadoPizzas.get(position);

        holder.bindPizza(pizza);

    }

    @Override
    public int getItemCount() {
        return listadoPizzas.size();
    }

    public void addPizza(Pizza pizza){
        listadoPizzas.add(0,pizza);
        //La notificacion se puede realizar con notifyDataSetChange, pero es menos eficiente porque
        //repintara todo el componente visual, en cambio los notify especificos se basan en la
        //posicion para repintar lo justo
        this.notifyItemInserted(0);
    }

    public void removePizza(int localizacion){
        listadoPizzas.remove(localizacion);
        this.notifyItemRemoved(localizacion);
    }

    public void editPizza(int posicion, Pizza pizza){
        listadoPizzas.remove(posicion);
        listadoPizzas.add(posicion,pizza);
        this.notifyItemChanged(posicion);
    }

    public Pizza getPizza(int posicion){
        return listadoPizzas.get(posicion);
    }
}
