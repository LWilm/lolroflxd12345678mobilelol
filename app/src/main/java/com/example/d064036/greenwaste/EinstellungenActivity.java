package com.example.d064036.greenwaste;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class EinstellungenActivity extends AppCompatActivity {

    android.support.v7.widget.Toolbar toolbarSettings;
    ActionBar actionbarSettings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_einstellungen);

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

}
