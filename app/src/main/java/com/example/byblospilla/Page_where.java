package com.example.byblospilla;

import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Page_where extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_where);


        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }
    //motodo per la visualizzazione della posizione esatta delle aule studio byblos
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng byblos = new LatLng(44.533079, 11.025011);
        mMap.addMarker(new MarkerOptions().position(byblos).title("SIAMO QUI!"));
        CameraPosition cameraPosition = new CameraPosition.Builder().target(byblos).zoom(15).build();

        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
    }

}
