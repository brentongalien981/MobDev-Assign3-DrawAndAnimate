package com.example.brenbaga_comp304_001_assign3;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


public class FragmentSecondaryControls extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_secondary_controls, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        this.setDirectionBtnsEventHandlers();

    }


    private void setDirectionBtnsEventHandlers() {

        ImageButton rightBtn = (ImageButton) getActivity().findViewById(R.id.rightImageButton);

        rightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LineDrawingActivity.getMyInstance().drawLine("right");
            }
        });

    }
}