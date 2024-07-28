package com.example.revenuemanagement;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class HomePage extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private TextView speakerEmoji;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        // Initialize the MediaPlayer
        mediaPlayer = MediaPlayer.create(this, R.raw.home); // Ensure 'sound.mp3' is in res/raw

        // Find views by ID
        ImageView profileIcon = findViewById(R.id.profile_icon);
        GridLayout gridLayout = findViewById(R.id.grid_layout);
        ImageView bottomIcon1 = findViewById(R.id.bottom_icon1);
        ImageView bottomIcon2 = findViewById(R.id.bottom_icon2);
        ImageView bottomIcon3 = findViewById(R.id.bottom_icon3);
        ImageView stillImage = findViewById(R.id.still_image);
        ImageView imageB = findViewById(R.id.image_b);
        ImageView imageC = findViewById(R.id.image_c);
        ImageView imageD = findViewById(R.id.image_d);
        ImageView imageE = findViewById(R.id.image_e);
        ImageView imageF = findViewById(R.id.image_f);
        speakerEmoji = findViewById(R.id.speaker_emoji);

        // Set click listeners for the top bar icons
        profileIcon.setOnClickListener(v -> startActivity(new Intent(HomePage.this, MainActivity.class)));

        // Set click listeners for the GridLayout items
        for (int i = 0; i < gridLayout.getChildCount(); i++) {
            final int index = i;
            gridLayout.getChildAt(i).setOnClickListener(v -> {
                Intent intent;
                switch (index) {
                    case 0:
                        intent = new Intent(HomePage.this, PropertyTax.class);
                        break;
                    case 1:
                        intent = new Intent(HomePage.this, WaterTax.class);
                        break;
                    case 2:
                        intent = new Intent(HomePage.this, GarbageTax.class);
                        break;
                    default:
                        return;
                }
                startActivity(intent);
            });
        }

        // Set click listeners for the bottom icons
        bottomIcon1.setOnClickListener(v -> startActivity(new Intent(HomePage.this, HomePage.class)));
        bottomIcon2.setOnClickListener(v -> startActivity(new Intent(HomePage.this, Dashboard.class)));
        bottomIcon3.setOnClickListener(v -> startActivity(new Intent(HomePage.this, ChatBot.class)));

        // Set click listeners for the new ImageViews
        stillImage.setOnClickListener(v -> startActivity(new Intent(HomePage.this, PaymentProcess.class)));
        imageB.setOnClickListener(v -> startActivity(new Intent(HomePage.this, PaymentProcess.class)));
        imageC.setOnClickListener(v -> startActivity(new Intent(HomePage.this, PaymentProcess.class)));
        imageD.setOnClickListener(v -> startActivity(new Intent(HomePage.this, Bill.class)));
        imageE.setOnClickListener(v -> startActivity(new Intent(HomePage.this, Bill.class)));
        imageF.setOnClickListener(v -> startActivity(new Intent(HomePage.this, Bill.class)));

        // Set click listener for the speaker emoji
        speakerEmoji.setOnClickListener(v -> {
            if (mediaPlayer != null && !mediaPlayer.isPlaying()) {
                mediaPlayer.start();
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Stop the audio when the activity is paused (e.g., when navigating to another page)
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Release MediaPlayer resources
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
