package com.example.online_auction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Home extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        BottomNavigationView bnv = (BottomNavigationView)findViewById(R.id.bootonnav);
        bnv.setSelectedItemId(R.id.menu_home);
        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){

                    case R.id.menu_home :
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
                        startActivity(new Intent(getApplicationContext(),navprofile.class));
                        overridePendingTransition(0,0);
                        return true;


                }

                return false;
            }
        });
    }
}