package com.example.profesormanana.a14_asynctask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageView);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == R.id.menu_item_descargar){
            //Lanzamos la tarea de larga duracion
            DescargaImagenAsyncTask asyncTask = new DescargaImagenAsyncTask(imageView, this);

            asyncTask.execute("http://sergimateo.com/wp-content/2012/08/fotos-panoramicas-5.jpg");
        }
        return super.onOptionsItemSelected(item);
    }
}
