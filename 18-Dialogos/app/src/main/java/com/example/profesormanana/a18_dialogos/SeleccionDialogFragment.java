package com.example.profesormanana.a18_dialogos;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

/**
 * Created by profesormanana on 16/6/16.
 */
public class SeleccionDialogFragment extends AlertDialogFragment {

    private String[] datos;

    private DialogInterface.OnMultiChoiceClickListener listener;

    public void setMultiChoiceListener(DialogInterface.OnMultiChoiceClickListener listener) {
        this.listener = listener;
    }

    public void setDatos(String[] datos) {
        this.datos = datos;
    }

    @Override
    protected void configBuilder(AlertDialog.Builder builder) {
        //super.configBuilder(builder);
        //Configurar el builder que ahora mismo es virgen, para que sea de seleccion

        builder
                .setMultiChoiceItems(
                        datos,
                        new boolean[]{false, false, false},
                        listener)
                .setNeutralButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

    }
}
