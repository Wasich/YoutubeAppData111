package com.example.designer2.moviesapp.drawerwithtab;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.designer2.moviesapp.R;
import com.example.designer2.moviesapp.adapters.BookAdapterssssssmoviesfragment;
import com.example.designer2.moviesapp.model.VideosModel;
import com.example.designer2.moviesapp.uisViews.ExoPlayerView;
import com.example.designer2.moviesapp.uisViews.WebviewYoutubePlayer;
import com.example.designer2.moviesapp.viewModel.VideoViewModel;

public class Movies extends Fragment {
    private RecyclerView recyclerViewsss;
    BookAdapterssssssmoviesfragment bookAdapterssssss;
    ProgressDialog progressDialog;
    ViewFlipper flipper;

    View v;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.moviesfragment,container,false);
        recyclerViewsss = (RecyclerView)v.findViewById(R.id.recyclerviewfragmentmovies);
      //  bookAdapterssssss = new BookAdapterssssssmoviesfragment(this,R.layout.gridrv_row_items2);
        recyclerViewsss.setLayoutManager(new GridLayoutManager(getActivity(),2));
        // recyclerViewsss.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerViewsss.setAdapter(bookAdapterssssss);
        progressDialog = new ProgressDialog(getActivity());

        int[]images = {R.drawable.masjid,R.drawable.pakistan,R.drawable.youtube};
        flipper =(ViewFlipper)v.findViewById(R.id.viewflippersss);
        for (int i = 0; i<images.length; i++){
            viewflipper(images[i]);
        }
        bookAdapterssssss.setOnItemClickListener(new BookAdapterssssssmoviesfragment.ClickListener() {
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
    public void viewflipper(int image)
    {
        ImageView imageView = new ImageView(getContext());
        imageView.setBackgroundResource(image);
        flipper.addView(imageView);
        flipper.setFlipInterval(2000);
        flipper.setAutoStart(true);
        flipper.setInAnimation(getContext(),android.R.anim.fade_in);
        flipper.setOutAnimation(getContext(),android.R.anim.fade_out);
    }

}
