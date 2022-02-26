package com.example.brenbaga_comp304_001_assign3;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MyFramedAnimationActivity extends AppCompatActivity {

    private AnimationDrawable mframeAnimation = null;
    private static int DURATION_BETWEEN_FRAMES = 250;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_framed_animation);


        // Handle Start Button
        Button startBtn = (Button) findViewById(R.id.startBtn);

        startBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startAnimation();
            }
        });


        // Handle Stop Button
        Button stopBtn = (Button) findViewById(R.id.stopBtn);

        stopBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                stopAnimation();
            }
        });
    }



    private void startAnimation() {

        ImageView theImageView = (ImageView) findViewById(R.id.theImageView);

        BitmapDrawable frame1 = (BitmapDrawable) getResources().getDrawable(R.drawable.boy1);
        BitmapDrawable frame2 = (BitmapDrawable) getResources().getDrawable(R.drawable.boy2);
        BitmapDrawable frame3 = (BitmapDrawable) getResources().getDrawable(R.drawable.boy3);
        BitmapDrawable frame4 = (BitmapDrawable) getResources().getDrawable(R.drawable.boy4);
        BitmapDrawable frame5 = (BitmapDrawable) getResources().getDrawable(R.drawable.boy5);
        BitmapDrawable frame6 = (BitmapDrawable) getResources().getDrawable(R.drawable.boy6);

        
        // Get the background, which has been compiled to an AnimationDrawable object.
        mframeAnimation = new AnimationDrawable();
        mframeAnimation.setOneShot(false);    // loop continuously
        mframeAnimation.addFrame(frame1, DURATION_BETWEEN_FRAMES);
        mframeAnimation.addFrame(frame2, DURATION_BETWEEN_FRAMES);
        mframeAnimation.addFrame(frame3, DURATION_BETWEEN_FRAMES);
        mframeAnimation.addFrame(frame4, DURATION_BETWEEN_FRAMES);
        mframeAnimation.addFrame(frame5, DURATION_BETWEEN_FRAMES);
        mframeAnimation.addFrame(frame6, DURATION_BETWEEN_FRAMES);
        mframeAnimation.addFrame(frame6, DURATION_BETWEEN_FRAMES);
        mframeAnimation.addFrame(frame6, DURATION_BETWEEN_FRAMES);

        theImageView.setBackground(mframeAnimation);

        mframeAnimation.setVisible(true, true);
        mframeAnimation.start();

        Log.w("CeC-Ex3", "insided startAnimation()");
    }

    private void stopAnimation() {
        mframeAnimation.stop();
        mframeAnimation.setVisible(false, false);

        Log.w("CeC-Ex3", "insided stopAnimation()");
    }
}