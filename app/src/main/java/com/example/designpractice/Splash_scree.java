package com.example.designpractice;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Splash_scree extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_scree);


        VideoView videoView = findViewById(R.id.videoView);
        Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.sp3);
        videoView.setVideoURI(videoUri);

        videoView.setOnCompletionListener(mp -> {
            Intent intent = new Intent(Splash_scree.this, MainActivity.class);
            startActivity(intent);
            finish();
        });

        videoView.start();


    }
}