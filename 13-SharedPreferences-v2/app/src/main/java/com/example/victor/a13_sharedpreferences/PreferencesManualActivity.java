package com.example.victor.a13_sharedpreferences;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class PreferencesManualActivity extends AppCompatActivity {

    private EditText eTPrefijo;
    private EditText eTSufijo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences_manual);

        eTPrefijo = (EditText) findViewById(R.id.eTPrefijo);

        eTSufijo = (EditText) findViewById(R.id.eTSufijo);

        //Leer de SharedPreferences los valores iniciales

        final SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);

        eTPrefijo.setText(preferences.getString("prefijo", "Hola "));
        eTSufijo.setText(preferences.getString("sufijo", "!!!!!!!"));

        Button btGuardar = (Button) findViewById(R.id.btGuardar);

        btGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                   //Establecer en SharedPReferences los nuevos valores
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("prefijo", eTPrefijo.getText().toString());
                editor.putString("sufijo", eTSufijo.getText().toString());
                editor.commit();
            }
        });

    }
}
