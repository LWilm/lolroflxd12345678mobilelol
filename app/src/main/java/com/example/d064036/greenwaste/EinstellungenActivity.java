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
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class EinstellungenActivity extends AppCompatActivity {

    android.support.v7.widget.Toolbar toolbarSettings;
    ActionBar actionbarSettings;
    EditText Gpslocation;
    protected static String location;

    Benachrichtigung_Async BAJ;
    Eigene_Tonnen_Async TAJ;
    String table_einstellungen;
    String table_tonnen;

    public static CheckBox CBblau;
    public static CheckBox CBgrün;
    public static CheckBox CBschwarz;
    public static CheckBox CBgelb;
    public static RadioGroup RBbenachrichtigung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_einstellungen);

        CBblau = findViewById(R.id.blau);
        CBgrün = findViewById(R.id.grün);
        CBschwarz = findViewById(R.id.schwarz);
        CBgelb = findViewById(R.id.gelb);
        RBbenachrichtigung = findViewById(R.id.benachrichtigung);

        BAJ = new Benachrichtigung_Async();
        table_einstellungen = "Einstellungen"; //Tabelle nach der gesucht werden soll
        String url = null;

        try {
            url = "http://mobile.5bbiz.com/php/db.php?table=" + URLEncoder.encode(table_einstellungen, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        BAJ.execute(url);


        TAJ = new Eigene_Tonnen_Async();
        table_tonnen = "Eigene_Tonnen"; //Tabelle nach der gesucht werden soll
        String url2 = null;

        try {
            url2 = "http://mobile.5bbiz.com/php/db.php?table=" + URLEncoder.encode(table_tonnen, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        TAJ.execute(url2);

        //Hier muss eine Abfrage der DB rein welche Benachrichtung und welche Mülltonnen der User hat.
//        switch (Datenbankabfragergebnis) {
//            case "blau": RBblau.setChecked(true);
//            case "grün": RBgrün.setChecked(true);
//            case "schwarz": RBschwarz.setChecked(true);
//            case "gelb": RBgelb.setChecked(true);
//            case "tag": RBbenachrichtigung.check(R.id.tag);
//            case "woche": RBbenachrichtigung.check(R.id.woche);
//            case "keine": RBbenachrichtigung.check(R.id.keine);
//            }

        RBbenachrichtigung.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                //CheckID in die DB hochladen
            }
        });


        CBblau.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
                System.out.println(CBblau.isChecked());
                }
            }
        );

        CBgelb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                              @Override
                                              public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
                                                  System.out.println(CBgelb.isChecked());
                                              }
                                          }
        );

        CBgrün.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                              @Override
                                              public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
                                                  System.out.println(CBgrün.isChecked());
                                              }
                                          }
        );

        CBschwarz.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                              @Override
                                              public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
                                                  System.out.println(CBschwarz.isChecked());
                                              }
                                          }
        );



        Gpslocation = findViewById(R.id.editText2);

        if (location != null && location != "**here I want to check the 'str' is empty or not**")
        {
            Gpslocation.setText(location);
        } else {
            Gpslocation.setText("Bitte legen Sie durch Klick auf den Button Ihre Adresse fest.");
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
