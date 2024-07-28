package com.example.revenuemanagement;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {

    private EditText otpBox1, otpBox2, otpBox3, otpBox4;
    private Button submitButton;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        otpBox1 = findViewById(R.id.otpBox1);
        otpBox2 = findViewById(R.id.otpBox2);
        otpBox3 = findViewById(R.id.otpBox3);
        otpBox4 = findViewById(R.id.otpBox4);
        submitButton = findViewById(R.id.submitButton);
        TextView click1 = findViewById(R.id.click1);

        // Initialize MediaPlayer with the audio file
        mediaPlayer = MediaPlayer.create(this, R.raw.otp);

        setUpOtpBoxNavigation();

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String otp = otpBox1.getText().toString() +
                        otpBox2.getText().toString() +
                        otpBox3.getText().toString() +
                        otpBox4.getText().toString();

                if (otp.equals("1111")) { // Check if OTP is 1111
                    Intent intent = new Intent(MainActivity3.this, Details.class); // Replace with the correct activity
                    startActivity(intent);
                } else {
                    // Show error message or handle invalid OTP
                    otpBox1.setError("Invalid OTP. Please enter 1111.");
                    otpBox1.requestFocus();
                }
            }
        });

        click1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Play the audio when TextView is clicked
                if (mediaPlayer != null) {
                    mediaPlayer.start();
                }
            }
        });
    }

    private void setUpOtpBoxNavigation() {
        otpBox1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() == 1) otpBox2.requestFocus();
            }
        });

        otpBox2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() == 1) otpBox3.requestFocus();
                else if (s.length() == 0) otpBox1.requestFocus();
            }
        });

        otpBox3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() == 1) otpBox4.requestFocus();
                else if (s.length() == 0) otpBox2.requestFocus();
            }
        });

        otpBox4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() == 0) otpBox3.requestFocus();
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Stop and release MediaPlayer when the activity is paused
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Stop and release MediaPlayer when the activity is destroyed
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
