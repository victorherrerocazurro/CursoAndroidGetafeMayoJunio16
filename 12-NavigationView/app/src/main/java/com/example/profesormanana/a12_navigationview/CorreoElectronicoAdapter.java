package com.example.profesormanana.a12_navigationview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by profesormanana on 8/6/16.
 */
public class CorreoElectronicoAdapter extends RecyclerView.Adapter<CorreoElectronicoViewHolder> {
    private final List<CorreoElectronico> correos;

    public CorreoElectronicoAdapter(List<CorreoElectronico> correos) {
        this.correos = correos;
    }

    @Override
    public CorreoElectronicoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.correo_electronico_list_item, parent, false);
        return new CorreoElectronicoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CorreoElectronicoViewHolder holder, int position) {
        CorreoElectronico item = correos.get(position);

        holder.bindCorreoElectronico(item);
    }

    @Override
    public int getItemCount() {
        return correos.size();
    }
}
