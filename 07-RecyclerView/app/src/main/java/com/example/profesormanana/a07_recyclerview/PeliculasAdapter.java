package com.example.profesormanana.a07_recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Collections;
import java.util.List;

/**
 * Created by profesormanana on 31/5/16.
 */
public class PeliculasAdapter extends RecyclerView.Adapter<PeliculasViewHolder> {

    private List<Pelicula> peliculas;

    public PeliculasAdapter(List<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }

    @Override
    public PeliculasViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Inflar la vista
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.peliculas_list_item, parent, false);
        //Envolver la vista con un ViewHolder
        return new PeliculasViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PeliculasViewHolder holder, int position) {
        Pelicula pelicula = peliculas.get(position);
        //Invocar la logica que rellene los View que componen el View asociado al ViewHolder
        //con los datos de pelicula
        holder.bindItem(pelicula);
    }

    @Override
    public int getItemCount() {
        return peliculas.size();
    }

    public void intercambiar(RecyclerView.ViewHolder origin, RecyclerView.ViewHolder target){
        Collections.swap(peliculas, origin.getAdapterPosition(), target.getAdapterPosition());
        notifyItemMoved(origin.getAdapterPosition(), target.getAdapterPosition());
    }

    public void remove(RecyclerView.ViewHolder viewHolder){
        peliculas.remove(viewHolder.getAdapterPosition());
        notifyItemRemoved(viewHolder.getAdapterPosition());
    }

}
