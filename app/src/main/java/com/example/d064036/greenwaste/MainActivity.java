package com.example.d064036.greenwaste;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    android.support.v7.widget.Toolbar toolbar;
    ActionBar actionbar;
    DrawerLayout mDrawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);

        mDrawerLayout = findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle actionBarDrawerToggle =
                new ActionBarDrawerToggle(this,mDrawerLayout,toolbar,R.string.drawer_open,R.string.drawer_close){

                    @Override
                    public void onDrawerClosed(View v){
                        super.onDrawerClosed(v);
                    }

                    @Override
                    public void onDrawerOpened(View v) {
                        Intent intent = new Intent(this, EinstellungenActivity.class);
                        startActivity(intent);
//                        super.onDrawerOpened(v);
                    }

                };


    }

}

