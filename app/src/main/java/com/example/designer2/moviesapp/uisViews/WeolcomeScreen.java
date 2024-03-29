package com.example.designer2.moviesapp.uisViews;

import android.Manifest;
import android.app.Dialog;

import androidx.annotation.NonNull;
import androidx.core.app.ShareCompat;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.opengl.Visibility;
import android.os.Bundle;
import androidx.annotation.Nullable;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.designer2.moviesapp.fragments.SubcatFragment;
import com.google.android.material.navigation.NavigationView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.example.designer2.moviesapp.R;
import com.example.designer2.moviesapp.adapters.BookAdapterssssss;
import com.example.designer2.moviesapp.adapters.RecyclerViewAdapter;
import com.example.designer2.moviesapp.adapters.RecyclerViewAdapterCircle;
import com.example.designer2.moviesapp.model.VideosModel;
import com.example.designer2.moviesapp.viewModel.VideoViewModel;

import java.util.List;

import hotchemi.android.rate.AppRate;
import hotchemi.android.rate.OnClickButtonListener;
import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;

public class WeolcomeScreen extends AppCompatActivity
        implements EasyPermissions.PermissionCallbacks,NavigationView.OnNavigationItemSelectedListener {


    private static String TAG = WeolcomeScreen.class.getSimpleName();
    private RecyclerView recyclerView;
    RecyclerViewAdapter bookAdapter;
    private RecyclerView recyclerViewsss,circlerv;
    RecyclerViewAdapterCircle adapterscircle;
    BookAdapterssssss bookAdapterssssss;
    ViewFlipper flipper;
    TextView textView;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weolcome_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RateApp();

        getSupportFragmentManager()
                .beginTransaction()
                // .add(R.id.content, SubcatFragment.newInstance())
                .commit();
        permsiionsruntime();

        textView = findViewById(R.id.textfragment);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SubcatFragment fragment = new SubcatFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragcaontainer,fragment).addToBackStack(null);

                transaction.commit();

            }
        });





        progressDialog = new ProgressDialog(this);



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
        progressDialog.setMessage("Loading Please Wait....");
        progressDialog.show();



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
//        } else if (id == R.id.nav_gallery) {
//            Toast.makeText(getApplicationContext(), "You clicked on Watch Later", Toast.LENGTH_SHORT).show();

//        } else if (id == R.id.nav_slideshow) {
//            startActivity(new Intent(WeolcomeScreen.this,VideoListing.class));
//

//        } else if (id == R.id.nav_manage) {
//            Toast.makeText(getApplicationContext(), "You clicked on Setting", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_share) {
            Toast.makeText(getApplicationContext(), "You can share app with your friends", Toast.LENGTH_SHORT).show();
            ShareCompat.IntentBuilder.from(this)
                    .setType("text/plain")
                    .setChooserTitle("Chooser title")
                    .setText("http://play.google.com/store/apps/details?id=" + this.getPackageName())
                    .startChooser();

//        } else if (id == R.id.nav_send) {
//            Toast.makeText(getApplicationContext(), "You clicked on Subscribe", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_rateapp){


            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=PackageName")));
//            final Dialog rankdialog = new Dialog(WeolcomeScreen.this,R.style.FullHeightDialog);
//            rankdialog.setContentView(R.layout.rating_alert_dialoge);
//            rankdialog.setCancelable(true);
//            RatingBar ratingBar = (RatingBar)rankdialog.findViewById(R.id.dialog_ratingbar);
//            //ratingBar.setRating(0);
//
//            TextView text = (TextView) rankdialog.findViewById(R.id.rank_dialog_text1);
//            text.setText("Rate this App");
//
//            Button updateButton = (Button) rankdialog.findViewById(R.id.rank_dialog_button);
//            updateButton.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    rankdialog.dismiss();
//                }
//            });
//            //now that the dialog is set up, it's time to show it
//            rankdialog.show();



        } else if (id==R.id.nav_aboutus){
            String url = "http://itelc.com/upcoming/company/team/";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);

        } else if (id==R.id.nav_contact){
            String url = "http://itelc.com/upcoming/company/about-us/";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);

        }else if (id==R.id.nav_privacy) {
            String url = "http://itelc.com/upcoming/privacy-policy/";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);

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
                progressDialog.hide();
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

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode,permissions,grantResults,this);
    }
    @AfterPermissionGranted(123)
    private void permsiionsruntime(){
        String[] perms = {Manifest.permission.CAMERA,Manifest.permission.INTERNET,Manifest.permission.ACCESS_FINE_LOCATION};
        if (EasyPermissions.hasPermissions(this,perms)){
            Toast.makeText(this,"permission are granted",Toast.LENGTH_SHORT).show();
            //Intent intent = new Intent(this,VideoListing.class);
            //startActivity(intent);
        }else {

            EasyPermissions.requestPermissions(this,"We need permissions Camera and Internet and location",123,perms);
        }
    }

    @Override
    public void onPermissionsGranted(int requestCode, @NonNull List<String> perms) {

    }

    @Override
    public void onPermissionsDenied(int requestCode, @NonNull List<String> perms) {
        if (EasyPermissions.somePermissionPermanentlyDenied(this,perms)){
            new AppSettingsDialog.Builder(this).build().show();

        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==AppSettingsDialog.DEFAULT_SETTINGS_REQ_CODE){

        }
    }

    /*
     * rating bar to show in the app
     *
     *
     * */


    private void RateApp(){
        AppRate.with(this)
                .setInstallDays(1)
                .setLaunchTimes(3)
                .setRemindInterval(1)
                .setOnClickButtonListener(new OnClickButtonListener() {
                    @Override
                    public void onClickButton(int which) {
                        if (which==-2){
                            WeolcomeScreen.this.finish();


                        }

                    }
                })
                .monitor();

        AppRate.showRateDialogIfMeetsConditions(this);
       // AppRate.with(this).showRateDialog(this);
    }


}
