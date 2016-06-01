package com.example.profesormanana.a08_pizzas_recyclerview;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

/**
 * Created by profesormanana on 1/6/16.
 */
public class PizzasCallback extends ItemTouchHelper.Callback {

    private OnSwipeListener listener;

    public PizzasCallback(OnSwipeListener listener) {
        this.listener = listener;
    }

    public void setListener(OnSwipeListener listener) {
        this.listener = listener;
    }

    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        return makeMovementFlags(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT);
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        return false;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

        if (direction == ItemTouchHelper.RIGHT){
            listener.onSwipeRight(viewHolder);
        } else if (direction == ItemTouchHelper.LEFT){
            listener.onSwipeLeft(viewHolder);
        }
    }
}
