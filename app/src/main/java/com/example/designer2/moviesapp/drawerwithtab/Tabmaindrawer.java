package com.example.designer2.moviesapp.drawerwithtab;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;

import android.view.MenuItem;
import android.widget.Toast;
import com.example.designer2.moviesapp.R;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ShareCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.navigation.NavigationView;

public class Tabmaindrawer extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private NavigationView navigationView;
    private ActionBarDrawerToggle drawerToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tabmaindrawer);
        initializeStuff();

        setSupportActionBar(toolbar);

        setUpNavigationView(navigationView);

        drawerToggle = setupDrawerToggle();
        drawerLayout.addDrawerListener(drawerToggle);

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.frameContent,new TabFragment()).commit();
        navigationView.setCheckedItem(R.id.nav_camera);
        setTitle(R.string.app_name);

    }
    void initializeStuff(){
        drawerLayout =(DrawerLayout) findViewById(R.id.drawerLayout);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        navigationView = (NavigationView) findViewById(R.id.navigationDrawer);
    }

    private void setUpNavigationView(final NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        int id = menuItem.getItemId();

                        if (id == R.id.nav_camera) {
                            Toast.makeText(getApplicationContext(), "You clicked on My Favoriute", Toast.LENGTH_SHORT).show();



                        } else if (id == R.id.nav_share) {
                            Toast.makeText(getApplicationContext(), "You can share app with your friends", Toast.LENGTH_SHORT).show();
                            ShareCompat.IntentBuilder.from(Tabmaindrawer.this)
                                    .setType("text/plain")
                                    .setChooserTitle("Chooser title")
                                    .setText("http://play.google.com/store/apps/details?id=" + Tabmaindrawer.this.getPackageName())
                                    .startChooser();


                        } else if (id == R.id.nav_rateapp){


                            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=PackageName")));


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


                        drawerLayout.closeDrawer(GravityCompat.START);
                        return true;
                    }
                });
    }

//

    private ActionBarDrawerToggle setupDrawerToggle() {
        return new ActionBarDrawerToggle(this, drawerLayout, toolbar,R.string.drawer_open,R.string.drawer_close);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }
}
