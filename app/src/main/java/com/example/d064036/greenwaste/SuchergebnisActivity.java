package com.example.d064036.greenwaste;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.example.d064036.greenwaste.KameraActivity.HolzMetall;


public class SuchergebnisActivity extends AppCompatActivity {

    protected static int suchergebnis;
    android.support.v7.widget.Toolbar toolbarSuchergebnis;
    ActionBar actionbarSuchergebnis;

    private ListView mainListView ;
    private ArrayAdapter<String> listAdapter ;

    Button bildbutton;
    TextView mulltext;

    /** Called when the activity is first created. */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suchergebnis);

//        toolbarSuchergebnis = findViewById(R.id.toolbarSettings);
//        setSupportActionBar(toolbarSuchergebnis);
//        getActionBar().show();
//        getSupportActionBar().setTitle("Your Activity Title"); // for set actionbar title
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//
//        actionbarSuchergebnis = getSupportActionBar();
//        actionbarSuchergebnis.setDisplayHomeAsUpEnabled(true);
//        actionbarSuchergebnis.setHomeAsUpIndicator(R.drawable.ic_back);
//        actionbarSuchergebnis.setTitle(HolzMetall);

        bildbutton = findViewById(R.id.button4);
        mulltext = findViewById(R.id.textView8);

        if(HolzMetall == "Holz"){
            bildbutton.setVisibility(View.VISIBLE);
            mulltext.setVisibility(View.VISIBLE);
        }

        // Get reference of widgets from XML layout
        final ListView lv = (ListView) findViewById(R.id.listview);

        // Initializing a new String Array
        String[] fruits = new String[] {};

        // Create a List from String Array elements
        final List<String> fruits_list = new ArrayList<String>(Arrays.asList(fruits));

        // Create an ArrayAdapter from List
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                R.layout.activity_suchergebnis,
                R.id.textView4,
                fruits_list
        ){
            @Override
            public View getView(int position, View convertView, ViewGroup parent){
                // Get the current item from ListView
                View view = super.getView(position,convertView,parent);

                // Get the Layout Parameters for ListView Current Item View
                LayoutParams params = view.getLayoutParams();

                // Set the height of the Item View
                params.height = 200;
                view.setLayoutParams(params);

                return view;
            }
        };

        arrayAdapter.add("Wertstoffhof-Nord: 1.8km");
        arrayAdapter.add("Wertstoffhof-Süd: 6km");
        arrayAdapter.add("ATR Recycling GmbH: 15km");
        arrayAdapter.add("Schrotthandel Ludwig GmbH: 23km");
        arrayAdapter.add("Sperrmüll anmelden");

        // DataBind ListView with items from ArrayAdapter
        lv.setAdapter(arrayAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                System.out.println("hallo");
                switch (i){
                    case 0:
                        suchergebnis = 0;
                        break;
                    case 1:
                        suchergebnis = 1;
                        break;
                    case 2:
                        suchergebnis = 2;
                        break;
                    case 3:
                        suchergebnis = 3;
                        break;

                }

                if(i != 4) {
                    Intent intent2 = new Intent(SuchergebnisActivity.this, SuchergebnisDetails.class);
                    startActivity(intent2);
                    System.out.println(i);
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        System.out.println(item.getItemId());
        switch (item.getItemId()) {
            case 16908332:
                Intent intent6 = new Intent(this, KameraActivity.class);
                startActivity(intent6);
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

}