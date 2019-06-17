package com.example.designer2.moviesapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.designer2.moviesapp.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class fragmentRvAdapter extends RecyclerView.Adapter {
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_listing_row_items,parent,false);
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
