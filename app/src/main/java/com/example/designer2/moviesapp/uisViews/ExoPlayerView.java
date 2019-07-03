package com.example.designer2.moviesapp.uisViews;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.opengl.Visibility;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.designer2.moviesapp.R;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout;
import com.google.android.exoplayer2.ui.SimpleExoPlayerView;

import java.util.Timer;
import java.util.TimerTask;

import at.huber.youtubeExtractor.Format;
import at.huber.youtubeExtractor.VideoMeta;
import at.huber.youtubeExtractor.YouTubeExtractor;
import at.huber.youtubeExtractor.YtFile;

public class ExoPlayerView extends AppCompatActivity {


    private String GRID_YOUTUBE_ID = "s9-Id1WJQyo";
    private String BASE_URL = "https://www.youtube.com";
    private String youtubeLink = BASE_URL + "/watch?v=" + GRID_YOUTUBE_ID;
    ImageView imageViewfullscreen,shrinkscreen,settingimg;
    SimpleExoPlayerView simpleExoPlayerView;
   // ImageButton  setting;
   // RadioButton low,medium,high;
    //TextView textView;

    //private LinearLayout linearLayout;








    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        // ExoPlayerView.this.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN || View.SYSTEM_UI_FLAG_IMMERSIVE);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exo_player_view);
        extractYoutubeUrl();

        simpleExoPlayerView = findViewById(R.id.player);
       // setting = findViewById(R.id.btn_settings);
//        setting.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                AlertDialog.Builder builder = new AlertDialog.Builder(ExoPlayerView.this);
//                builder.setTitle("Choose Video qualtiy");
//                // set the custom layout
//                final View customLayout = getLayoutInflater().inflate(R.layout.video_qualtiyselection, null);
//                builder.setView(customLayout);
//
//                // add a button
//                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//
//
//                    }
//                });
//                AlertDialog dialog = builder.create();
//                builder.show();
//            }
//
//        });
//
//        low = findViewById(R.id.quality_360);
//        medium = findViewById(R.id.qualtiy_720);
//        high = findViewById(R.id.qaulaty_1020);
//        textView =  findViewById(R.id.video_qauality_textview);




    }





    @SuppressLint("StaticFieldLeak")
    private void extractYoutubeUrl() {
        new YouTubeExtractor(this) {
            @Override
            public void onExtractionComplete(SparseArray<YtFile> sparseArray, VideoMeta vMeta) {
                //Log.d("======>>>>>>>>>>>>>>>>>", "onExtractionComplete: "+ytFiles.toString());
                if (sparseArray != null) {
                     for(int i=0, size = sparseArray.size(); i < size; i++){
                    YtFile ytFile = sparseArray.valueAt(i);
                    Format frmt = ytFile.getFormat();
                    if(frmt.getExt() == "mp4" || frmt.getExt() == "webm"){
                        Log.d(">>>>>>>>>>>>>>>>>>>>>>", "index: " + i+ " path: "+ytFile);
                    }


                    playVideo(ytFile.getUrl());


                     }

                }

            }
        }.extract(youtubeLink, true, true);
    }

    public void playVideo(String downloadUrl) {

        simpleExoPlayerView.setPlayer(ExoPlayerCustomise.getSharedInstance(ExoPlayerView.this).getSimpleExoPlayerView().getPlayer());
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


//
//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        super.onTouchEvent(event);
//
//        if (linearLayout.getVisibility()==View.INVISIBLE) {
//            linearLayout.setVisibility(View.VISIBLE);
//        } else if (linearLayout.getVisibility()==View.VISIBLE){
//            linearLayout.setVisibility(View.INVISIBLE);
//        }
//
//
//
////        } else if (linearLayout.getVisibility()==View.INVISIBLE){
////            Timer timer = new Timer(false);
////            timer.schedule(new TimerTask() {
////                @Override
////                public void run() {
////                    runOnUiThread(new Runnable() {
////                        @Override
////                        public void run() {
////                            linearLayout.setVisibility(View.VISIBLE);
////                        }
////                    });
////                }
////            },6000);
////
////
////        }
//
//        return false;
//    }
    //linearLayout = findViewById(R.id.linerlayout_custom_views);



    /*
     * timer visibilety for few second of the custom views
     *
     * */

//        Timer timer = new Timer(true);
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        if (linearLayout.getVisibility()==View.VISIBLE){
//                            linearLayout.setVisibility(View.INVISIBLE);
//
//                        } else if (linearLayout.getVisibility()==View.INVISIBLE){
//                            linearLayout.setVisibility(View.VISIBLE);
//                        }
//
//                    }
//                });

//            }
//        },6000);














//
//        imageViewfullscreen.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
//             imageViewfullscreen.setVisibility(View.INVISIBLE);
//            // shrinkscreen.setVisibility(View.VISIBLE);
//            // settingimg.setVisibility(View.VISIBLE);
//
//            }
//        });



//        shrinkscreen.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
//               // shrinkscreen.setVisibility(View.INVISIBLE);
//                imageViewfullscreen.setVisibility(View.VISIBLE);
//                settingimg.setVisibility(View.INVISIBLE);
//
//            }
//        });

//        settingimg.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(ExoPlayerView.this,"hello",Toast.LENGTH_SHORT).show();
//                final PopupMenu popupMenu = new PopupMenu(ExoPlayerView.this,v);
//                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
//                    @Override
//                    public boolean onMenuItemClick(MenuItem item) {
//
//
//
//                        return false;
//                    }
//                });
//
//                Menu menu = popupMenu.getMenu();
//                menu.add(Menu.NONE,0,0,"Chooce Video Quality");
//            }
//        });

    //imageViewfullscreen = findViewById(R.id.exo_fullscreen_icon);
    //shrinkscreen = findViewById(R.id.exo_halfscreen_icon);
    // settingimg = findViewById(R.id.exo_setting_icon);


}
