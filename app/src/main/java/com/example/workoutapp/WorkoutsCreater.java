package com.example.workoutapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class WorkoutsCreater extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workouts_creater);
        ActionBar actionBar = getSupportActionBar();
        //actionBar.setTitle("Workout Creater");                                      //change text at top of screen accordingly
        Button btn=findViewById(R.id.BtnNew);
        btn.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View v){
               PopupMenu popup = new PopupMenu(WorkoutsCreater.this, v);                                    //display menu when button clicked
               v.setOnTouchListener(popup.getDragToOpenListener());
               popup.setOnMenuItemClickListener(WorkoutsCreater.this);
               popup.inflate(R.menu.workout_new_popup_menu);
               popup.show();//show popup
           }
        });
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        Toast.makeText(this, "Selected Item: " +item.getTitle(), Toast.LENGTH_SHORT).show();
        switch (item.getItemId()) {                                                                                             //testing which button is pressed in menu
            case R.id.RepBased:
                System.out.println("Rep Based");
                return true;
            case R.id.RunBased:
                System.out.println("Run Based");
                return true;
            case R.id.TimeBased:
                System.out.println("Time Based");
                return true;
            default:
                return false;
        }
    }
}
