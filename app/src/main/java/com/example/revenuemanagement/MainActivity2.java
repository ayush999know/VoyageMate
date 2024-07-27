package com.example.revenuemanagement;

import android.content.Intent;
import android.os.Bundle;
import android.telecom.Call;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    private EditText editTextPAN;
    private TextView proceedButton; // Changed to TextView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        editTextPAN = findViewById(R.id.editTextPAN);
        proceedButton = findViewById(R.id.proceed); // Initialize TextView

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
    }
}
