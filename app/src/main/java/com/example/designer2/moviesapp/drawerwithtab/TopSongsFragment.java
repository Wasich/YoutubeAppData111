package com.example.designer2.moviesapp.drawerwithtab;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.designer2.moviesapp.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class TopSongsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.topsongsfragment,null);
    }
}
