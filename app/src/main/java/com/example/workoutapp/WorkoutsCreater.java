package com.example.workoutapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class WorkoutsCreater extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workouts_creater);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Workout Creater");
    }
}
