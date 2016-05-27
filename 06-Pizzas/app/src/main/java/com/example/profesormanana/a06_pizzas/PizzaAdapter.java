package com.example.profesormanana.a06_pizzas;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by profesormanana on 27/5/16.
 */
public class PizzaAdapter extends BaseAdapter {

    private List<Pizza> pizzas;

    public PizzaAdapter(List<Pizza> pizzas) {
        this.pizzas = pizzas;
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
        }

        ((TextView)convertView.findViewById(R.id.tvTitulo)).setText(pizza.getNombre());
        ((TextView)convertView.findViewById(R.id.tvIngredientes)).setText(pizza.getIngredientes().toString());

        return convertView;
    }
}
