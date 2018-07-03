package com.example.d064036.greenwaste;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SuchergebnisDetails extends AppCompatActivity {

    TextView multiline;
    android.support.v7.widget.Toolbar toolbarDetails;
    ActionBar actionbarDetails;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suchergebnis_details);

        toolbarDetails = findViewById(R.id.toolbarSettings);
        setSupportActionBar(toolbarDetails);

        actionbarDetails = getSupportActionBar();
        actionbarDetails.setDisplayHomeAsUpEnabled(true);
        actionbarDetails.setHomeAsUpIndicator(R.drawable.ic_back);
        actionbarDetails.setTitle("Details");


        multiline =  findViewById(R.id.editText);
        multiline.setFocusable(false);
        multiline.setClickable(false);
        String s = "";

        switch(SuchergebnisActivity.suchergebnis){
            case 0:
                s = "Industriestrasse 52\nMannheim\n\nÖffnungszeiten:\nMo-Fr: 08:30 - 17:30\nSa: 08:00 - 12:00\nSo: geschlossen\n\nTel. Nr.: 06219841561";
                break;
            case 1:
                s = "Rheinstrasse 44\nLudwigshafen\n\nÖffnungszeiten:\nMo-Fr: 07:30 - 16:30\nSa: 08:00 - 13:00\nSo: geschlossen\n\nTel. Nr.: 06214586451";
                break;
            case 2:
                s = "Feldweg 7\nViernheim\n\nÖffnungszeiten:\nMo-Fr: 07:00 - 18:30\nSa: 08:00 - 13:00\nSo: 08:00 - 12:00\n\nTel. Nr.: 062047856153";
                break;
            case 3:
                s = "Kurzstrasse 62\nBad Dürkheim\n\nÖffnungszeiten:\nMo-Fr: 07:30 - 16:30\nSa: 08:00 - 13:00\nSo: geschlossen\n\nTel. Nr.: 06322586451";
            default:
                s = "Industriestrasse 52\nMannheim\n\nÖffnungszeiten:\nMo-Fr: 08:30 - 17:30\nSa: 08:00 - 12:00\nSo: geschlossen\n\nTel. Nr.: 06219841561";
        }
        multiline.setText(s);

        System.out.println(SuchergebnisActivity.suchergebnis);


    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        System.out.println(item.getItemId());
        switch (item.getItemId()) {
            case 16908332:
                Intent intent5 = new Intent(this, SuchergebnisActivity.class);
                startActivity(intent5);
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }
}
