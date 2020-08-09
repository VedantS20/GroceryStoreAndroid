package com.vedant.fragdrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,fruitfrag.FragmentFruitListener,vegefrag.vegfragListener,dairyfrag.dairyfragListener{
    private DrawerLayout drawerLayout;
    public BottomNavigationView bottomNavigationView;
    private fruitfrag Fruitfrag;
    private cartfrag Cartfrag;
    ImageButton Cart;
    Bundle bundle = new Bundle();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        LinearLayout linearLayout = findViewById(R.id.llayout);
        Cart = findViewById(R.id.cart);

        View v1= inflater.inflate(R.layout.nev_list,null);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Home");
        drawerLayout = findViewById(R.id.drawer_layout);
        TextView name = v1.findViewById(R.id.profilename);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar, R.string.Navigation_drawer_open ,R.string.Navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        Fruitfrag = new fruitfrag();
        Cartfrag = new cartfrag();
        getSupportFragmentManager().beginTransaction().add(R.id.fragment,new settingsfrag()).commit();
        bottomNavigationView = findViewById(R.id.bottom_nev);
        bottomNavigationView.setOnNavigationItemSelectedListener(navlistener);
        bottomNavigationView.setBackgroundColor(Color.parseColor("#DAE0E2"));
        Cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment , Cartfrag).commit();
                bottomNavigationView.setVisibility(View.INVISIBLE);
            }
        });
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navlistener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectefrag = null;
            switch (item.getItemId())
            {
                case R.id.vegi:
                    selectefrag = new vegefrag();
                    bottomNavigationView.setVisibility(View.INVISIBLE);
                    //getSupportFragmentManager().beginTransaction().replace(R.id.fragment,new vegefrag()).commit();
                    break;
                case R.id.fruits:
                    selectefrag = Fruitfrag;
                    bottomNavigationView.setVisibility(View.INVISIBLE);
                    // getSupportFragmentManager().beginTransaction().replace(R.id.fragment,new fruitfrag()).commit();
                    break;
                case R.id.dairy:
                    selectefrag = new dairyfrag();
                    bottomNavigationView.setVisibility(View.INVISIBLE);
                    //getSupportFragmentManager().beginTransaction().replace(R.id.fragment,new dairyfrag()).commit();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment , selectefrag).addToBackStack("bot").commit();
            return true;
        }
    };
    @Override
    public void onBackPressed() {
        int count=getSupportFragmentManager().getBackStackEntryCount();
        if(drawerLayout.isDrawerOpen(GravityCompat.START) || count!=0){
            drawerLayout.closeDrawer(GravityCompat.START);
            getSupportFragmentManager().popBackStack();
            bottomNavigationView.setVisibility(View.VISIBLE);
        }else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.vegi:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment,new vegefrag()).addToBackStack("veg").commit();
                bottomNavigationView.setVisibility(View.INVISIBLE);
                break;
            case R.id.fruits:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment,Fruitfrag).addToBackStack("fr").commit();
                bottomNavigationView.setVisibility(View.INVISIBLE);
                break;
            case R.id.dairy:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment,new dairyfrag()).addToBackStack("dai").commit();
                bottomNavigationView.setVisibility(View.INVISIBLE);
                break;
            case R.id.cart:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment,Cartfrag).addToBackStack("car").commit();
                bottomNavigationView.setVisibility(View.INVISIBLE);
                break;
            case R.id.settings:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment,new settingsfrag()).addToBackStack("set").commit();
                break;
            case R.id.help:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment,new helpfrag()).addToBackStack("hel").commit();
                break;
            case R.id.profile:
                Intent intent2 = getIntent();
                User user = (User) intent2.getSerializableExtra("User");
                Intent intent = new Intent(MainActivity.this , profile.class);
                intent.putExtra("User1" , user);
                intent.putExtra("Name" , user.getName());
                intent.putExtra("Pass" , user.getPassword());
                startActivity(intent);
                //getSupportFragmentManager().beginTransaction().replace(R.id.fragment,new prof()).commit();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void OnInputSent(String guva,String melon,String pine,String orange) {
        bundle.putString("guvacount" , guva);
        bundle.putString("meloncount" , melon);
        bundle.putString("orangecount" , orange);
        bundle.putString("pinecount" , pine);
        Cartfrag.setArguments(bundle);
    }

    @Override
    public void OnInputSentveg(String tomato, String potato, String lady, String cabbage) {
        bundle.putString("tomcount" , tomato);
        bundle.putString("potcount" , potato);
        bundle.putString("ladycount" , lady);
        bundle.putString("cabcount" , cabbage);
        Cartfrag.setArguments(bundle);
    }

    @Override
    public void OnInputdairy(String cheese, String butter, String ice, String milk) {
        bundle.putString("chcount" , cheese);
        bundle.putString("butcount" , butter);
        bundle.putString("icecount" , ice);
        bundle.putString("milkcount" , milk);
        Cartfrag.setArguments(bundle);
    }
}