package com.example.dell.blood_bank_mgmt;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Doctor extends AppCompatActivity {

    DatabaseHelper2 mydb;
    Button viewall1;
    Button loc;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);
        mydb = new DatabaseHelper2(this);
        viewall1 = (Button)findViewById(R.id.button_view1);
        loc = (Button)findViewById(R.id.button_gl);
        viewAll();

        loc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent i1 = new Intent(Doctor.this,MapsActivity2.class);
                startActivity(i1);
            }
        });
    }


    public void viewAll() {

        viewall1.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        Cursor res = mydb.getAllData();
                        if(res.getCount() == 0){
                            // showMessage("Error, nothing found");
                            return;
                        }
                        StringBuffer buffer =new StringBuffer();
                        while(res.moveToNext()){
                            buffer.append("ID :"+ res.getString(0)+"\n");
                            buffer.append("Name :"+ res.getString(1)+"\n");
                            buffer.append("BLOODGROUP :"+ res.getString(2)+"\n");
                            buffer.append("AGE :"+ res.getString(3)+"\n");
                            buffer.append("CONTACTNO :"+ res.getString(4)+"\n");
                            buffer.append("LOCATION :"+ res.getString(5)+"\n\n");

                        }
                        showMessage("Information",buffer.toString());
                    }
                }
        );

    }


    public void showMessage(String title,String Message)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }


}
