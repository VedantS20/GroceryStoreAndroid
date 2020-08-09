package com.vedant.fragdrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import es.dmoral.toasty.Toasty;

public class profile extends AppCompatActivity {
    EditText Name1,Email1,Pass1;
    Button Save;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db= new DatabaseHelper(this);
        setContentView(R.layout.activity_profile);
        Name1 = findViewById(R.id.nameprof);
        Save = findViewById(R.id.save);
        Pass1 = findViewById(R.id.passwordprof);
        Intent intent = getIntent();
        User us = (User) intent.getSerializableExtra("User1");
         Name1.setText(us.getName());
         final User user = us;
         Save.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 user.setName(Name1.getText().toString());
                 user.setPassword(Pass1.getText().toString());
                 db.updateUser(user);
                 Toasty.success(profile.this , "Data Updated Succesfully" , Toast.LENGTH_SHORT).show();
                 Intent intent1 = new Intent(profile.this , login.class);
                 startActivity(intent1);
             }
         });
    }


}