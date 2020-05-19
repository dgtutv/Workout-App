package com.example.workoutapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class TimersCreater extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timers_creater);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Timer Creater");
    }
}
