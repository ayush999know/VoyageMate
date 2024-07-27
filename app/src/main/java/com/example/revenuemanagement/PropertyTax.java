package com.example.revenuemanagement;

import android.content.DialogInterface; // Add this import
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class PropertyTax extends AppCompatActivity {

    private EditText editTextPropertyId;
    private EditText editTextOwnerName;
    private EditText editTextAmount;
    private Button buttonSuggestAll;
    private Button Multiple; // Add this for the new button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_tax);

        editTextPropertyId = findViewById(R.id.editTextPropertyId);
        editTextOwnerName = findViewById(R.id.editTextOwnerName);
        editTextAmount = findViewById(R.id.editTextAmount);
        buttonSuggestAll = findViewById(R.id.buttonSuggestAll);
        Multiple = findViewById(R.id.Multiple); // Initialize the new button

        buttonSuggestAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSuggestionDialog();
            }
        });

        // Set an OnClickListener for the new button
        Multiple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start the MultiplePropertyActivity
                Intent intent = new Intent(PropertyTax.this, MultipleProperty.class);
                startActivity(intent);
            }
        });
    }

    private void showSuggestionDialog() {
        // Example suggested details
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
}
