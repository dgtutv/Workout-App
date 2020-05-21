package com.example.workoutapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.Toast;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class WorkoutsCreater extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        String[] workoutArray= spinnerArray.workoutArray;
        Spinner spinner = findViewById(R.id.spinnerExercise1);
//        ArrayAdapter<String> adapter = ArrayAdapter.createFromResource(this,
//                workoutArray, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner.setAdapter(adapter);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workouts_creater);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Workout Creater");                                      //change text at top of screen accordingly
        Button btn=findViewById(R.id.BtnNew);
        btn.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View v){
               PopupMenu popup = new PopupMenu(WorkoutsCreater.this, v);                                    //display menu when button clicked
               v.setOnTouchListener(popup.getDragToOpenListener());
               popup.setOnMenuItemClickListener(WorkoutsCreater.this);
               popup.inflate(R.menu.workout_new_popup_menu);
               setForceShowIcon(popup);
               popup.show();                    //show popup
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
    public static void setForceShowIcon(PopupMenu popupMenu) {                                      //function to show icons on popup menu
        try {
            Field[] fields = popupMenu.getClass().getDeclaredFields();
            for (Field field : fields) {
                if ("mPopup".equals(field.getName())) {
                    field.setAccessible(true);
                    Object menuPopupHelper = field.get(popupMenu);
                    Class<?> classPopupHelper = Class.forName(menuPopupHelper
                            .getClass().getName());
                    Method setForceIcons = classPopupHelper.getMethod(
                            "setForceShowIcon", boolean.class);
                    setForceIcons.invoke(menuPopupHelper, true);
                    break;
                }
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
