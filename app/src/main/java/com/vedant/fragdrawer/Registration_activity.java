package com.vedant.fragdrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

import es.dmoral.toasty.Toasty;

public class Registration_activity extends AppCompatActivity {
        private EditText Name,Password;
        private Button Register;
        DatabaseHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_activity);
        mydb = new DatabaseHelper(this);
        Name = findViewById(R.id.name);
        Password = findViewById(R.id.password);
        Register = findViewById(R.id.register);
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User();
                String Name1 = Name.getText().toString();
                String Pass1 = Password.getText().toString();
                if((Name1.isEmpty()) || (Pass1.isEmpty()))
                {
                    Name.setError("Please Enter Valid Name");
                    Password.setError("Please Enter Valid password");
                }
                else {
                    user.setName(Name1);
                    user.setPassword(Pass1);

//                user.setName(Name.getText().toString());
//                user.setPassword(Password.getText().toString());
                    if (mydb.addUser(user)) {
                        //Toast.makeText( Registration_activity.this,"Registration Successfull!!",Toast.LENGTH_LONG  ).show();
                        Toasty.success(Registration_activity.this, "Registration Successfull!!", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(Registration_activity.this, login.class);
                        startActivity(intent);
                    } else {
                        Toasty.error(Registration_activity.this, "Registration Failed!!", Toast.LENGTH_LONG).show();
                        //Toast.makeText( Registration_activity.this,"Registration FAILED!!",Toast.LENGTH_LONG  ).show();
                    }
                }
            }
        });

    }

    }