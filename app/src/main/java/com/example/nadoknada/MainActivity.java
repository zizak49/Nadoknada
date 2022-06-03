package com.example.nadoknada;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.RatingBar;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    private VideoView videoView;
    private RatingBar ratingBar;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        setUpVideoView();
        ratingBar = findViewById(R.id.ratingBar);

        submitButton =  findViewById(R.id.button);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rating = "Rating: " + ratingBar.getRating();
                Toast.makeText(getApplicationContext(), rating, Toast.LENGTH_LONG).show();
            }
        });
    }

    private void setUpVideoView()
    {
        videoView = findViewById(R.id.videoView);
        videoView.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.vsite);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        videoView.seekTo(1);
    }
}