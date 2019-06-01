package com.example.designer2.moviesapp.uisViews;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.example.designer2.moviesapp.R;
import com.example.designer2.moviesapp.adapters.BookAdapterssssss;
import com.example.designer2.moviesapp.adapters.RecyclerViewAdapter;
import com.example.designer2.moviesapp.adapters.RecyclerViewAdapterCircle;
import com.example.designer2.moviesapp.model.VideosModel;
import com.example.designer2.moviesapp.viewModel.VideoViewModel;

public class WeolcomeScreen extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    private static String TAG = WeolcomeScreen.class.getSimpleName();
    private RecyclerView recyclerView;
    RecyclerViewAdapter bookAdapter;
    private RecyclerView recyclerViewsss,circlerv;
    RecyclerViewAdapterCircle adapterscircle;
    BookAdapterssssss bookAdapterssssss;
    ViewFlipper flipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weolcome_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setNestedScrollingEnabled(true);
        recyclerViewsss = findViewById(R.id.recyclerViewsss);
        recyclerViewsss.setNestedScrollingEnabled(false);

        int[]images = {R.drawable.masjid,R.drawable.pakistan,R.drawable.youtube};
        flipper = findViewById(R.id.viewflippersss);
        for (int i = 0; i<images.length; i++){
            viewflipper(images[i]);
        }


        circlerv = findViewById(R.id.recyclerViewcircle);
        circlerv.setNestedScrollingEnabled(false);

        bookAdapter = new RecyclerViewAdapter(this, R.layout.gridrv_row_items);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        recyclerView.setAdapter(bookAdapter);

        bookAdapterssssss = new BookAdapterssssss(this,R.layout.gridrv_row_items2);
        recyclerViewsss.setLayoutManager(new GridLayoutManager(this,2));
        recyclerViewsss.setAdapter(bookAdapterssssss);

        adapterscircle = new RecyclerViewAdapterCircle(this,R.layout.cicrlerv_row_item);
        circlerv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        circlerv.setAdapter(adapterscircle);


        //flipper = findViewById(R.id.flipper_view);


        final VideoViewModel bookViewModel =
                ViewModelProviders.of(this).get(VideoViewModel.class);

        observeViewModel(bookViewModel);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.weolcome_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
       // if (id == R.id.action_settings) {
            return true;
        }

       // return super.onOptionsItemSelected(item);
    //}

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            Toast.makeText(getApplicationContext(), "You clicked on My Favoriute", Toast.LENGTH_SHORT).show();

            // Handle the camera action
        } else if (id == R.id.nav_gallery) {
            Toast.makeText(getApplicationContext(), "You clicked on Watch Later", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_slideshow) {
            startActivity(new Intent(WeolcomeScreen.this,VideoListing.class));


        } else if (id == R.id.nav_manage) {
            Toast.makeText(getApplicationContext(), "You clicked on Setting", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_share) {
            Toast.makeText(getApplicationContext(), "You can share app with your friends", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_send) {
            Toast.makeText(getApplicationContext(), "You clicked on Subscribe", Toast.LENGTH_SHORT).show();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



    private void observeViewModel(VideoViewModel bookViewModel) {

        // updating list based on data change
        bookViewModel.getBookListLiveData().observe(this, new Observer<VideosModel>() {
            @Override
            public void onChanged(@Nullable VideosModel bookResponseModel) {

                if (bookResponseModel != null)
                    bookAdapter.addAll(bookResponseModel.getItems());
                bookAdapterssssss.addAll(bookResponseModel.getItems());
                adapterscircle.addAll(bookResponseModel.getItems());
                // setlayout();

                Log.e(TAG, "onChanged: " + bookResponseModel.getItems().size());
            }
        });

    }

    public void viewflipper(int image)
    {
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);
        flipper.addView(imageView);
        flipper.setFlipInterval(2000);
        flipper.setAutoStart(true);
        flipper.setInAnimation(this,android.R.anim.fade_in);
        flipper.setOutAnimation(this,android.R.anim.fade_out);
    }
}
