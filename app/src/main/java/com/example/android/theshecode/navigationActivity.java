package com.example.android.theshecode;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class navigationActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        //to set our toolbar because we removed the default one
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //taking care of hamburger icon on top
        drawer = findViewById(R.id.drawerlayout);
        NavigationView navigationView = (NavigationView)findViewById(R.id.naviagtion_view);
        navigationView.setNavigationItemSelectedListener(this);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        //when the app loads the first time, show the first fragment
        if(savedInstanceState == null){
            //if statement so that activity doesn't change when we rotate the screen b/c current activity is destroyed when screen is rotated.
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new MentorFragment()).commit();
            navigationView.setCheckedItem(R.id.mentor);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()){

            case R.id. mentor:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new MentorFragment()).commit();
                break;

            case R.id. studypartner:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new StudyPartnerFragment()).commit();
                break;

            case R.id. resources:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new ResourcesFragment()).commit();
                break;

            case R.id. inspireHer:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new InspireHerFragment()).commit();
                break;
        }

        return true;
    }

    //if our drawer is opne and back button is pressed, we dont want to close the activity itself
    //but we want only the drawer to be closed.
    //But in case the drawer is not open, then close the activity normally
    @Override
    public void onBackPressed(){
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }
    }

}
