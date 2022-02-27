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


        // Start animations.
        final Button startBtn = (Button) findViewById(R.id.startBtn);
        startBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                performAnimation(R.drawable.jupiter, R.id.theJupiterImageView, R.anim.jupiter);
                performAnimation(R.drawable.asteroid3, R.id.theAsteroidImageView, R.anim.asteroid);
                performAnimation(R.drawable.earth, R.id.theEarthImageView, R.anim.earth);
                performAnimation(R.drawable.explosion, R.id.explosionImageView, R.anim.explosion);
            }
        });
    }


    private void performAnimation(int imageResourceId, int viewId, int animationResourceID) {

        // We will animate the imageview.
        ImageView reusableImageView = (ImageView) findViewById(viewId);
        reusableImageView.setImageResource(imageResourceId);
        reusableImageView.setVisibility(View.VISIBLE);

        // Load the appropriate animation.
        Animation an = AnimationUtils.loadAnimation(this, animationResourceID);

        // Register a listener, so we can disable and re-enable buttons
        an.setAnimationListener(new MyAnimationListener());

        // Start the animation
        reusableImageView.startAnimation(an);

    }


    private void toggleButton(boolean clickableState) {

        final Button startBtn = (Button) findViewById(R.id.startBtn);
        startBtn.setClickable(clickableState);

    }


    class MyAnimationListener implements Animation.AnimationListener {

        public void onAnimationEnd(Animation animation) {

            // Hide explosion-image-view after animation.
            ImageView explosionImageView = (ImageView) findViewById(R.id.explosionImageView);
            explosionImageView.setVisibility(View.INVISIBLE);

            // Enable button once animation is over.
            toggleButton(true);

        }


        public void onAnimationRepeat(Animation animation) {

        }


        public void onAnimationStart(Animation animation) {
            // Disable button while animation is running
            toggleButton(false);
        }

    }
}