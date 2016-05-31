package com.example.profesormanana.a07_recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by profesormanana on 31/5/16.
 */
public class PeliculasViewHolder extends RecyclerView.ViewHolder {

    private TextView tvTitulo;
    private TextView tvActores;
    private TextView tvFecha;

    public PeliculasViewHolder(View itemView) {
        super(itemView);

        tvTitulo = (TextView) itemView.findViewById(R.id.tvTitulo);
        tvActores = (TextView) itemView.findViewById(R.id.tvActores);
        tvFecha = (TextView) itemView.findViewById(R.id.tvFecha);
    }

    public void bindItem(Pelicula item){
        tvTitulo.setText(item.getTitulo());
        tvActores.setText(item.getActores().toString());
        tvFecha.setText(item.getFechaEstreno().toString());
    }
}
