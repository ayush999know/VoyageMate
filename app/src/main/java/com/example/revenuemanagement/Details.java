package com.example.revenuemanagement;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Details extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private TextView click1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details); // Make sure this matches your XML layout file name

        click1 = findViewById(R.id.click1);
        Button btnSubmit = findViewById(R.id.btnSubmit);

        // Initialize MediaPlayer
        mediaPlayer = MediaPlayer.create(this, R.raw.details); // Replace 'audio_file' with your actual file name

        click1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start playing the audio
                if (mediaPlayer != null) {
                    mediaPlayer.start();
                }
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Stop the audio if it's playing
                if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                    mediaPlayer.prepareAsync(); // Prepare for the next play
                }
                // Create an Intent to start the new activity
                Intent intent = new Intent(Details.this, HomePage.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Stop and release media player when the activity is paused
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
            }
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
