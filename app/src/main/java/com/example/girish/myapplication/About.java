package com.example.girish.myapplication;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

public class About extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.batsman) {
            Intent intent=new Intent(About.this,Batsman.class);
            startActivity(intent);
            Toast.makeText(this, "Batsman", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.bowler) {
            Intent intent1=new Intent(About.this,Bowler.class);
            startActivity(intent1);
            Toast.makeText(this, "Bowler", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.winner) {
            Intent intent2=new Intent(About.this,Winner.class);
            startActivity(intent2);
            Toast.makeText(this, "Winner", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.about) {
            Intent intent3=new Intent(About.this,About.class);
            startActivity(intent3);
            Toast.makeText(this, "about", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.allrounder) {
            Intent intent4=new Intent(About.this,allrounder.class);
            startActivity(intent4);
            Toast.makeText(this, "Allrounder", Toast.LENGTH_SHORT).show();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
