package com.example.d064036.greenwaste;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toolbar;

public class KameraActivity extends AppCompatActivity {

    android.support.v7.widget.Toolbar toolbarKamera;
    ActionBar actionbarKamera;
    protected static String HolzMetall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kamera);

        toolbarKamera= findViewById(R.id.toolbarKamera);
        setSupportActionBar(toolbarKamera);

        actionbarKamera = getSupportActionBar();
        actionbarKamera.setDisplayHomeAsUpEnabled(true);
        actionbarKamera.setHomeAsUpIndicator(R.drawable.ic_back);
        actionbarKamera.setTitle("GreenWaste");

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        System.out.println(item.getItemId());
        switch (item.getItemId()) {
            case 16908332://R.id.action_settings:
                Intent intent3 = new Intent(this, MainActivity.class);
                startActivity(intent3);
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

    public void onClickMaterial(View v){
        int i = v.getId();
            if (i == 2131230724 ){
                HolzMetall = "Metall";
            } else if (i == 2131230723){
                HolzMetall = "Holz";
            } else {
                HolzMetall = "Holz";
            }
        Intent intent4 = new Intent(this, SuchergebnisActivity.class);
        startActivity(intent4);

    }
}
