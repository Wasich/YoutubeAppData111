package com.example.designer2.moviesapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.designer2.moviesapp.R;
import com.example.designer2.moviesapp.fragments.MoviesFragment;
import com.example.designer2.moviesapp.fragments.SongsFragment;
import com.example.designer2.moviesapp.model.VideosModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class BookAdaptersssssssongsfragment extends RecyclerView.Adapter<BookAdaptersssssssongsfragment.RecyclerViewHolder> {

    private List<VideosModel.ItemsBean> bookLists;
    private Context mContext;
    private int drawable;
    private static ClickListener clickListener;


    public BookAdaptersssssssongsfragment(SongsFragment context, int drawable) {
        //this.mContext = context;
        this.drawable = drawable;

        bookLists = new ArrayList<>();
    }




    @Override
    public BookAdaptersssssssongsfragment.RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RecyclerViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(drawable, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final BookAdaptersssssssongsfragment.RecyclerViewHolder holder, int position) {

        VideosModel.ItemsBean books = bookLists.get(position);

        // holder.releaseDate.setText(books.getVolumeInfo().getPublishedDate());
        holder.bookTitle.setText(books.getVolumeInfo().getTitle());
        // holder.publisherName.setText(books.getVolumeInfo().getPublisher());
        Picasso.with(mContext)
                .load(books.getVolumeInfo().getImageLinks().getThumbnail())
                .into(holder.bookImage);






    }

    @Override
    public int getItemCount() {
        return (bookLists != null ? bookLists.size() : 0);
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        //private TextView releaseDate;
        private TextView bookTitle;
        //private TextView publisherName;
        private ImageView bookImage;
        CardView container;


        public RecyclerViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);

            // releaseDate = itemView.findViewById(R.id.publish_date);
            bookTitle = itemView.findViewById(R.id.category_title_id);
            // publisherName = itemView.findViewById(R.id.publisher_name);
            bookImage = itemView.findViewById(R.id.category_img_id);
            container = itemView.findViewById(R.id.grid_card);

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
        BookAdaptersssssssongsfragment.clickListener = clickListener;
    }

    public interface ClickListener {
        void onItemClick(int position, View v);

    }
}
