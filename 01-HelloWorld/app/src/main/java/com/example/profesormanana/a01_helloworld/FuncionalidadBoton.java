package com.example.profesormanana.a01_helloworld;

import android.view.View;
import android.widget.TextView;

/**
 * Created by profesormanana on 20/5/16.
 */
public class FuncionalidadBoton implements View.OnClickListener {

    private TextView txtSaludo;

    public FuncionalidadBoton(TextView txtSaludo) {
        this.txtSaludo = txtSaludo;
    }

    @Override
    public void onClick(View v) {
        txtSaludo.setText(R.string.otroSaludo);
    }
}
