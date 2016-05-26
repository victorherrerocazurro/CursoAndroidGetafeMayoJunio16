package com.example.profesormanana.a05_adapterview;

import android.widget.TextView;

/**
 * Created by profesormanana on 26/5/16.
 */
public class PeliculasViewHolder {

    private TextView tvTitulo;
    private TextView tvActores;
    private TextView tvFecha;
    private Pelicula item;

    public PeliculasViewHolder(TextView tvTitulo, TextView tvActores, TextView tvFecha, Pelicula item){
        this.tvActores = tvActores;
        this.tvFecha = tvFecha;
        this.tvTitulo = tvTitulo;
        bindItem(item);
    }

    //Nos permite cuando reultilicemos el View, modificar el dato al que referencia
    public void bindItem(Pelicula item){
        this.item = item;
        tvTitulo.setText(item.getTitulo());
        tvActores.setText(item.getActores().toString());
        tvFecha.setText(item.getFechaEstreno().toString());
    }

}
