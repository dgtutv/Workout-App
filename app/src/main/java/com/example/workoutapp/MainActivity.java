package com.example.workoutapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.google.android.material.navigation.NavigationView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        List<String> workoutArray= spinnerArray.workoutArray;
        workoutArray.add("None");
        workoutArray.add("test");


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);         //standard stuff

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);                   //supports menu

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);            //declaration of menu
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,     //When menu bar is toggled give out a message to device(accessibility)
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {           //If a menu was not open previously, start on home fragment
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_home);



        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {           //These are the cases for the menu, which gets pressed and what it does
        switch (item.getItemId()) {
            case R.id.nav_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new HomeFragment()).commit();
                break;
            case R.id.nav_workouts:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new WorkoutsFragment()).commit();
                break;
            case R.id.nav_create:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new CreateFragment()).commit();
                break;
            case R.id.nav_timers:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new TimersFragment()).commit();
                break;
            case R.id.nav_settings:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new SettingsFragment()).commit();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {               //When back button pressed leave menu
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public void setActionBarTitle(String title){
        ActionBar actionBar=getSupportActionBar();          //Sets the action Bar title
        actionBar.setTitle(title);
    }

    }

