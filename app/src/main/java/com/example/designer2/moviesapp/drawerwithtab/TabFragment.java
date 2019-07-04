package com.example.designer2.moviesapp.drawerwithtab;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.designer2.moviesapp.R;
import com.google.android.material.tabs.TabLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class TabFragment extends Fragment {

    public static TabLayout tabLayout;
    public static ViewPager viewPager;
    public static int int_items = 3;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //this inflates out tab layout file.
        View x =  inflater.inflate(R.layout.tab_fragment_layout,null);
        // set up stuff.
        tabLayout = (TabLayout) x.findViewById(R.id.tabs);
        viewPager = (ViewPager) x.findViewById(R.id.viewpager);

        // create a new adapter for our pageViewer. This adapters returns child fragments as per the positon of the page Viewer.
        viewPager.setAdapter(new MyAdapter(getChildFragmentManager()));

        // this is a workaround
        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                //provide the viewPager to TabLayout.
                tabLayout.setupWithViewPager(viewPager);
            }
        });
        //to preload the adjacent tabs. This makes transition smooth.
        viewPager.setOffscreenPageLimit(3);

       return x;
   }

    class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        //return the fragment with respect to page position.
        @Override
        public Fragment getItem(int position)
        {
            switch (position){
                case 0 : return new Movies();
                case 1 :return new Songs();
                case 2 : return new TopSongsFragment();
            }
            return null;
        }

        @Override
        public int getCount() {

            return int_items;

        }

        //This method returns the title of the tab according to the position.
        @Override
        public CharSequence getPageTitle(int position) {

            switch (position){
                case 0 :
                    return "Movies";
                case 1 :
                    return "Songs";
                case 2:
                    return "Top";

            }
            return null;
        }
    }
}