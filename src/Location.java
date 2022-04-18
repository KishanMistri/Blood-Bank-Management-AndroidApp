package com.example.dell.blood_bank_mgmt;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Location extends AppCompatActivity implements LocationListener {

    LocationManager locationmanager;
    Button b;
    double lat1, log1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        locationmanager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Criteria cri = new Criteria();
        String provider = locationmanager.getBestProvider(cri, false);


        if (provider != null & !provider.equals(""))

        {

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
            android.location.Location location = locationmanager.getLastKnownLocation(provider);

            locationmanager.requestLocationUpdates(provider, 2000, 1, this);

            if (location != null) {
                onLocationChanged(location);
            } else {

                Toast.makeText(getApplicationContext(), "location not found", Toast.LENGTH_LONG).show();
            }
        } else {

            Toast.makeText(getApplicationContext(), "Provider is null", Toast.LENGTH_LONG).show();
        }


        b = (Button) findViewById(R.id.button_g);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MapsActivity.class);

                String s1 = "23.0645";
                String s2 = "72.0458";
                i.putExtra("name1",s1);
                i.putExtra("name2",s2);

                startActivity(i);

            }
        });

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.


    }

    @Override
    public void onLocationChanged(android.location.Location location) {

        TextView textView2 = (TextView) findViewById(R.id.textviewlat);
        TextView textView3 = (TextView) findViewById(R.id.textviewlog);

        textView2.setText("Latitude " + location.getLatitude());
        textView3.setText("Longitude " + location.getLongitude());

        lat1 = location.getLatitude();
        log1 = location.getLongitude();

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
