package com.learning.om.muscatcollege;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.learning.om.muscatcollege.about_us.MainAboutUsFragment;
import com.learning.om.muscatcollege.academic_programmess.MainAcademicProgrammesFragment;
import com.learning.om.muscatcollege.contact_us.ContactUsFragment;
import com.learning.om.muscatcollege.gallary.FragmentWithRecyclerView;
import com.learning.om.muscatcollege.gallary.LatestGalleryFragment;
import com.learning.om.muscatcollege.home.HomeFragment;

public class MainHomeNavigation extends  MuscatCollegeBaseActivity
        implements NavigationView.OnNavigationItemSelectedListener ,HomeFragment.OnFragmentInteractionListener,LatestGalleryFragment.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home_navigation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        FragmentTransaction fragmentTransaction =getSupportFragmentManager().beginTransaction();
        HomeFragment homeFragment =new HomeFragment();
        fragmentTransaction.replace(R.id.main_container1,homeFragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        getSupportActionBar().show();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    public void onBackPress(View view){
        getSupportActionBar().show();
        super.onBackPressed();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.action_settings1){

            java.util.Locale current=getResources().getConfiguration().locale;
            if(current.getLanguage().equalsIgnoreCase(com.learning.om.muscatcollege.global_contants.MuscatCollegeConstants.AR)) {
                changeLang(com.learning.om.muscatcollege.global_contants.MuscatCollegeConstants.EN);
            }else {
                changeLang(com.learning.om.muscatcollege.global_contants.MuscatCollegeConstants.AR);
            }
            android.content.Intent intent=getIntent();
            finish();
            startActivity(intent);
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        Fragment fragment=null;
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            fragment=new HomeFragment();
        } else if (id == R.id.student) {

        } else if (id == R.id.nav_gallery) {
            fragment=new LatestGalleryFragment();

        } else if (id == R.id.contact) {

            fragment=new ContactUsFragment();

        } else if (id == R.id.SiteMap) {

        } else if (id == R.id.nav_about_us) {

            fragment=new MainAboutUsFragment();
        } else if (id == R.id.nav_academic) {

            fragment=new MainAcademicProgrammesFragment();

        }else if (id == R.id.departments) {

        }else if (id == R.id.research) {

        }else if (id == R.id.facilities) {

        }else if (id == R.id.SiteMap) {

        }

        if (fragment!=null){
            fragmentTransaction.replace(R.id.main_container1,fragment);
            fragmentTransaction.addToBackStack(fragment.getClass().getSimpleName());
            fragmentTransaction.commit();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void back(View view) {
        getSupportActionBar().show();
        super.onBackPressed();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

//    @Override
//    public void onPointerCaptureChanged(boolean hasCapture) {
//
//    }
}
