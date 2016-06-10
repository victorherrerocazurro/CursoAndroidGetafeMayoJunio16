package com.example.victor.a13_sharedpreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View view = findViewById(R.id.btSaludar);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);

                String nombre = preferences.getString(getResources().getString(R.string.key_nombre), "<nombre>");
                String prefijo = preferences.getString(getResources().getString(R.string.key_prefijo), "<prefijo>");
                String sufijo = preferences.getString(getResources().getString(R.string.key_sufijo), "<sufijo>");

                Toast.makeText(MainActivity.this,prefijo + nombre + sufijo ,Toast.LENGTH_LONG).show();

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_preferencias) {
            Intent intent = new Intent(MainActivity.this, PreferencesActivity.class);
            startActivity(intent);
        } else if(id == R.id.action_preferencias_manual){
            Intent intent = new Intent(MainActivity.this, PreferencesManualActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
