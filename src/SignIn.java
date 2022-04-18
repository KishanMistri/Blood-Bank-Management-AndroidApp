package com.example.dell.blood_bank_mgmt;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignIn extends AppCompatActivity {

    LoginDataBaseAdapter loginDataBaseAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        loginDataBaseAdapter=new LoginDataBaseAdapter(this);
        loginDataBaseAdapter=loginDataBaseAdapter.open();


        final EditText editTextUserName=(EditText)findViewById(R.id.editTextUserNameToLogin);
        final  EditText editTextPassword=(EditText)findViewById(R.id.editTextPasswordToLogin);

        Button btnSignIn=(Button)findViewById(R.id.buttonSignIn);

        // Set On ClickListener
        btnSignIn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // get The User name and Password
                String userName = editTextUserName.getText().toString();
                String password = editTextPassword.getText().toString();

                // fetch the Password form database for respective user name
                String storedPassword = loginDataBaseAdapter.getSinlgeEntry(userName);

                // check if the Stored password matches with  Password entered by user
                if (password.equals(storedPassword)) {

                    //Toast.makeText(SignIn.this, "Congrats: Login Successful", Toast.LENGTH_LONG).show();
                    // dialog.dismiss();
                    Intent r = new Intent(getApplicationContext(), Registration.class);
                    startActivity(r);
                } else {
                    Toast.makeText(SignIn.this, "User Name or Password does not match", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

}
