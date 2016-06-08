package com.example.profesormanana.a13_sharedpreferences;

import android.os.Bundle;
import android.preference.PreferenceFragment;

/**
 * Created by profesormanana on 8/6/16.
 */
public class MisPreferenciasFragment extends PreferenceFragment {



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.mis_preferencias);
    }
}
