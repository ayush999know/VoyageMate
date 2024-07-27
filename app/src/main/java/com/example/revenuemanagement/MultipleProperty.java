package com.example.revenuemanagement;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MultipleProperty extends AppCompatActivity {

    private LinearLayout propertyContainer;
    private TextView amountTextView;
    private Button showAmountButton;
    private int propertyCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_property);

        propertyContainer = findViewById(R.id.propertyContainer);
        amountTextView = findViewById(R.id.amountTextView);
        Button addPropertyButton = findViewById(R.id.addPropertyButton);
        Button autoFillButton = findViewById(R.id.autoFillButton);
        Button payNowButton = findViewById(R.id.payNowButton);
        showAmountButton = findViewById(R.id.showAmountButton);

        addPropertyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addProperty();
            }
        });

        autoFillButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                autoFillProperties();
            }
        });

        payNowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handlePayment();
            }
        });

        showAmountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAmount();
            }
        });
    }

    private void addProperty() {
        propertyCount++;

        // Create a new property input layout
        LinearLayout propertyLayout = new LinearLayout(this);
        propertyLayout.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        propertyLayout.setOrientation(LinearLayout.VERTICAL);
        propertyLayout.setPadding(8, 8, 8, 8);

        // Create Property ID and Owner Name EditTexts
        EditText propertyId = new EditText(this);
        propertyId.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        propertyId.setHint("Property ID");

        EditText ownerName = new EditText(this);
        ownerName.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        ownerName.setHint("Owner Name");

        // Create Delete Button
        Button deleteButton = new Button(this);
        deleteButton.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        deleteButton.setText("Delete");
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeProperty(propertyLayout);
            }
        });

        // Add EditTexts and Delete Button to the property layout
        propertyLayout.addView(propertyId);
        propertyLayout.addView(ownerName);
        propertyLayout.addView(deleteButton);

        // Add the new property layout to the container
        propertyContainer.addView(propertyLayout);

        // Make the amount TextView visible if it's not already
        if (propertyCount > 0) {
            amountTextView.setVisibility(View.GONE);
        }

        // Enable the "Show Amount" button
        showAmountButton.setEnabled(true);
    }

    private void removeProperty(LinearLayout propertyLayout) {
        propertyContainer.removeView(propertyLayout);
        propertyCount--;

        // Hide the amount TextView if no properties remain
        if (propertyCount == 0) {
            amountTextView.setVisibility(View.GONE);
            showAmountButton.setEnabled(false);
        }
    }

    private void autoFillProperties() {
        // Fill in details for up to 4 properties
        int count = propertyContainer.getChildCount();
        for (int i = 0; i < count; i++) {
            View view = propertyContainer.getChildAt(i);
            if (view instanceof LinearLayout) {
                LinearLayout propertyLayout = (LinearLayout) view;
                EditText propertyId = (EditText) propertyLayout.getChildAt(0);
                EditText ownerName = (EditText) propertyLayout.getChildAt(1);

                // Fill in details if they are within the first 4 properties
                if (i < 4) {
                    propertyId.setText("Property ID: " + (i + 1));
                    ownerName.setText("Owner Name: Owner " + (i + 1));
                }
            }
        }

        // Make the amount TextView visible if there are properties
        if (propertyCount > 0) {
            amountTextView.setVisibility(View.GONE);
        }

        // Enable the "Show Amount" button
        showAmountButton.setEnabled(true);
    }

    private void showAmount() {
        // Check if all properties are filled before calculating the amount
        if (areAllPropertiesFilled()) {
            float totalAmount = 0;
            // Calculate total amount
            for (int i = 0; i < propertyContainer.getChildCount(); i++) {
                View view = propertyContainer.getChildAt(i);
                if (view instanceof LinearLayout) {
                    LinearLayout propertyLayout = (LinearLayout) view;
                    // Generate a random amount for each property
                    totalAmount += generateRandomAmount();
                }
            }
            amountTextView.setText("Total Amount: ₹" + String.format("%.2f", totalAmount));
            amountTextView.setVisibility(View.VISIBLE);
        }
    }

    private boolean areAllPropertiesFilled() {
        for (int i = 0; i < propertyContainer.getChildCount(); i++) {
            View view = propertyContainer.getChildAt(i);
            if (view instanceof LinearLayout) {
                LinearLayout propertyLayout = (LinearLayout) view;
                EditText propertyId = (EditText) propertyLayout.getChildAt(0);
                EditText ownerName = (EditText) propertyLayout.getChildAt(1);

                // Check if Property ID or Owner Name is empty
                if (propertyId.getText().toString().isEmpty() || ownerName.getText().toString().isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }

    private float generateRandomAmount() {
        Random random = new Random();
        float amount;
        do {
            amount = 50000 + (100000 - 50000) * random.nextFloat(); // Random amount between ₹50,000 and ₹1,00,000
        } while (amount <= 50000);
        return amount;
    }

    private void handlePayment() {
        // Show or log property details and handle payment logic
        for (int i = 0; i < propertyContainer.getChildCount(); i++) {
            View view = propertyContainer.getChildAt(i);
            if (view instanceof LinearLayout) {
                LinearLayout propertyLayout = (LinearLayout) view;
                EditText propertyId = (EditText) propertyLayout.getChildAt(0);
                EditText ownerName = (EditText) propertyLayout.getChildAt(1);

                // Show or log property details
                String id = propertyId.getText().toString();
                String owner = ownerName.getText().toString();

                // For demonstration, we use System.out.println() to log
                System.out.println("Property ID: " + id + ", Owner Name: " + owner);
            }
        }

        // Handle the payment logic here
        // For example, start a new Activity or show a payment dialog
    }
}
