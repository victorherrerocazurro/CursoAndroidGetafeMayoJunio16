package com.example.profesormanana.a01_helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txtSaludo;

    public MainActivity(){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtSaludo = (TextView) findViewById(R.id.txtSaludo);

        View button = findViewById(R.id.button);


        button.setOnClickListener(new FuncionalidadBoton(txtSaludo));

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtSaludo.setText(R.string.otroSaludo);
            }
        };


        button.setOnClickListener(onClickListener);




    }
}
