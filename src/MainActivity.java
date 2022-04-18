package com.example.dell.blood_bank_mgmt;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button bDonor;
    Button bDoctor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bDonor = (Button)findViewById(R.id.button_donor);
        bDoctor = (Button)findViewById(R.id.button_doctor);

        callDonor();
        callDoctor();
    }

    public void callDonor()
    {
        bDonor.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i1 = new Intent(MainActivity.this, Donor.class);
                        startActivity(i1);
                        Toast.makeText(MainActivity.this, "Activity Started", Toast.LENGTH_LONG).show();

                    }
                }
        );
    }

    public void callDoctor()
    {
        bDoctor.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i2 = new Intent(MainActivity.this,Doctor.class);
                        startActivity(i2);
                        Toast.makeText(MainActivity.this, "Activity Started", Toast.LENGTH_LONG).show();

                    }
                }
        );

    }

}
