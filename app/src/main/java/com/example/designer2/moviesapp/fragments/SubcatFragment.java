package com.example.designer2.moviesapp.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.designer2.moviesapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SubcatFragment extends Fragment {


    public SubcatFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_subcat, container, false);
    }

}
