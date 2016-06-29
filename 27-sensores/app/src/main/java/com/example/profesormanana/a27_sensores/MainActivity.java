package com.example.profesormanana.a27_sensores;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity implements SensorEventListener{

    private SensorManager manager;
    private Sensor acelerometro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> sensorList = manager.getSensorList(Sensor.TYPE_ALL);
        for (Sensor sensor : sensorList) {
            Log.d(this.getClass().toString(), sensor.toString());
        }
        acelerometro = manager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

    }

    @Override
    protected void onResume() {
        super.onResume();
        manager.registerListener(this,acelerometro,SensorManager.SENSOR_DELAY_NORMAL);
    }
    @Override
    protected void onPause(){
        super.onPause();
        manager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float[] values = event.values;
        Log.d(this.getClass().toString(),"Cambio Acelerómetro :  X="+ values[0]+"m/s2  Y="+values[1]+"m/s2  Z="+values[2]+"m/s2");
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
