package com.example.profesormanana.a13_sharedpreferences;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.preference.PreferenceActivity;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by profesormanana on 8/6/16.
 */
public class MisPreferenciasActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        setContentView(R.layout.mis_preferencias_activity);

        //Esta deprecated, aunque funcionaria
        //addPreferencesFromResource(R.xml.mis_preferencias);
    }
}
