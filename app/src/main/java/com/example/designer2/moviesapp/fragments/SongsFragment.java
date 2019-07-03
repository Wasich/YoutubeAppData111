package com.example.designer2.moviesapp.fragments;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ViewFlipper;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.designer2.moviesapp.R;
import com.example.designer2.moviesapp.adapters.BookAdapterssssssmoviesfragment;
import com.example.designer2.moviesapp.adapters.BookAdaptersssssssongsfragment;
import com.example.designer2.moviesapp.model.VideosModel;
import com.example.designer2.moviesapp.uisViews.ExoPlayerView;
import com.example.designer2.moviesapp.uisViews.WebviewYoutubePlayer;
import com.example.designer2.moviesapp.uisViews.WeolcomeScreen;
import com.example.designer2.moviesapp.viewModel.VideoViewModel;


/**
 * A simple {@link Fragment} subclass.
 */
public class SongsFragment extends Fragment {
    private RecyclerView recyclerViewsss;
    BookAdaptersssssssongsfragment bookAdapterssssss;
    ProgressDialog progressDialog;


    View v;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.songs,container,false);
        recyclerViewsss = (RecyclerView)v.findViewById(R.id.recyclerviewfragmentsongs);
        bookAdapterssssss = new BookAdaptersssssssongsfragment(this,R.layout.gridrv_row_items2);
        recyclerViewsss.setLayoutManager(new GridLayoutManager(getActivity(),2));
        // recyclerViewsss.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerViewsss.setAdapter(bookAdapterssssss);
        progressDialog = new ProgressDialog(getActivity());

        bookAdapterssssss.setOnItemClickListener(new BookAdaptersssssssongsfragment.ClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                Intent intent = new Intent(getActivity(), ExoPlayerView.class);
                startActivity(intent);

            }
        });


        final VideoViewModel bookViewModel =
                ViewModelProviders.of(this).get(VideoViewModel.class);

        observeViewModel(bookViewModel);
        progressDialog.setMessage("Loading Please Wait....");
        progressDialog.show();



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
                progressDialog.hide();

                // setlayout();


            }
        });

    }





}
