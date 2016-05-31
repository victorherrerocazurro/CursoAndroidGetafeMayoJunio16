package com.example.profesormanana.a07_recyclerview;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import java.util.Collections;

/**
 * Created by profesormanana on 31/5/16.
 */
public class GenericItemTouchHelperCallback extends ItemTouchHelper.Callback {

    private final RecyclerView.Adapter adapter;

    public GenericItemTouchHelperCallback(RecyclerView.Adapter adapter) {
        this.adapter = adapter;
    }

    //Definicion de moviminetos que disparan cada uno de los dos eventos disponibles (drag&drop y Swipe)
    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        return makeMovementFlags(ItemTouchHelper.UP | ItemTouchHelper.DOWN, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT);
    }

    //Funcionalidad de Drag And Drop
    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        PeliculasAdapter adapter = (PeliculasAdapter) recyclerView.getAdapter();
        adapter.intercambiar(viewHolder, target);
        return true;
    }

    //Funcionalidad de deslizado
    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        if(direction == ItemTouchHelper.LEFT){
            //Necesito la referencia al List y no la tengo.
            //El Adapter tene la la referencia al List
            ((PeliculasAdapter)adapter).remove(viewHolder);
        } else if(direction == ItemTouchHelper.RIGHT){
            adapter.notifyDataSetChanged();
        }
    }
}
