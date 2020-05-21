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
import java.util.List;

public class WorkoutsCreater extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener, AdapterView.OnItemSelectedListener {


    public void ArrayToSpinner(List<String> array, Spinner spinner){
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_dropdown_item_1line,array);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
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

        List<String> workoutArray= spinnerArray.workoutArray;
        Spinner spinner1 = findViewById(R.id.spinnerExercise1);
        Spinner spinner2 = findViewById(R.id.spinnerExercise2);
        Spinner spinner3 = findViewById(R.id.spinnerExercise3);
        Spinner spinner4 = findViewById(R.id.spinnerExercise4);
        Spinner spinner5 = findViewById(R.id.spinnerExercise5);
        Spinner spinner6 = findViewById(R.id.spinnerExercise6);
        Spinner spinner7 = findViewById(R.id.spinnerExercise7);
        Spinner spinner8 = findViewById(R.id.spinnerExercise8);
        Spinner spinner9 = findViewById(R.id.spinnerExercise9);
        Spinner spinner10 = findViewById(R.id.spinnerExercise10);
        Spinner spinner11 = findViewById(R.id.spinnerExercise11);
        Spinner spinner12= findViewById(R.id.spinnerExercise12);
        Spinner spinner13 = findViewById(R.id.spinnerExercise13);
        Spinner spinner14 = findViewById(R.id.spinnerExercise14);
        Spinner spinner15 = findViewById(R.id.spinnerExercise15);

        ArrayToSpinner(workoutArray, spinner1);
        ArrayToSpinner(workoutArray, spinner2);
        ArrayToSpinner(workoutArray, spinner3);
        ArrayToSpinner(workoutArray, spinner4);
        ArrayToSpinner(workoutArray, spinner5);
        ArrayToSpinner(workoutArray, spinner6);
        ArrayToSpinner(workoutArray, spinner7);
        ArrayToSpinner(workoutArray, spinner8);
        ArrayToSpinner(workoutArray, spinner9);
        ArrayToSpinner(workoutArray, spinner10);
        ArrayToSpinner(workoutArray, spinner11);
        ArrayToSpinner(workoutArray, spinner12);
        ArrayToSpinner(workoutArray, spinner13);
        ArrayToSpinner(workoutArray, spinner14);
        ArrayToSpinner(workoutArray, spinner15);

        spinner1.setOnItemSelectedListener(this);
        spinner2.setOnItemSelectedListener(this);
        spinner3.setOnItemSelectedListener(this);
        spinner4.setOnItemSelectedListener(this);
        spinner5.setOnItemSelectedListener(this);
        spinner6.setOnItemSelectedListener(this);
        spinner7.setOnItemSelectedListener(this);
        spinner8.setOnItemSelectedListener(this);
        spinner9.setOnItemSelectedListener(this);
        spinner10.setOnItemSelectedListener(this);
        spinner11.setOnItemSelectedListener(this);
        spinner12.setOnItemSelectedListener(this);
        spinner13.setOnItemSelectedListener(this);
        spinner14.setOnItemSelectedListener(this);
        spinner15.setOnItemSelectedListener(this);




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

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Spinner spinner=(Spinner) parent;
        if(spinner.getId()==R.id.spinnerExercise1){
            System.out.println(parent.getItemAtPosition(position));
        }
        else if(spinner.getId()==R.id.spinnerExercise2){

        }
        else if(spinner.getId()==R.id.spinnerExercise3){

        }
        else if(spinner.getId()==R.id.spinnerExercise4){

        }
        else if(spinner.getId()==R.id.spinnerExercise5){

        }
        else if(spinner.getId()==R.id.spinnerExercise6){

        }
        else if(spinner.getId()==R.id.spinnerExercise7){

        }
        else if(spinner.getId()==R.id.spinnerExercise8){

        }
        else if(spinner.getId()==R.id.spinnerExercise9){

        }
        else if(spinner.getId()==R.id.spinnerExercise10){

        }
        else if(spinner.getId()==R.id.spinnerExercise11){

        }
        else if(spinner.getId()==R.id.spinnerExercise12){

        }
        else if(spinner.getId()==R.id.spinnerExercise13){

        }
        else if(spinner.getId()==R.id.spinnerExercise14){

        }
        else if(spinner.getId()==R.id.spinnerExercise15){

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
