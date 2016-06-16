package com.example.profesormanana.a18_dialogos;

import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Toast;

/**
 * Created by profesormanana on 16/6/16.
 */
public class PersonalizadoDialogFragment extends AlertDialogFragment {

    @Override
    protected void configBuilder(AlertDialog.Builder builder) {

        final MiInterface miInterface = (MiInterface) getActivity();

        View view = getActivity().getLayoutInflater().inflate(R.layout.dialogo_personalizado,null);

        view.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Pulsado sobre el boton", Toast.LENGTH_SHORT).show();

                miInterface.establecerResultadoPersonalizado("Este es el dato");
            }
        });

        builder.setView(view);

        //builder.setView(R.layout.dialogo_personalizado);
    }
}


