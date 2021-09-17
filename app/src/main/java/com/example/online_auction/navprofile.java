package com.example.online_auction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class navprofile extends AppCompatActivity {

    public TextView yourbids,bidhistory,aboutus,contactus,terms,feedback;
    Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navprofile);

        logout=(Button)findViewById(R.id.blogoutt);
        yourbids=(TextView) findViewById(R.id.yourbids);
        bidhistory=(TextView) findViewById(R.id.bidhistorybuyer);
        aboutus=(TextView) findViewById(R.id.aboutus);
        contactus=(TextView) findViewById(R.id.contactus);
        terms=(TextView) findViewById(R.id.termsandcondition);
        feedback=(TextView) findViewById(R.id.feedback);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });


        yourbids.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), navbids.class);
                startActivity(i);
            }
        });

        bidhistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), buyhistory.class);
                startActivity(i);
            }
        });
        aboutus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), About_Us.class);
                startActivity(i);
            }
        });
        contactus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Contact_Us.class);
                startActivity(i);
            }
        });
        terms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), terms_and_condition.class);
                startActivity(i);
            }
        });
        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Feedback.class);
                startActivity(i);
            }
        });





        BottomNavigationView bnv = (BottomNavigationView)findViewById(R.id.bootonnav);
        bnv.setSelectedItemId(R.id.menu_profile);
        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){

                    case R.id.menu_home :
                        startActivity(new Intent(getApplicationContext(),Home.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.menu_cat :
                        startActivity(new Intent(getApplicationContext(),navcategory.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.menu_bids :
                        startActivity(new Intent(getApplicationContext(),navbids.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.menu_profile :

                        return true;


                }

                return false;
            }
        });

    }
}