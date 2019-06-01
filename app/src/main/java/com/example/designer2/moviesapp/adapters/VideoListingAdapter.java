package com.example.designer2.moviesapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.designer2.moviesapp.R;
import com.example.designer2.moviesapp.model.VideosModel;
import com.example.designer2.moviesapp.uisViews.VideoListing;
import com.example.designer2.moviesapp.uisViews.YoutubePlayer;

import java.util.ArrayList;
import java.util.List;


public class VideoListingAdapter extends RecyclerView.Adapter<VideoListingAdapter.RecyclerViewHolder> {

    private List<VideosModel.ItemsBean> bookLists;
    private Context mContext;
    private int drawable;

    public VideoListingAdapter(Context context, int drawable) {
        this.mContext = context;
        this.drawable = drawable;

        bookLists = new ArrayList<>();
    }

    @Override
    public VideoListingAdapter.RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RecyclerViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(drawable, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull VideoListingAdapter.RecyclerViewHolder holder, int position) {

        VideosModel.ItemsBean books = bookLists.get(position);

        holder.time.setText(books.getVolumeInfo().getPublishedDate());
        holder.title.setText(books.getVolumeInfo().getTitle());
        holder.artist.setText(books.getVolumeInfo().getPublishedDate());
        Glide.with(mContext)
                .load(books.getVolumeInfo().getImageLinks().getThumbnail())
                .into(holder.thumbnail);
        holder.contaner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,YoutubePlayer.class);
                mContext.startActivity(intent);
            }
        });




    }

    @Override
    public int getItemCount() {
        return (bookLists != null ? bookLists.size() : 0);
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        LinearLayout contaner;
        ImageView thumbnail;
        TextView title;
        TextView time;
        TextView artist;

        public RecyclerViewHolder(View itemView) {
            super(itemView);

            contaner = itemView.findViewById(R.id.video_listing_container);
            thumbnail = itemView.findViewById(R.id.thumbnail_id);
            title = itemView.findViewById(R.id.titletxt);
            time =  itemView.findViewById(R.id.date_id);
            artist = itemView.findViewById(R.id.author_name);

        }

    }

    public void addAll(List<VideosModel.ItemsBean> list) {

        for (int i = 0; i < list.size(); i++) {

            bookLists.add(list.get(i));
            notifyDataSetChanged();
        }

    }
}
