package com.example.revenuemanagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class Payment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        // Find the ImageView and set an OnClickListener
        findViewById(R.id.imageClickable).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the new activity when the image is clicked
                Intent intent = new Intent(Payment.this, Bill.class);
                startActivity(intent);
            }
        });
    }
}
