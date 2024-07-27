package com.example.revenuemanagement;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final int DELAY_MILLIS = 2000; // 5 seconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the TextView
        TextView textView = findViewById(R.id.my_text_view);

        // Load the fade-in animation
        Animation fadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_in);

        // Start the animation
        textView.setVisibility(TextView.VISIBLE); // Make the TextView visible before animation
        textView.startAnimation(fadeInAnimation);

        // Handler to transition to the next activity after 5 seconds
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Create an Intent to start the new activity
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);

                // Optionally finish the current activity
                finish();
            }
        }, DELAY_MILLIS); // 5 seconds delay
    }
}
