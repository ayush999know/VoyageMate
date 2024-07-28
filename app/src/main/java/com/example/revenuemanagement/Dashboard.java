package com.example.revenuemanagement;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Dashboard extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard); // Ensure this layout file exists

        // Initialize MediaPlayer with audio file
        mediaPlayer = MediaPlayer.create(this, R.raw.dash); // Ensure 'audio' is your audio file name in res/raw

        // Find the TextView with the speaker emoji
        TextView speakerEmoji = findViewById(R.id.speaker_emoji);

        // Set an OnClickListener for the TextView
        speakerEmoji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer != null) {
                    mediaPlayer.start(); // Start playing the audio
                }
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mediaPlayer != null) {
            mediaPlayer.pause(); // Pause the audio if activity is paused
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release(); // Release the MediaPlayer resources
            mediaPlayer = null;
        }
    }
}
