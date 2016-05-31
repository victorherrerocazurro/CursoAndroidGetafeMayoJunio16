package com.example.profesormanana.a06_pizzas;

import android.widget.TextView;

/**
 * Created by profesormanana on 30/5/16.
 */
public class PizzaViewHolder {

    private TextView tvTitulo;
    private TextView tvIngradientes;

    public PizzaViewHolder(TextView tvTitulo, TextView tvIngradientes) {
        this.tvTitulo = tvTitulo;
        this.tvIngradientes = tvIngradientes;
    }

    public TextView getTvTitulo() {
        return tvTitulo;
    }

    public void setTvTitulo(TextView tvTitulo) {
        this.tvTitulo = tvTitulo;
    }

    public TextView getTvIngradientes() {
        return tvIngradientes;
    }

    public void setTvIngradientes(TextView tvIngradientes) {
        this.tvIngradientes = tvIngradientes;
    }
}
