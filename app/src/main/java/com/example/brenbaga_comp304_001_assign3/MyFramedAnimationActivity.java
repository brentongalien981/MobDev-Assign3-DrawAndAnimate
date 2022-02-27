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

        ImageView theImageView = (ImageView) findViewById(R.id.framedAnimationImageView);

        BitmapDrawable frame1 = (BitmapDrawable) getResources().getDrawable(R.drawable.panther1);
        BitmapDrawable frame2 = (BitmapDrawable) getResources().getDrawable(R.drawable.panther2);
        BitmapDrawable frame3 = (BitmapDrawable) getResources().getDrawable(R.drawable.panther3);
        BitmapDrawable frame4 = (BitmapDrawable) getResources().getDrawable(R.drawable.panther4);
        BitmapDrawable frame5 = (BitmapDrawable) getResources().getDrawable(R.drawable.panther5);
        BitmapDrawable frame6 = (BitmapDrawable) getResources().getDrawable(R.drawable.panther6);
        BitmapDrawable frame7 = (BitmapDrawable) getResources().getDrawable(R.drawable.panther7);
        BitmapDrawable frame8 = (BitmapDrawable) getResources().getDrawable(R.drawable.panther8);


        // Get the background, which has been compiled to an AnimationDrawable object.
        mframeAnimation = new AnimationDrawable();
        mframeAnimation.setOneShot(false);    // loop continuously
        mframeAnimation.addFrame(frame1, DURATION_BETWEEN_FRAMES);
        mframeAnimation.addFrame(frame2, DURATION_BETWEEN_FRAMES);
        mframeAnimation.addFrame(frame3, DURATION_BETWEEN_FRAMES);
        mframeAnimation.addFrame(frame4, DURATION_BETWEEN_FRAMES);
        mframeAnimation.addFrame(frame5, DURATION_BETWEEN_FRAMES);
        mframeAnimation.addFrame(frame6, DURATION_BETWEEN_FRAMES);
        mframeAnimation.addFrame(frame7, DURATION_BETWEEN_FRAMES);
        mframeAnimation.addFrame(frame8, DURATION_BETWEEN_FRAMES);

        theImageView.setBackground(mframeAnimation);

        mframeAnimation.setVisible(true, true);
        mframeAnimation.start();
    }


    private void stopAnimation() {
        if (mframeAnimation == null) {
            return;
        }

        mframeAnimation.stop();
        mframeAnimation.setVisible(false, false);
    }
}