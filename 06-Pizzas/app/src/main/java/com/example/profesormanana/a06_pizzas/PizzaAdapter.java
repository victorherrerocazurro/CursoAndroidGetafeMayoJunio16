package com.example.profesormanana.a06_pizzas;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by profesormanana on 27/5/16.
 */
public class PizzaAdapter extends BaseAdapter {

    //Coleccion de Pizzas ordenada como se vaya a representar
    private List<Pizza> pizzas;

    public PizzaAdapter(List<Pizza> pizzas) {
        this.pizzas = new LinkedList<>(pizzas);
    }

    @Override
    public int getCount() {
        return pizzas.size();
    }

    @Override
    public Object getItem(int position) {
        return pizzas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Pizza pizza = pizzas.get(position);

        if(convertView == null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.pizza_list_item,parent,false);

            convertView.setTag(new PizzaViewHolder((TextView)convertView.findViewById(R.id.tvTitulo),(TextView)convertView.findViewById(R.id.tvIngredientes)));
        }

        ((PizzaViewHolder)convertView.getTag()).getTvTitulo().setText(pizza.getNombre());
        ((PizzaViewHolder)convertView.getTag()).getTvIngradientes().setText(pizza.getIngredientes().toString());

        return convertView;
    }

    //Esta implementacion del borrado, se basa en la coleccion ya ordenada
    public void removeItem(int position){
        pizzas.remove(position);
    }

    public void add(Pizza pizza) {
        pizzas.add(pizza);
    }

    public void add(int posicion, Pizza pizza) {
        pizzas.add(posicion, pizza);
    }
}
