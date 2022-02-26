package com.example.brenbaga_comp304_001_assign3;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    String[] exercises = {"Exercise1", "Exercise2", "Exercise3"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set the listview.
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                exercises);

        // Bind the listview with array adapter
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);


        // Set list-item event-listener.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Class theClass = null;

                switch (i) {
                    case 0:
                        theClass = LineDrawingActivity.class;
                        break;
                    case 1:
                        theClass = MyFramedAnimationActivity.class;
                        break;
                    default:
                        return;
                }

                Intent myIntent = new Intent(MainActivity.this, theClass);
                startActivity(myIntent);
            }
        });
    }





}