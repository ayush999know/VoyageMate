package com.example.revenuemanagement;


import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ChatBot extends AppCompatActivity {

    private TextView answerTextView;
    private ListView questionsListView;

    private String[] questions = {
            "What is property tax?",
            "How do I pay garbage tax?",
            "What is water tax?",
            "How can I check my property tax amount?",
            "When is the garbage tax due?",
            "Can I get a discount on water tax?"
    };

    private String[] answers = {
            "Property tax is a tax assessed on real estate property based on its value. It is usually collected by local governments...",
            "Garbage tax is often paid as part of your municipal taxes. Check with your local municipality for payment options...",
            "Water tax is a fee levied for the consumption of water. It can be part of your utility bill or a separate tax...",
            "You can check your property tax amount by contacting your local tax assessor's office or checking their website...",
            "Garbage tax due dates vary by municipality. Check with your local government for specific due dates...",
            "Discounts on water tax may be available for certain categories of users, such as low-income households. Check with your local water authority..."
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_bot);

        answerTextView = findViewById(R.id.answerTextView);
        questionsListView = findViewById(R.id.questionsListView);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, questions);
        questionsListView.setAdapter(adapter);

        questionsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                answerTextView.setText(answers[position]);
            }
        });
    }
}
