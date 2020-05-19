package com.example.workoutapp;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class CreateFragment extends Fragment implements View.OnClickListener {
    public Button workoutButton;
    public Button timersButton;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_create, container, false);
        workoutButton=view.findViewById(R.id.Workoutbutton);
        workoutButton.setOnClickListener(this);

        timersButton=view.findViewById(R.id.Timerbutton);
        timersButton.setOnClickListener(this);
        return view;

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.Workoutbutton:
                Intent intent=new Intent(getActivity(),WorkoutsCreater.class);
                startActivity(intent);
                break;
            case R.id.Timerbutton:
                Intent intent1=new Intent(getActivity(),TimersCreater.class);
                startActivity(intent1);
                break;
        }
    }
}
