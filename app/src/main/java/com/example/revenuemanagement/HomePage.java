package com.example.revenuemanagement;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.VideoView;
import androidx.appcompat.app.AppCompatActivity;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        // Find views by ID
        ImageView profileIcon = findViewById(R.id.profile_icon);
        ImageView notificationIcon = findViewById(R.id.notification_icon);
        VideoView videoView = findViewById(R.id.video_view);
        GridLayout gridLayout = findViewById(R.id.grid_layout);

        // Bottom icons
        ImageView bottomIcon1 = findViewById(R.id.bottom_icon1);
        ImageView bottomIcon2 = findViewById(R.id.bottom_icon2);
        ImageView bottomIcon3 = findViewById(R.id.bottom_icon3);

        // New ImageViews
        ImageView stillImage = findViewById(R.id.still_image);
        ImageView imageB = findViewById(R.id.image_b);
        ImageView imageC = findViewById(R.id.image_c);
        ImageView imageD = findViewById(R.id.image_d);
        ImageView imageE = findViewById(R.id.image_e);
        ImageView imageF = findViewById(R.id.image_f);

        // Set video URI and start playback
        Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.s);
        videoView.setVideoURI(videoUri);
        videoView.start(); // Start playing the video immediately

        // Set OnCompletionListener to loop the video
        videoView.setOnCompletionListener(mediaPlayer -> videoView.start());

        // Set click listeners for the top bar icons
        profileIcon.setOnClickListener(v -> startActivity(new Intent(HomePage.this, MainActivity.class)));

        notificationIcon.setOnClickListener(v -> startActivity(new Intent(HomePage.this, MainActivity.class)));

        // Set click listeners for the GridLayout items
        for (int i = 0; i < gridLayout.getChildCount(); i++) {
            final int index = i;
            gridLayout.getChildAt(i).setOnClickListener(v -> {
                Intent intent;
                switch (index) {
                    case 0:
                        intent = new Intent(HomePage.this, PropertyTax.class);
                        break;
                    case 1:
                        intent = new Intent(HomePage.this, WaterTax.class);
                        break;
                    case 2:
                        intent = new Intent(HomePage.this, GarbageTax.class);
                        break;
                    default:
                        return;
                }
                startActivity(intent);
            });
        }

        // Set click listeners for the bottom icons
        bottomIcon1.setOnClickListener(v -> startActivity(new Intent(HomePage.this, MainActivity3.class)));

        bottomIcon2.setOnClickListener(v -> startActivity(new Intent(HomePage.this, Dashboard.class)));

        bottomIcon3.setOnClickListener(v -> startActivity(new Intent(HomePage.this, MainActivity3.class)));

        // Set click listeners for the new ImageViews
        stillImage.setOnClickListener(v -> startActivity(new Intent(HomePage.this, MainActivity.class)));

        imageB.setOnClickListener(v -> startActivity(new Intent(HomePage.this, MainActivity.class)));

        imageC.setOnClickListener(v -> startActivity(new Intent(HomePage.this, MainActivity.class)));

        imageD.setOnClickListener(v -> startActivity(new Intent(HomePage.this, MainActivity.class)));

        imageE.setOnClickListener(v -> startActivity(new Intent(HomePage.this, MainActivity.class)));

        imageF.setOnClickListener(v -> startActivity(new Intent(HomePage.this, MainActivity.class)));
    }
}
