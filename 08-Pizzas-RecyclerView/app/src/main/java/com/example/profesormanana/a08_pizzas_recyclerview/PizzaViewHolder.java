package com.example.profesormanana.a08_pizzas_recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by profesormanana on 30/5/16.
 */
public class PizzaViewHolder extends RecyclerView.ViewHolder {

    private TextView tvTitulo;
    private TextView tvIngredientes;

    public PizzaViewHolder(View itemView) {
        super(itemView);
        tvTitulo = (TextView) itemView.findViewById(R.id.tvTitulo);
        tvIngredientes = (TextView) itemView.findViewById(R.id.tvIngredientes);
    }

    public void bindPizza(Pizza pizza) {
        tvTitulo.setText(pizza.getNombre());
        tvIngredientes.setText(pizza.getIngredientes().toString());
    }
}
