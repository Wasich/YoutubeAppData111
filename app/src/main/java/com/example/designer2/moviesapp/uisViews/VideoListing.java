package com.example.designer2.moviesapp.uisViews;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;

import com.example.designer2.moviesapp.R;
//import com.example.designer2.moviesapp.adapters.RecyclerViewAdapter;
import com.example.designer2.moviesapp.adapters.VideoListingAdapter;
import com.example.designer2.moviesapp.model.VideosModel;
import com.example.designer2.moviesapp.viewModel.VideoViewModel;

public class VideoListing extends AppCompatActivity {

    private static String TAG = VideoListing.class.getSimpleName();
    private RecyclerView listingRecyclerview;
    VideoListingAdapter listingAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_listing);

        listingRecyclerview = findViewById(R.id.rec_listing);

        listingAdapter = new VideoListingAdapter(this,R.layout.video_listing_row_items);
        listingRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        listingRecyclerview.setAdapter(listingAdapter);


        getSupportActionBar().setDisplayShowHomeEnabled(true);
        androidx.appcompat.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);





        final VideoViewModel bookViewModel =
                ViewModelProviders.of(this).get(VideoViewModel.class);

        observeViewModel(bookViewModel);







    }

    private void observeViewModel(VideoViewModel bookViewModel) {

        // updating list based on data change
        bookViewModel.getBookListLiveData().observe(this, new Observer<VideosModel>() {
            @Override
            public void onChanged(@Nullable VideosModel bookResponseModel) {

                if (bookResponseModel != null)
                    listingAdapter.addAll(bookResponseModel.getItems());


                // setlayout();

                Log.e(TAG, "onChanged: " + bookResponseModel.getItems().size());
            }
        });

    }
}
