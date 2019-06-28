package com.example.designer2.moviesapp.uisViews;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.designer2.moviesapp.R;
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout;
import com.google.android.exoplayer2.ui.SimpleExoPlayerView;

import at.huber.youtubeExtractor.VideoMeta;
import at.huber.youtubeExtractor.YouTubeExtractor;
import at.huber.youtubeExtractor.YtFile;

public class ExoPlayerView extends AppCompatActivity {


    private String GRID_YOUTUBE_ID = "s9-Id1WJQyo";
    private String BASE_URL = "https://www.youtube.com";
    private String youtubeLink = BASE_URL + "/watch?v=" + GRID_YOUTUBE_ID;
    ImageView imageViewfullscreen,shrinkscreen;








    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
       // ExoPlayerView.this.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN || View.SYSTEM_UI_FLAG_IMMERSIVE);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exo_player_view);
        extractYoutubeUrl();
        imageViewfullscreen = findViewById(R.id.exo_fullscreen_icon);
        shrinkscreen = findViewById(R.id.exo_halfscreen_icon);



        imageViewfullscreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
             imageViewfullscreen.setVisibility(View.INVISIBLE);
             shrinkscreen.setVisibility(View.VISIBLE);

            }
        });



        shrinkscreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                shrinkscreen.setVisibility(View.INVISIBLE);
                imageViewfullscreen.setVisibility(View.VISIBLE);

            }
        });
    }





    @SuppressLint("StaticFieldLeak")
    private void extractYoutubeUrl() {
        new YouTubeExtractor(this) {
            @Override
            public void onExtractionComplete(SparseArray<YtFile> sparseArray, VideoMeta vMeta) {
                //Log.d("======>>>>>>>>>>>>>>>>>", "onExtractionComplete: "+ytFiles.toString());
                if (sparseArray != null) {
                    // for(int i=0, size = sparseArray.size(); i < size; i++){
                    YtFile ytFile = sparseArray.valueAt(1);
                    Log.d(">>>>>>>>>>>>>>>>>>>>>>", "index: " +  " path: "+ytFile);
                    playVideo(ytFile.getUrl());
                    // }

                    // playVideo(sparseArray.get(22).getUrl());
                }

            }
        }.extract(youtubeLink, true, true);
    }

    public void playVideo(String downloadUrl) {
        SimpleExoPlayerView simpleExoPlayer = findViewById(R.id.player);
        simpleExoPlayer.setPlayer(ExoPlayerCustomise.getSharedInstance(ExoPlayerView.this).getSimpleExoPlayerView().getPlayer());
       // simpleExoPlayer.setResizeMode(AspectRatioFrameLayout.);
        ExoPlayerCustomise.getSharedInstance(ExoPlayerView.this).playStream(downloadUrl);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

            ExoPlayerCustomise.getSharedInstance(ExoPlayerView.this).stopPlayer(true);


    }

    @Override
    protected void onPause() {
        super.onPause();
        ExoPlayerCustomise.getSharedInstance(ExoPlayerView.this).stopPlayer(true);
    }
}
