package com.example.revenuemanagement;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class PaymentProcess extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_process);

        // Initialize the Demo Payment button
        Button demoPaymentButton = findViewById(R.id.demoPaymentButton);

        // Set an OnClickListener to handle button clicks
        demoPaymentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start PaymentDetailsActivity
                Intent intent = new Intent(PaymentProcess.this, Payment.class);
                startActivity(intent);
            }
        });
    }
}
