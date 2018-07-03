package com.example.d064036.greenwaste;


import android.os.AsyncTask;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class AsyncJson extends AsyncTask<String,Integer,String> {

    TextView output;
    String searchfor;

    public AsyncJson(TextView t, String s) {
        output = t; //wo soll das Ergebnis ausgegeben werden?
        searchfor = s; //Json Value nach dem gesucht wird
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        String output_string = "";
        try {
            JSONArray result = new JSONArray(s);
            JSONObject output_initial;
            for (int i = 0; i < result.length(); i++) {
                output_initial = result.getJSONObject(i);
                output_string = output_string + output_initial.get(searchfor) + "\n\n";
            }
            output.setText(output_string); //Hier ist der Output - kann auch returned werden
        } catch (JSONException e) {
            output.setText("Nothing Found!");
            e.printStackTrace();
        }
    }

    // Hier nix ändern
    @Override
    protected String doInBackground(String... urls) {

        String jsonString = "";
        for (String urlString:urls) {
            try {
                URL url = new URL(urlString);
                BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
                String line = "";
                while ((line = reader.readLine()) != null){
                    jsonString += line;
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        return jsonString;
    }
}

