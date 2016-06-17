package com.example.profesormanana.a19_estilosytemas;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final View view = findViewById(R.id.texto1);

        if(Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT){
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    view.animate()
                        .setDuration(2000)//msg
                        .translationX(20)//dp
                        .translationY(20)
                        .rotation(45)//grados
                        .scaleX(2)//factor de escala, donde 1 es el tamaño real
                        .start();

                    Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.mi_animacion);

                    view.setAnimation(animation);

                    view.animate().start();

                }
            });
        }
    }
}
