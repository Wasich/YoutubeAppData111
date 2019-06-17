package com.example.designer2.moviesapp.adapters;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.example.designer2.moviesapp.R;
import com.example.designer2.moviesapp.model.VideosModel;
import com.example.designer2.moviesapp.uisViews.VideoListing;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


public class RecyclerViewAdapterCircle extends RecyclerView.Adapter<RecyclerViewAdapterCircle.RecyclerViewHolder> {

    private List<VideosModel.ItemsBean> bookLists;
    private Context mContext;
    private int drawable;

    public RecyclerViewAdapterCircle(Context context, int drawable) {
        this.mContext = context;
        this.drawable = drawable;

        bookLists = new ArrayList<>();
    }

    @Override
    public RecyclerViewAdapterCircle.RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RecyclerViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(drawable, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapterCircle.RecyclerViewHolder holder, int position) {

        VideosModel.ItemsBean books = bookLists.get(position);

       // holder.releaseDate.setText(books.getVolumeInfo().getPublishedDate());
        holder.bookTitle.setText(books.getVolumeInfo().getTitle());
        //holder.publisherName.setText(books.getVolumeInfo().getPublisher());
        Picasso.with(mContext)
                .load(books.getVolumeInfo().getImageLinks().getThumbnail())
                .into(holder.bookImage);
        holder.containers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,VideoListing.class);
                mContext.startActivity(intent);
            }
        });



    }

    @Override
    public int getItemCount() {
        return (bookLists != null ? bookLists.size() : 0);
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

       // private TextView releaseDate;
        private TextView bookTitle;
        //private TextView publisherName;
        private CircleImageView bookImage;
        RelativeLayout containers;


        public RecyclerViewHolder(View itemView) {
            super(itemView);

           // releaseDate = itemView.findViewById(R.id.publish_date);
            bookTitle = itemView.findViewById(R.id.namecircle);
           // publisherName = itemView.findViewById(R.id.publisher_name);
            bookImage = itemView.findViewById(R.id.image_viewcicrle);
            containers  = itemView.findViewById(R.id.circlerv_containers);

        }

    }

    public void addAll(List<VideosModel.ItemsBean> list) {

        for (int i = 0; i < list.size(); i++) {

            bookLists.add(list.get(i));
            notifyDataSetChanged();
        }

    }
}
