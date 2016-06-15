package com.example.profesormanana.a17_googlemaps;

import android.graphics.Color;
import android.graphics.Point;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.Projection;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    private CameraPosition.Builder builder;

    private CameraPosition miPrimerCameraPosition;

    private LatLng esquina1 = new LatLng(-33, 150);
    private LatLng esquina2 = new LatLng(-33, 152);
    private LatLng esquina3 = new LatLng(-35, 152);
    private LatLng esquina4 = new LatLng(-35, 150);
    private LatLng sydney = new LatLng(-34, 151);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        builder = CameraPosition.builder().zoom(5).bearing(45).tilt(45);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera



        MarkerOptions marca = new MarkerOptions()
                .position(sydney)
                .title("Marker in Sydney")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE));

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {

                LatLng position = marker.getPosition();

                Toast.makeText(MapsActivity.this, "Se ha pulsado sobre: " + position.latitude + ", " + position.longitude, Toast.LENGTH_SHORT).show();

                return false;
            }
        });

        PolygonOptions poligono = new PolygonOptions().add(esquina1, esquina2, esquina3, esquina4)
                .fillColor(Color.CYAN)
                .strokeColor(Color.GRAY)
                .strokeWidth(2);

        mMap.addPolygon(poligono);

        mMap.addMarker(marca);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        UiSettings uiSettings = mMap.getUiSettings();

        uiSettings.setZoomControlsEnabled(true);
        uiSettings.setMyLocationButtonEnabled(true);
        uiSettings.setMapToolbarEnabled(true);

        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(R.id.Navegar == item.getItemId()){

            builder.target(esquina1);


            CameraPosition cameraPosition = builder.build();


            mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        }


        return super.onOptionsItemSelected(item);
    }
}
