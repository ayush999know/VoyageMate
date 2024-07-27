package com.example.revenuemanagement;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.AdapterView;

public class TaxCalculator extends AppCompatActivity {

    private Spinner propertyTypeSpinner;
    private EditText locationInput, sizeInput, rentalValueInput;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tax_calculator);

        propertyTypeSpinner = findViewById(R.id.propertyTypeSpinner);
        locationInput = findViewById(R.id.locationInput);
        sizeInput = findViewById(R.id.sizeInput);
        rentalValueInput = findViewById(R.id.rentalValueInput);
        resultText = findViewById(R.id.resultText);

        // Populate the Spinner with property types
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.property_types, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        propertyTypeSpinner.setAdapter(adapter);

        // Set listeners for dynamic updates
        propertyTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                calculatePropertyTax();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });

        locationInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Do nothing
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                calculatePropertyTax();
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Do nothing
            }
        });

        sizeInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Do nothing
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                calculatePropertyTax();
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Do nothing
            }
        });

        rentalValueInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Do nothing
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                calculatePropertyTax();
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Do nothing
            }
        });
    }

    private void calculatePropertyTax() {
        String location = locationInput.getText().toString();
        String sizeStr = sizeInput.getText().toString();
        String rentalValueStr = rentalValueInput.getText().toString();
        String propertyType = propertyTypeSpinner.getSelectedItem().toString();

        if (location.isEmpty() || sizeStr.isEmpty() || rentalValueStr.isEmpty()) {
            resultText.setText("Please enter all required fields.");
            return;
        }

        double size = Double.parseDouble(sizeStr);
        double rentalValue = Double.parseDouble(rentalValueStr);

        double tax = calculateTaxAmount(propertyType, location, size, rentalValue);
        resultText.setText(String.format("Your property tax is: ₹%.2f", tax));
    }

    private double calculateTaxAmount(String propertyType, String location, double size, double rentalValue) {
        // Dummy logic for property tax calculation based on input factors
        double baseRate = 0.01;  // 1% base rate for tax calculation
        double propertyTypeMultiplier = getPropertyTypeMultiplier(propertyType);
        double locationMultiplier = getLocationMultiplier(location);

        return rentalValue * baseRate * propertyTypeMultiplier * locationMultiplier;
    }

    private double getPropertyTypeMultiplier(String propertyType) {
        switch (propertyType) {
            case "Residential":
                return 1.0;
            case "Commercial":
                return 1.5;
            case "Industrial":
                return 2.0;
            default:
                return 1.0;
        }
    }

    private double getLocationMultiplier(String location) {
        // Simplified location multiplier logic
        if (location.equalsIgnoreCase("Urban")) {
            return 1.5;
        } else if (location.equalsIgnoreCase("Semi-Urban")) {
            return 1.2;
        } else {
            return 1.0;
        }
    }
}
