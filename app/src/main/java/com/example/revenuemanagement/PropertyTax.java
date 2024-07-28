package com.example.revenuemanagement;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class PropertyTax extends AppCompatActivity {

    private EditText editTextPropertyId;
    private EditText editTextOwnerName;
    private EditText editTextAmount;
    private Button buttonSuggestAll;
    private Button buttonPay; // Add this for the Pay Now button
    private Button Multiple; // Add this for the new button
    private MediaPlayer mediaPlayer;
    private TextView speakerEmoji; // Add this for the speaker emoji

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_tax);

        // Initialize views
        editTextPropertyId = findViewById(R.id.editTextPropertyId);
        editTextOwnerName = findViewById(R.id.editTextOwnerName);
        editTextAmount = findViewById(R.id.editTextAmount);
        buttonSuggestAll = findViewById(R.id.buttonSuggestAll);
        buttonPay = findViewById(R.id.buttonPay); // Initialize the Pay Now button
        Multiple = findViewById(R.id.Multiple);
        speakerEmoji = findViewById(R.id.speaker_emoji); // Initialize the speaker emoji

        // Initialize MediaPlayer
        mediaPlayer = MediaPlayer.create(this, R.raw.property); // Ensure 'sound.mp3' is in res/raw

        buttonSuggestAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSuggestionDialog();
            }
        });

        buttonPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the PaymentConfirmationActivity when Pay Now button is clicked
                Intent intent = new Intent(PropertyTax.this, PaymentProcess.class);
                startActivity(intent);
            }
        });

        Multiple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PropertyTax.this, MultipleProperty.class);
                startActivity(intent);
            }
        });

        // Set click listener for the speaker emoji
        speakerEmoji.setOnClickListener(v -> {
            if (mediaPlayer != null && !mediaPlayer.isPlaying()) {
                mediaPlayer.start();
            }
        });
    }

    private void showSuggestionDialog() {
        final String suggestedId = "PROP123456";
        final String suggestedName = "John Doe";
        final String suggestedAmount = "2500.00";

        new AlertDialog.Builder(this)
                .setTitle("Suggested Details")
                .setMessage("We suggest the following details:\n\n" +
                        "Property ID: " + suggestedId + "\n" +
                        "Owner Name: " + suggestedName + "\n" +
                        "Amount: $" + suggestedAmount)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        editTextPropertyId.setText(suggestedId);
                        editTextOwnerName.setText(suggestedName);
                        editTextAmount.setText(suggestedAmount);
                    }
                })
                .setNegativeButton("Cancel", null)
                .show();
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
