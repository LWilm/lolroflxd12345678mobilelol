package com.example.d064036.greenwaste;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SuchergebnisActivity extends ListActivity {
    private ArrayAdapter<String> adapter;
    private List<String> liste;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suchergebnis);


        String[] values = new String[] { "Android", "iPhone", "WindowsMobile",
                "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
                "Linux", "OS/2" };
        liste = new ArrayList<String>();
        Collections.addAll(liste, values);
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, liste);
        setListAdapter(adapter);
    }
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        liste.add("Nokia");
        adapter.notifyDataSetChanged();
    }
}
