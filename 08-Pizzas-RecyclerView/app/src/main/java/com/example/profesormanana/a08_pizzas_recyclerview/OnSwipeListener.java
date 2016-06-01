package com.example.profesormanana.a08_pizzas_recyclerview;

import android.support.v7.widget.RecyclerView;

/**
 * Created by profesormanana on 1/6/16.
 */
public interface OnSwipeListener {
    void onSwipeRight(RecyclerView.ViewHolder viewHolder);

    void onSwipeLeft(RecyclerView.ViewHolder viewHolder);
}
