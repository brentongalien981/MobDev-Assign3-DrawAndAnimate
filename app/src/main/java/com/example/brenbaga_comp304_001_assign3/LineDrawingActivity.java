package com.example.brenbaga_comp304_001_assign3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class LineDrawingActivity extends AppCompatActivity {

    private static Bitmap bitmap;
    private static Canvas canvas;
    private static ImageView theImageView;
    private static Paint paint;

    private static int startX = 10;
    private static int startY = 10;
    private static int endX = 10;
    private static int endY = 10;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line_drawing);
    }



    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);


        theImageView = (ImageView) findViewById(R.id.theImageView);

        // Set the bitmap and relevant objects in this overridden method to
        // get the runtime dimensions of theImageView.
        bitmap = Bitmap.createBitmap(theImageView.getWidth(), theImageView.getHeight(), Bitmap.Config.ARGB_8888);


        // Set the canvas.
        canvas = new Canvas(bitmap);
        // Background color.
        canvas.drawColor(Color.CYAN);


        // Set the imageView.
        theImageView.setImageBitmap(bitmap);
        theImageView.setVisibility(View.VISIBLE);


        // Set the paint.
        paint = new Paint();
        paint.setColor(Color.MAGENTA);
        paint.setStrokeWidth(30);
    }



    public static void drawLine(String direction) {

        switch (direction) {
            case "up":
                break;
            case "right":
                endX += 5;
                break;
            case "down":
                break;
            case "left":
                break;
        }

        // TODO: Delete later.
        Log.w("CeC-Assign3", "startX ==> " + startX);
        Log.w("CeC-Assign3", "startY ==> " + startY);
        Log.w("CeC-Assign3", "endX ==> " + endX);
        Log.w("CeC-Assign3", "endY ==> " + endY);

        canvas.drawLine(startX, startY, endX, endY, paint);
        startX = endX;
        startY = endY;

    }
}