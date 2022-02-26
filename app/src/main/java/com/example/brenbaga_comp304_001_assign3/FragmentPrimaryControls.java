package com.example.brenbaga_comp304_001_assign3;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;


public class FragmentPrimaryControls extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_primary_controls, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        // Set the colorBtns.
        ImageButton redBtn = getActivity().findViewById(R.id.redImageBtn);
        ImageButton greenBtn = getActivity().findViewById(R.id.greenImageBtn);
        ImageButton blueBtn = getActivity().findViewById(R.id.blueImageBtn);

        redBtn.setImageResource(R.drawable.red_rect);
        greenBtn.setImageResource(R.drawable.green_rect);
        blueBtn.setImageResource(R.drawable.blue_rect);


        this.setPaintThicknessSpinner();

    }


    private void setPaintThicknessSpinner() {

        Spinner spinner = getActivity().findViewById(R.id.paintThicknessSpinner);

        // Set event-handler.
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                LineDrawingActivity.getMyInstance().setPaintStrokeWidth(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}