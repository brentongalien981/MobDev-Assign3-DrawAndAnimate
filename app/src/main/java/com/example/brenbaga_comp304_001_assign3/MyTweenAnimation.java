package com.example.brenbaga_comp304_001_assign3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MyTweenAnimation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_tween_animation);


        // Handle zzz.
        final Button startBtn = (Button) findViewById(R.id.startBtn);
        startBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                performAnimation(R.anim.asteroid_rotate);
            }
        });


        // Handle zzz
        final Button stopBtn = (Button) findViewById(R.id.stopBtn);
        stopBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                performAnimation(R.anim.asteroid);
            }
        });
    }


    private void performAnimation(int animationResourceID) {

        // We will animate the imageview
        ImageView reusableImageView = (ImageView) findViewById(R.id.theAsteroidImageView);
        reusableImageView.setImageResource(R.drawable.asteroid3);
        reusableImageView.setVisibility(View.VISIBLE);

        // Load the appropriate animation
        Animation an = AnimationUtils.loadAnimation(this, animationResourceID);

        // Register a listener, so we can disable and re-enable buttons
        an.setAnimationListener(new MyAnimationListener());

        // Start the animation
        reusableImageView.startAnimation(an);

    }


    private void toggleButtons(boolean clickableState) {

        final Button startBtn = (Button) findViewById(R.id.startBtn);
        startBtn.setClickable(clickableState);

        final Button stopBtn = (Button) findViewById(R.id.stopBtn);
        stopBtn.setClickable(clickableState);

    }


    class MyAnimationListener implements Animation.AnimationListener {

        public void onAnimationEnd(Animation animation) {

            // Hide our ImageView
            ImageView reusableImageView = (ImageView) findViewById(R.id.theAsteroidImageView);
//            reusableImageView.setVisibility(View.INVISIBLE);

            // Enable all buttons once animation is over
            toggleButtons(true);

        }


        public void onAnimationRepeat(Animation animation) {
            Log.w("CeC-Assign3", "In METHOD: onAnimationRepeat()");
        }


        public void onAnimationStart(Animation animation) {
            // Disable all buttons while animation is running
            toggleButtons(false);
        }

    }
}