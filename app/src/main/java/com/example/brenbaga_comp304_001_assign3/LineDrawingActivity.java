package com.example.brenbaga_comp304_001_assign3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class LineDrawingActivity extends AppCompatActivity {

    private static final int DEFAULT_PAINT_WIDTH = 5;

    private Bitmap bitmap;
    private Canvas canvas;
    private ImageView theImageView;
    private Paint paint;

    private int startX = 10;
    private int startY = 10;
    private int endX = 10;
    private int endY = 10;

    private static Context context;
    private boolean hasTheCanvasSizeBeenSet = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line_drawing);

        // Reference the context of this class.
        context = this;
    }


    /**
     * Set the drawing-objects in this method to have
     * the rendered dimensions of the image-view.
     */
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        if (hasTheCanvasSizeBeenSet) {
            return;
        }

        theImageView = (ImageView) findViewById(R.id.theImageView);

        // Set the bitmap and relevant objects in this overridden method to
        // get the runtime dimensions of theImageView.
        bitmap = Bitmap.createBitmap(theImageView.getWidth(), theImageView.getHeight(), Bitmap.Config.ARGB_8888);


        // Set the canvas.
        canvas = new Canvas(bitmap);
        // Background color.
        canvas.drawColor(Color.BLACK);


        // Set the imageView.
        theImageView.setImageBitmap(bitmap);
        theImageView.setVisibility(View.VISIBLE);


        // Set the paint.
        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStrokeWidth(DEFAULT_PAINT_WIDTH);

        hasTheCanvasSizeBeenSet = true;
    }


    public void clearCanvas(View v) {
        canvas.drawColor(Color.BLACK);
        startX = 10;
        startY = 10;
        endX = 10;
        endY = 10;
    }


    public void drawLine(String direction) {

        switch (direction) {
            case "up":
                endY -= 5;
                break;
            case "right":
                endX += 5;
                break;
            case "down":
                endY += 5;
                break;
            case "left":
                endX -= 5;
                break;
        }

        canvas.drawLine(startX, startY, endX, endY, paint);
        startX = endX;
        startY = endY;

    }


    public boolean onKeyDown(int keyCode, KeyEvent event) {

        String direction = "";

        switch (keyCode) {
            case KeyEvent.KEYCODE_DPAD_UP:
                direction = "up";
                break;
            case KeyEvent.KEYCODE_DPAD_RIGHT:
                direction = "right";
                break;
            case KeyEvent.KEYCODE_DPAD_DOWN:
                direction = "down";
                break;
            case KeyEvent.KEYCODE_DPAD_LEFT:
                direction = "left";
                break;
        }


        if (direction.isEmpty()) {
            return false;
        }


        // If it's a valid arrow press, then draw.
        theImageView.setFocusable(true);
        theImageView.requestFocus();
        drawLine(direction);
        theImageView.invalidate();
        return true;

    }


    public void setPaintStrokeWidth(int thicknessArrayIndex) {

        if (!hasTheCanvasSizeBeenSet) {
            return;
        }

        String[] widths = getResources().getStringArray(R.array.paintThickness);
        int width = Integer.valueOf(widths[thicknessArrayIndex]);
        paint.setStrokeWidth(width);
    }


    public void setPainColor(int colorInt) {
        paint.setColor(colorInt);
    }


    public static Context getMyContext() {
        return context;
    }


    public static LineDrawingActivity getMyInstance() {
        return (LineDrawingActivity) context;
    }
}