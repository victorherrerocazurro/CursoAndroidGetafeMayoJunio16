package com.curso.android.ejemplochatfirebase;

import android.app.Activity;
import android.app.ListActivity;
import android.graphics.Color;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kane_project on 28/6/16.
 */
public class MensajeListAdapter extends BaseAdapter {

    private String userName;
    private LayoutInflater inflater;
    private int layout;
    private final List<Mensaje> mensajes = new ArrayList<>();
    private final List<String> keys = new ArrayList<>();
    private ChildEventListener listener;
    private Firebase referencia;

    public MensajeListAdapter(Firebase referencia, Activity activity, int layout){

        this.referencia = referencia;
        this.inflater = activity.getLayoutInflater();
        this.layout = layout;
        // Look for all child events. We will then map them to our own internal ArrayList, which backs ListView
        listener = referencia.addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String previousChildName) {
                Mensaje mensaje = dataSnapshot.getValue(Mensaje.class);
                String key = dataSnapshot.getKey();

                // Insert into the correct location, based on previousChildName
                if (previousChildName == null) {
                    mensajes.add(0, mensaje);
                    keys.add(0, key);
                } else {
                    int previousIndex = keys.indexOf(previousChildName);
                    int nextIndex = previousIndex + 1;
                    if (nextIndex == mensajes.size()) {
                        mensajes.add(mensaje);
                        keys.add(key);
                    } else {
                        mensajes.add(nextIndex, mensaje);
                        keys.add(nextIndex, key);
                    }
                }

                notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                String key = dataSnapshot.getKey();
                Mensaje mensaje = dataSnapshot.getValue(Mensaje.class);
                mensajes.set(keys.indexOf(key),mensaje);
                notifyDataSetChanged();
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                String key = dataSnapshot.getKey();
                Mensaje mensaje = dataSnapshot.getValue(Mensaje.class);
                keys.remove(key);
                mensajes.remove(mensaje);
                notifyDataSetChanged();
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String previousChildName) {
                String key = dataSnapshot.getKey();
                Mensaje mensaje = dataSnapshot.getValue(Mensaje.class);
                int index = keys.indexOf(key);
                mensajes.remove(index);
                keys.remove(index);
                if (previousChildName == null) {
                    mensajes.add(0, mensaje);
                    keys.add(0, key);
                } else {
                    int previousIndex = keys.indexOf(previousChildName);
                    int nextIndex = previousIndex + 1;
                    if (nextIndex == mensajes.size()) {
                        mensajes.add(mensaje);
                        keys.add(key);
                    } else {
                        mensajes.add(nextIndex, mensaje);
                        keys.add(nextIndex, key);
                    }
                }
                notifyDataSetChanged();
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                Log.e("CHAT","Chat cancelado. Error!");
            }
        });
    }

    @Override
    public int getCount() {
        return mensajes.size();
    }

    @Override
    public Object getItem(int position) {
        return mensajes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(layout, parent, false);
        }

        Mensaje mensaje = mensajes.get(position);
        publicarVista(convertView, mensaje);
        return convertView;
    }
    protected void publicarVista(View view, Mensaje mensaje) {
        String usuario = mensaje.getUsuario();
        TextView editTextUsuario = (TextView) view.findViewById(R.id.editTextUsuario);
        editTextUsuario.setText(usuario + ": ");

        if (usuario != null && usuario.equals(userName)) {
            editTextUsuario.setTextColor(Color.RED);
        } else {
            editTextUsuario.setTextColor(Color.BLUE);
        }
        ((TextView) view.findViewById(R.id.editTextMensaje)).setText(mensaje.getMensaje());
    }
    public void cleanup() {
        referencia.removeEventListener(listener);
        mensajes.clear();
        keys.clear();
    }
}
