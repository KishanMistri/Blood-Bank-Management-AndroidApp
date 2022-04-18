package com.example.dell.blood_bank_mgmt;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng vs = new LatLng(23.0736, 72.51743);
        mMap.addMarker(new MarkerOptions().position(vs).title("VS Hospital"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(vs));

        LatLng civil = new LatLng(23.04922,72.60388);
        mMap.addMarker(new MarkerOptions().position(civil).title("Civil Hospital"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(civil));

        LatLng redcross = new LatLng(23.0225,72.57136);
        mMap.addMarker(new MarkerOptions().position(redcross).title("INDIAN RED CROSS SOCIETY, AHMEDABAD"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(redcross));

        LatLng sola = new LatLng(23.0692,72.51121);
        mMap.addMarker(new MarkerOptions().position(sola).title("GENERAL HOSPITAL, SOLA, AHMEDABAD"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sola));

        LatLng prathma = new LatLng(23.02232,72.57139);
        mMap.addMarker(new MarkerOptions().position(prathma).title("Prathma Blood centre, Ahmedabad"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(prathma));

        LatLng sterling = new LatLng(23.04916,72.53175);
        mMap.addMarker(new MarkerOptions().position(sterling).title("Sterling Hospital, Ahmedabad"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sterling));

        LatLng MS = new LatLng(23.02268,72.57133);
        mMap.addMarker(new MarkerOptions().position(MS).title("Military Hospital Blood Bank, Ahmedabad"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(MS));

        LatLng SSG = new LatLng(22.32318,73.15832);
        mMap.addMarker(new MarkerOptions().position(SSG).title("S.S.G HOSPITAL, VADODARA"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(SSG));

        LatLng GMC = new LatLng(22.30759,73.18124);
        mMap.addMarker(new MarkerOptions().position(GMC).title("GMERS MEDICAL COLLAGE & GENERAL HOSPITAL, GOTRI"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(GMC));

        LatLng MCC = new LatLng(22.30746,73.18113);
        mMap.addMarker(new MarkerOptions().position(MCC).title("MEDICAL CARE CENTRE, VADODARA"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(MCC));

        LatLng SBB = new LatLng(22.30716,73.18122);
        mMap.addMarker(new MarkerOptions().position(SBB).title("Suraktam Blood Bank, Vadodara"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(SBB));

        LatLng NC = new LatLng(21.17022,72.83106);
        mMap.addMarker(new MarkerOptions().position(NC).title("NEW CIVIL HOSPITAL, SURAT"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(NC));

        LatLng SRK = new LatLng(21.17024,72.83106);
        mMap.addMarker(new MarkerOptions().position(SRK).title("SURAT RAKTDAN KENDRA, SURAT"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(SRK));

        LatLng SH = new LatLng(21.17024,72.83106);
        mMap.addMarker(new MarkerOptions().position(SH).title("SMIMER HOSPITAL, SURAT"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(SH));

        LatLng SHF = new LatLng(21.17024,72.83106);
        mMap.addMarker(new MarkerOptions().position(SHF).title("SURAT HEALTHCARE FOUNDATION"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(SHF));

    }
}
