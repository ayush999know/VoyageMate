package com.example.revenuemanagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class GarbageTax extends AppCompatActivity {

    private EditText editTextULBName;
    private EditText editTextENagarPalikaConnectionId;
    private EditText editTextENagarPalikaPropertyTaxId;
    private EditText editTextGCPNumber;
    private EditText editTextOldPropertyTaxId;
    private Button buttonPay;
    private Button buttonFillIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garbage_tax);

        // Initialize UI elements
        editTextULBName = findViewById(R.id.editTextULBName);
        editTextENagarPalikaConnectionId = findViewById(R.id.editTextENagarPalikaConnectionId);
        editTextENagarPalikaPropertyTaxId = findViewById(R.id.editTextENagarPalikaPropertyTaxId);
        editTextGCPNumber = findViewById(R.id.editTextGCPNumber);
        editTextOldPropertyTaxId = findViewById(R.id.editTextOldPropertyTaxId);
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
        editTextULBName.setText("Sample ULB");
        editTextENagarPalikaConnectionId.setText("E-123456");
        editTextENagarPalikaPropertyTaxId.setText("P-123456");
        editTextGCPNumber.setText("GCP-123456");
        editTextOldPropertyTaxId.setText("OP-123456");

        Toast.makeText(this, "Details filled in automatically", Toast.LENGTH_SHORT).show();
    }

    // Method to process the payment
    private void processPayment() {
        String ulbName = editTextULBName.getText().toString().trim();
        String enagarPalikaConnectionId = editTextENagarPalikaConnectionId.getText().toString().trim();
        String enagarPalikaPropertyTaxId = editTextENagarPalikaPropertyTaxId.getText().toString().trim();
        String gcpNumber = editTextGCPNumber.getText().toString().trim();
        String oldPropertyTaxId = editTextOldPropertyTaxId.getText().toString().trim();

        // Check if any field is empty
        if (ulbName.isEmpty() || enagarPalikaConnectionId.isEmpty() || enagarPalikaPropertyTaxId.isEmpty() ||
                gcpNumber.isEmpty() || oldPropertyTaxId.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        // Create an intent to start the new activity
        Intent intent = new Intent(GarbageTax.this, PaymentProcess.class);
        startActivity(intent);

        // Optionally, display a message
        Toast.makeText(this, "Navigating to payment screen for ULB: " + ulbName, Toast.LENGTH_LONG).show();
    }
}
