package com.example.profesormanana.a28_location;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements LocationListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LocationManager manager = (LocationManager) getSystemService(LOCATION_SERVICE);
        Criteria criterioDeBusquedaDeProveedoresDeLocalizacion = new Criteria();
        criterioDeBusquedaDeProveedoresDeLocalizacion.setAccuracy(Criteria.ACCURACY_FINE);
        criterioDeBusquedaDeProveedoresDeLocalizacion.setAltitudeRequired(true);
        String provider = manager.getBestProvider(criterioDeBusquedaDeProveedoresDeLocalizacion, false);
        Toast.makeText(this, "Proveedor : " + provider, Toast.LENGTH_SHORT).show();
        if (!manager.isProviderEnabled(provider)) {
            Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            startActivity(intent);
        }

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        manager.requestLocationUpdates(provider, 1 * 20 * 1000, 100, this);
    }

    @Override
    public void onLocationChanged(Location location) {
        Toast.makeText(this,"Altitud:"+location.getAltitude()+" Latitud:"+location.getLatitude()+" Longitud: "+location.getLongitude(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {
        Toast.makeText(this,"GPS Activado",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onProviderDisabled(String provider) {
        Toast.makeText(this,"GPS Desactivado",Toast.LENGTH_SHORT).show();
    }
}
