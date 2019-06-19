package com.example.designer2.moviesapp.fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.designer2.moviesapp.R;
import com.example.designer2.moviesapp.adapters.BookAdapterssssss;
import com.example.designer2.moviesapp.adapters.BookAdapterssssssfragments;
import com.example.designer2.moviesapp.adapters.RecyclerViewAdapterCircle;
import com.example.designer2.moviesapp.model.VideosModel;
import com.example.designer2.moviesapp.uisViews.VideoListing;
import com.example.designer2.moviesapp.uisViews.WebviewYoutubePlayer;
import com.example.designer2.moviesapp.viewModel.VideoViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class SubcatFragment extends Fragment {
    private RecyclerView recyclerViewsss;
    BookAdapterssssssfragments bookAdapterssssss;

    View v;


    public SubcatFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_subcat, container, false);
        recyclerViewsss = (RecyclerView)v.findViewById(R.id.recyclerviewfragment);
        bookAdapterssssss = new BookAdapterssssssfragments(this,R.layout.video_listing_row_items);
        recyclerViewsss.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerViewsss.setAdapter(bookAdapterssssss);

        bookAdapterssssss.setOnItemClickListener(new BookAdapterssssssfragments.ClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                Intent intent = new Intent(getActivity(), VideoListing.class);
                startActivity(intent);

            }
        });


        final VideoViewModel bookViewModel =
                ViewModelProviders.of(this).get(VideoViewModel.class);

        observeViewModel(bookViewModel);

        return v;
    }




    public void onClick(View v){
        Intent intent =  new Intent(getActivity(), WebviewYoutubePlayer.class);
        startActivity(intent);
    }


    private void observeViewModel(VideoViewModel bookViewModel) {

        // updating list based on data change
        bookViewModel.getBookListLiveData().observe(this, new Observer<VideosModel>() {
            @Override
            public void onChanged(@Nullable VideosModel bookResponseModel) {

                if (bookResponseModel != null)

                bookAdapterssssss.addAll(bookResponseModel.getItems());

                // setlayout();


            }
        });

    }

}
