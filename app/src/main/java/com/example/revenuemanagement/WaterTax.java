package com.example.revenuemanagement;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class WaterTax extends AppCompatActivity {

    private EditText editTextCityName;
    private EditText editTextAddress;
    private EditText editTextZone;
    private EditText editTextOldConsumerId;
    private EditText editTextConsumerName;
    private EditText editTextWard;
    private EditText editTextNumberOfRecords;
    private Button buttonPay;
    private Button buttonFillIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_tax);

        // Initialize UI elements
        editTextCityName = findViewById(R.id.editTextCityName);
        editTextAddress = findViewById(R.id.editTextAddress);
        editTextZone = findViewById(R.id.editTextZone);
        editTextOldConsumerId = findViewById(R.id.editTextOldConsumerId);
        editTextConsumerName = findViewById(R.id.editTextConsumerName);
        editTextWard = findViewById(R.id.editTextWard);
        editTextNumberOfRecords = findViewById(R.id.editTextNumberOfRecords);
        buttonPay = findViewById(R.id.buttonPay);
        buttonFillIn = findViewById(R.id.buttonFillIn);

        // Set up the Fill In button click listener
        buttonFillIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fillInDetails();
            }
        });

        // Set up the Pay Now button click listener
        buttonPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processPayment();
            }
        });
    }

    // Method to fill in the details automatically
    private void fillInDetails() {
        editTextCityName.setText("Sample City");
        editTextAddress.setText("123 Sample Address");
        editTextZone.setText("Zone 1");
        editTextOldConsumerId.setText("123456789");
        editTextConsumerName.setText("John Doe");
        editTextWard.setText("Ward 5");
        editTextNumberOfRecords.setText("10");

        Toast.makeText(this, "Details filled in automatically", Toast.LENGTH_SHORT).show();
    }

    // Method to process the payment
    private void processPayment() {
        String cityName = editTextCityName.getText().toString().trim();
        String address = editTextAddress.getText().toString().trim();
        String zone = editTextZone.getText().toString().trim();
        String oldConsumerId = editTextOldConsumerId.getText().toString().trim();
        String consumerName = editTextConsumerName.getText().toString().trim();
        String ward = editTextWard.getText().toString().trim();
        String numberOfRecords = editTextNumberOfRecords.getText().toString().trim();

        // Check if any field is empty
        if (cityName.isEmpty() || address.isEmpty() || zone.isEmpty() || oldConsumerId.isEmpty() || consumerName.isEmpty() || ward.isEmpty() || numberOfRecords.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        // Handle the payment processing logic here
        // This could involve sending data to a server, validating inputs, etc.
        Toast.makeText(this, "Payment processed successfully for City: " + cityName, Toast.LENGTH_LONG).show();
    }
}
