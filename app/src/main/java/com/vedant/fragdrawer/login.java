package com.vedant.fragdrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.PriorityQueue;
import java.util.Random;

import es.dmoral.toasty.Toasty;

public class login extends AppCompatActivity {
    DatabaseHelper mydb;
    private EditText namelogin, Passwordlogin;
    private Button Login, Register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mydb = new DatabaseHelper(this);
        namelogin = findViewById(R.id.name);
        Passwordlogin = findViewById(R.id.passwordlogin);
        Login = findViewById(R.id.login);
        Register = findViewById(R.id.reg);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name2 = namelogin.getText().toString();
                String Password2 = Passwordlogin.getText().toString();
                if(Name2.isEmpty() || Password2.isEmpty())
                {
                    namelogin.setError("Enter Valid Name");
                    Passwordlogin.setError("Enter Valid Password");
                }
                else {
                    User user = mydb.CheckUser(Name2, Password2);
                    if (user == null) {
                        //Toast.makeText(login.this , "Error" , Toast.LENGTH_SHORT).show();
                        Toasty.error(login.this, "Login Failed", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent intent2 = new Intent(login.this, MainActivity.class);
                        intent2.putExtra("User", user);
                        startActivity(intent2);
                        Toasty.success(login.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this, Registration_activity.class);
                startActivity(intent);
            }
        });
    }
}