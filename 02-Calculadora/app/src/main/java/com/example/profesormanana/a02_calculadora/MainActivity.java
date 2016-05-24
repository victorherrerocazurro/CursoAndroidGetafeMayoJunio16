package com.example.profesormanana.a02_calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvResultado;

    private String operador1 = "0";
    //No necesitamos esta variable de control de estado, ya que nos sirve con tvResultado
    //private String operador2 = null;
    private char operacionPrevia = '+';

    private boolean ultimaAccionEsOperacion = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Obtenemos la referencia a los componentes que hay que emplear
        tvResultado = (TextView) findViewById(R.id.tvResultado);

        View.OnClickListener listenerBotonNumerico = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nuevoResultado = "";

                if(ultimaAccionEsOperacion){
                    //Vaciar el tvResultado, y meter unicamente el numero pulsado
                    nuevoResultado = ((Button)v).getText().toString();
                } else {
                    //Concatenar lo que ya existe con el valor nuevo leido
                    nuevoResultado = tvResultado.getText().toString() + ((Button)v).getText();
                }

                tvResultado.setText(nuevoResultado);

                //Establecemos el nuevo estado de la calculadora, para contemplar que la ultima
                // accion no fue una operacion, sino un numero
                ultimaAccionEsOperacion = false;

            }
        };

        View.OnClickListener listenerOperaciones = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Transformar los datos que nos proporciona el usuario, en el formato que nos
                //acepta el negocio
                float op1 = Float.parseFloat(operador1);
                float op2 = Float.parseFloat(tvResultado.getText().toString());

                float resultado = 0;

                //Resolvemos operacion previa
                switch (operacionPrevia){
                    case '+':
                        resultado = CalculadoraEstatica.sumar(op1, op2);
                        break;
                    case '-':
                        resultado = CalculadoraEstatica.restar(op1,op2);
                        break;
                    case '*':
                        resultado = CalculadoraEstatica.multiplicar(op1,op2);
                        break;
                    case '/':
                        resultado = CalculadoraEstatica.dividir(op1,op2);
                        break;
                    case '=':
                        resultado = op2;
                        break;
                }

                //Procesamos el resultado
                operador1 = String.valueOf(resultado);
                tvResultado.setText(operador1);

                //Actualizar operacionPrevia
                operacionPrevia = ((Button)v).getText().charAt(0);

                ultimaAccionEsOperacion = true;

            }
        };


        View boton0 = findViewById(R.id.bt0);
        View boton1 = findViewById(R.id.bt1);
        View boton2 = findViewById(R.id.bt2);
        View boton3 = findViewById(R.id.bt3);
        View boton4 = findViewById(R.id.bt4);
        View boton5 = findViewById(R.id.bt5);
        View boton6 = findViewById(R.id.bt6);
        View boton7 = findViewById(R.id.bt7);
        View boton8 = findViewById(R.id.bt8);
        View boton9 = findViewById(R.id.bt9);

        View botonSumar = findViewById(R.id.btSuma);
        View botonRestar = findViewById(R.id.btRestar);
        View botonMultiplicar = findViewById(R.id.btMultiplicar);
        View botonDividir = findViewById(R.id.btDividir);

        View botonPunto = findViewById(R.id.btDecimal);
        View botonIgual = findViewById(R.id.btIgual);

        //Asignar los listener
        boton0.setOnClickListener(listenerBotonNumerico);
        boton1.setOnClickListener(listenerBotonNumerico);
        boton2.setOnClickListener(listenerBotonNumerico);
        boton3.setOnClickListener(listenerBotonNumerico);
        boton4.setOnClickListener(listenerBotonNumerico);
        boton5.setOnClickListener(listenerBotonNumerico);
        boton6.setOnClickListener(listenerBotonNumerico);
        boton7.setOnClickListener(listenerBotonNumerico);
        boton8.setOnClickListener(listenerBotonNumerico);
        boton9.setOnClickListener(listenerBotonNumerico);

        botonSumar.setOnClickListener(listenerOperaciones);
        botonRestar.setOnClickListener(listenerOperaciones);
        botonMultiplicar.setOnClickListener(listenerOperaciones);
        botonDividir.setOnClickListener(listenerOperaciones);
        botonIgual.setOnClickListener(listenerOperaciones);


    }
}
