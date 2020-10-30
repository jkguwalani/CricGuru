package com.example.girish.myapplication;

import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.CardView;
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
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterViewFlipper;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.google.firebase.firestore.FirebaseFirestore;

public class main_activity extends AppCompatActivity {
    CardView cardView1,cardView2,cardView3,cardView4;

    ViewFlipper vfliper;
    private static final String key_title="title";
    private static final String key_des="desc";
    private FirebaseFirestore db=FirebaseFirestore.getInstance();

    int[] images={R.drawable.chennai,R.drawable.royal,R.drawable.rajasthan,R.drawable.mumbai,R.drawable.delhi,R.drawable.sunrisers,R.drawable.kolkata};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cricket);

        vfliper=(ViewFlipper) findViewById(R.id.viewfliper);
        for(int images:images)
        {
            flipper(images);
        }
        cardView1=(CardView)findViewById(R.id.batsman);
        cardView2=(CardView)findViewById(R.id.bowler);
        cardView3=(CardView)findViewById(R.id.allrounder);
        cardView4=(CardView)findViewById(R.id.winner);
        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(main_activity.this,Batsman.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fadin,R.anim.fadout);

            }
        });
        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(main_activity.this,Bowler.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fadin,R.anim.fadout);

            }
        });
        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(main_activity.this,allrounder.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fadin,R.anim.fadout);

            }
        });
        cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(main_activity.this,Winner.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fadin,R.anim.fadout);

            }
        });

    }


    public void flipper(int image)
    {
        ImageView imageView=new ImageView(this);
        imageView.setBackgroundResource(image);
        vfliper.addView(imageView);
        vfliper.setFlipInterval(2000);
        vfliper.setAutoStart(true);

        vfliper.setInAnimation(this, android.R.anim.slide_in_left);
        vfliper.setInAnimation(this,android.R.anim.slide_in_left);


    }
}
