package com.example.workoutapp;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class CreateFragment extends Fragment {
    public Button button;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_create, container, false);
        Button Workoutbutton=(Button)v.findViewById(R.id.Workoutbutton);
        Button Timersbutton=(Button)v.findViewById(R.id.Timerbutton);
        Workoutbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Workouts Clicked");
                Intent intent=new Intent(getActivity(),WorkoutsCreater.class);
                startActivity(intent);
            }
        });
        Timersbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Timers Clicked");
                Intent intent=new Intent(getActivity(),TimersCreater.class);
                startActivity(intent);
            }
        });

        return inflater.inflate(R.layout.fragment_create, container, false);


    }



}
