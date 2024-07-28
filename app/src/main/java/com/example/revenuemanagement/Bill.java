package com.example.revenuemanagement;


import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Bill extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);

        // Find and set data to TextViews
        TextView taxBillTitle = findViewById(R.id.taxBillTitle);
        TextView taxpayerName = findViewById(R.id.taxpayerName);
        TextView taxpayerAddress = findViewById(R.id.taxpayerAddress);
        TextView billNumber = findViewById(R.id.billNumber);
        TextView paymentStatus = findViewById(R.id.paymentStatus);
        TextView paymentDate = findViewById(R.id.paymentDate);
        TextView breakdownTitle = findViewById(R.id.breakdownTitle);
        TextView propertyTax = findViewById(R.id.propertyTax);
        TextView garbageTax = findViewById(R.id.garbageTax);
        TextView waterTax = findViewById(R.id.waterTax);
        TextView totalAmount = findViewById(R.id.totalAmount);
        TextView footerNote = findViewById(R.id.footerNote);

        // Set text for each TextView
        taxBillTitle.setText("Official Tax Bill");
        taxpayerName.setText("Taxpayer: Rahul Dubey");
        taxpayerAddress.setText("Address: 123 Main Street, Indore, MP, 452001");
        billNumber.setText("Bill Number: 2024-001234");
        paymentStatus.setText("Status: Paid");
        paymentDate.setText("Payment Date: 2024-07-28");
        breakdownTitle.setText("Breakdown of Charges");
        propertyTax.setText("Property Tax: ₹10,000.00");
        garbageTax.setText("Garbage Tax: ₹1,500.00");
        waterTax.setText("Water Tax: ₹800.00");
        totalAmount.setText("Total Amount Paid: ₹12,300.00");
        footerNote.setText("Thank you for your timely payment. This bill is automatically generated and does not require a signature.");
    }
}
