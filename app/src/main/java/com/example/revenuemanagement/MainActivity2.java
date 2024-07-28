package com.example.revenuemanagement;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    private EditText editTextPAN;
    private TextView proceedButton; // Changed to TextView
    private TextView click1Button; // Changed to TextView
    private MediaPlayer mediaPlayerDefault;
    private MediaPlayer mediaPlayerClick1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Initialize MediaPlayer with the default audio file
        mediaPlayerDefault = MediaPlayer.create(this, R.raw.intro); // Replace 'intro' with your default audio file name

        // Start playing the default audio
        if (mediaPlayerDefault != null) {
            mediaPlayerDefault.start();
        }

        // Initialize MediaPlayer with the additional audio file
        mediaPlayerClick1 = MediaPlayer.create(this, R.raw.pancard); // Replace 'click1_audio' with your additional audio file name

        editTextPAN = findViewById(R.id.editTextPAN);
        proceedButton = findViewById(R.id.proceed); // Initialize TextView
        click1Button = findViewById(R.id.click1); // Initialize TextView for click1

        proceedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String panNumber = editTextPAN.getText().toString().trim();

                // Validate the PAN number and navigate to the corresponding activity
                if (panNumber.equals("7667927667")) {
                    startActivity(new Intent(MainActivity2.this, MainActivity3.class));
                } else if (panNumber.equals("123")) {
                    startActivity(new Intent(MainActivity2.this, MainActivity3.class));
                } else if (panNumber.equals("1")) {
                    startActivity(new Intent(MainActivity2.this, MainActivity.class));
                } else {
                    // Handle invalid PAN number (e.g., show an error message)
                    editTextPAN.setError("Invalid pan card number");
                }
            }
        });

        // Set up click listener for click1Button
        click1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayerDefault != null) {
                    mediaPlayerDefault.stop(); // Stop the currently playing audio
                    mediaPlayerDefault.release(); // Release the resources
                    mediaPlayerDefault = null;
                }

                if (mediaPlayerClick1 != null) {
                    mediaPlayerClick1.start(); // Play the new audio
                }
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();

        // Stop and release all MediaPlayer instances when the activity is paused
        if (mediaPlayerDefault != null) {
            mediaPlayerDefault.stop();
            mediaPlayerDefault.release();
            mediaPlayerDefault = null;
        }

        if (mediaPlayerClick1 != null) {
            mediaPlayerClick1.stop();
            mediaPlayerClick1.release();
            mediaPlayerClick1 = null;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        // Stop and release the MediaPlayer when the activity is destroyed
        if (mediaPlayerDefault != null) {
            mediaPlayerDefault.stop();
            mediaPlayerDefault.release();
            mediaPlayerDefault = null;
        }

        if (mediaPlayerClick1 != null) {
            mediaPlayerClick1.stop();
            mediaPlayerClick1.release();
            mediaPlayerClick1 = null;
        }
    }
}
