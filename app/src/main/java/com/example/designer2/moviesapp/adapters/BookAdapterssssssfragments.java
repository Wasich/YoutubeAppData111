package com.example.designer2.moviesapp.adapters;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.designer2.moviesapp.R;
import com.example.designer2.moviesapp.fragments.SubcatFragment;
import com.example.designer2.moviesapp.model.VideosModel;
import com.example.designer2.moviesapp.uisViews.VideoListing;
import com.example.designer2.moviesapp.uisViews.WebviewYoutubePlayer;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class BookAdapterssssssfragments extends RecyclerView.Adapter<BookAdapterssssssfragments.RecyclerViewHolder> {

    private List<VideosModel.ItemsBean> bookLists;
    private Context mContext;
    private int drawable;
    private static ClickListener clickListener;


    public BookAdapterssssssfragments(SubcatFragment context, int drawable) {
        //this.mContext = context;
        this.drawable = drawable;

        bookLists = new ArrayList<>();
    }

    @Override
    public BookAdapterssssssfragments.RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RecyclerViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(drawable, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final BookAdapterssssssfragments.RecyclerViewHolder holder, int position) {

        VideosModel.ItemsBean books = bookLists.get(position);
        holder.time.setText(books.getVolumeInfo().getPublishedDate());
        holder.title.setText(books.getVolumeInfo().getTitle());
        holder.artist.setText(books.getVolumeInfo().getPublishedDate());
        Picasso.with(mContext)
                .load(books.getVolumeInfo().getImageLinks().getThumbnail())
                .into(holder.thumbnail);





    }

    @Override
    public int getItemCount() {
        return (bookLists != null ? bookLists.size() : 0);
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        LinearLayout contaner;
        ImageView thumbnail;
        TextView title;
        TextView time;
        TextView artist;


        public RecyclerViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);

            contaner = itemView.findViewById(R.id.video_listing_container);
            thumbnail = itemView.findViewById(R.id.thumbnail_id);
            title = itemView.findViewById(R.id.titletxt);
            time =  itemView.findViewById(R.id.date_id);
            artist = itemView.findViewById(R.id.author_name);

        }

        @Override
        public void onClick(View v) {
            clickListener.onItemClick(getAdapterPosition(), v);

        }
    }

    public void addAll(List<VideosModel.ItemsBean> list) {

        for (int i = 0; i < list.size(); i++) {

            bookLists.add(list.get(i));
            notifyDataSetChanged();
        }

    }

    public void setOnItemClickListener(ClickListener clickListener) {
        BookAdapterssssssfragments.clickListener = clickListener;
    }

    public interface ClickListener {
        void onItemClick(int position, View v);

    }
}
