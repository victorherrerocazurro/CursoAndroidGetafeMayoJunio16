package com.example.profesormanana.a12_navigationview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by profesormanana on 8/6/16.
 */
public class EnviadosFragment extends MiListadoFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        RecyclerView recyclerView = (RecyclerView) super.onCreateView(inflater, container, savedInstanceState);

        List<CorreoElectronico> enviados = Servicio.getEnviados();

        recyclerView.setAdapter(new CorreoElectronicoAdapter(enviados));

        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity(), LinearLayoutManager.VERTICAL, false));

        return recyclerView;
    }
}
