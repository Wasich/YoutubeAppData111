package com.example.designer2.moviesapp.uisViews;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;

import com.example.designer2.moviesapp.R;
import com.google.android.youtube.player.YouTubePlayerView;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;

public class WebviewYoutubePlayer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview_youtube_player);


        com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView youTubePlayerView = findViewById(R.id.youtube_player_view);
        getLifecycle().addObserver(youTubePlayerView);
        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                String videoId = "IycKNqkj6Rs";
                String vidiosecond  = "S0Q4gqBUs7c";
                youTubePlayer.loadVideo(vidiosecond,1);
                youTubePlayer.loadVideo(videoId, 0);
            }
        });




    }
}
