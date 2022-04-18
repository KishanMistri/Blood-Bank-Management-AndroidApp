package com.example.dell.blood_bank_mgmt;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registration extends AppCompatActivity {

    EditText editName,editBloodgroup,editAge,editContactno,editlocation;
    Button savedata,viewall;
    Button loc;
    DatabaseHelper2 mydb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        mydb = new DatabaseHelper2(this);

        editName = (EditText)findViewById(R.id.name_1);
        editBloodgroup = (EditText)findViewById(R.id.bloodgroup_1);
        editAge = (EditText)findViewById(R.id.age_1);
        editContactno = (EditText)findViewById(R.id.contactno_1);
        editlocation = (EditText)findViewById(R.id.location_1);
        savedata = (Button)findViewById(R.id.button_save);
        viewall = (Button)findViewById(R.id.button_v);

        loc = (Button)findViewById(R.id.button_l);

        AddData();
        viewdata();
        loc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(getApplicationContext(),Location.class);
                startActivity(i1);
            }
        });

    }




    public void showMessage(String title,String Message)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }


    public void viewdata()
    {
        viewall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
        });
    }

    public void AddData() {
        savedata.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = mydb.insertData(editName.getText().toString(), editBloodgroup.getText().toString(), editAge.getText().toString(),
                                editContactno.getText().toString(),editlocation.getText().toString());
                        if (isInserted == true)
                            Toast.makeText(Registration.this, "Data Inserted", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(Registration.this, "Data not  Inserted", Toast.LENGTH_LONG).show();

                    }
                }
        );

    }

}
