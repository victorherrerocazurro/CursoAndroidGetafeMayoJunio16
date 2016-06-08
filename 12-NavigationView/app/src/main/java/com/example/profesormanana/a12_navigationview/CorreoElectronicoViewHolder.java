package com.example.profesormanana.a12_navigationview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by profesormanana on 8/6/16.
 */
public class CorreoElectronicoViewHolder extends RecyclerView.ViewHolder {

    private ImageView ivIcono;
    private TextView tvAsunto;
    private TextView tvRemitente;


    public CorreoElectronicoViewHolder(View itemView) {
        super(itemView);
    }


    public void bindCorreoElectronico(CorreoElectronico item) {
        ivIcono.setImageResource(android.R.drawable.ic_menu_save);
        tvAsunto.setText(item.getAsunto());
        tvRemitente.setText(item.getRemitente());
    }
}
