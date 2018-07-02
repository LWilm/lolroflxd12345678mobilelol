package com.example.d064036.greenwaste;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class EinstellungenActivity extends AppCompatActivity {

    android.support.v7.widget.Toolbar toolbarSettings;
    ActionBar actionbarSettings;
    String test;
    EditText Gpslocation;
    protected static String location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_einstellungen);

        Gpslocation = findViewById(R.id.editText2);

        if (location != null && location != "**here I want to check the 'str' is empty or not**")
        {
            Gpslocation.setText(location);
        } else {
            Gpslocation.setText("Bitte legen Sie mit Hilfe des Buttons Ihre Adresse fest.");
        }

        toolbarSettings = findViewById(R.id.toolbarSettings);
        setSupportActionBar(toolbarSettings);

        actionbarSettings = getSupportActionBar();
        actionbarSettings.setDisplayHomeAsUpEnabled(true);
        actionbarSettings.setHomeAsUpIndicator(R.drawable.ic_back);
        actionbarSettings.setTitle("Einstellungen");


    }

    //das ist das wo man auf den pfeil scheiß button oben links clickt
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        System.out.println(item.getItemId());
        switch (item.getItemId()) {
            case 16908332:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

    public void getLocation(View aView){
        location = "Mannheim, Deutschland";
        Gpslocation.setText(location);
    }

}
