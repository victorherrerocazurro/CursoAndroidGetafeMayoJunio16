package com.curso.android.ejemplochatfirebase;

import android.app.ListActivity;
import android.database.DataSetObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.net.URL;
import java.util.Random;

public class MainActivity extends ListActivity {

    private static final String URL_CHAT;
    private static String userName;
    private static Firebase firebaseRef;
    private static Button enviar;
    private static EditText editTextMensaje;
    private MensajeListAdapter mensajeListAdapter;
    private ValueEventListener connectionListener;

    static {
        URL_CHAT = "https://mi-chat.firebaseio-demo.com";
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Firebase.setAndroidContext(this);
        getUserName();
        setTitle("Conectado como " + userName);
        firebaseRef = new Firebase(URL_CHAT).child("chat");
        editTextMensaje = (EditText)findViewById(R.id.editText);
        enviar = (Button)findViewById(R.id.buttonEnviar);
        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enviarMensaje();
            }
        });
    }
    private void getUserName(){
        userName = "Usuario_"+new Random().nextInt(100);
    }
    private void enviarMensaje(){
        String mensajeTexto = editTextMensaje.getText().toString();
        if(!mensajeTexto.trim().equals("")){
            Mensaje mensaje = new Mensaje(mensajeTexto,userName);
            firebaseRef.push().setValue(mensaje);
            editTextMensaje.setText("");
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        // Setup our view and list adapter. Ensure it scrolls to the bottom as data changes
        final ListView listView = getListView();
        // Tell our list adapter that we only want 50 messages at a time

        mensajeListAdapter = new MensajeListAdapter(firebaseRef,this, R.layout.mensaje);

        listView.setAdapter(mensajeListAdapter);
        mensajeListAdapter.registerDataSetObserver(new DataSetObserver() {
            @Override
            public void onChanged() {
                super.onChanged();
                listView.setSelection(mensajeListAdapter.getCount() - 1);
            }
        });

        // Finally, a little indication of connection status
        connectionListener = firebaseRef.getRoot().child(".info/connected").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                boolean connected = (Boolean) dataSnapshot.getValue();
                if (connected) {
                    Toast.makeText(MainActivity.this, "Conectado a Firebase", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Desconectado de Firebase", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                // No-op
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        firebaseRef.getRoot().child(".info/connected").removeEventListener(connectionListener);
        mensajeListAdapter.cleanup();
    }
}
