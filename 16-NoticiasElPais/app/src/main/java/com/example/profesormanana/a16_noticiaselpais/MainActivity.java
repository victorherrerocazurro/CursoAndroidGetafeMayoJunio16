package com.example.profesormanana.a16_noticiaselpais;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.listView);

        ArrayAdapter<Noticia> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, new LinkedList<Noticia>());
        listView.setAdapter(adapter);


        //Esto podria ser lanzado desde cualquier boton
        DescargaRssNoticias descargaRssNoticias = new DescargaRssNoticias(adapter);

        descargaRssNoticias.execute("http://ep00.epimg.net/rss/elpais/portada.xml");
    }
}
