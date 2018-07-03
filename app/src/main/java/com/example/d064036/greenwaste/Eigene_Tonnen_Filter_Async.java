package com.example.d064036.greenwaste;


import android.os.AsyncTask;
import android.widget.CheckBox;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Eigene_Tonnen_Filter_Async extends AsyncTask<String,Integer,String> {

    CheckBox change;
    String searchfor = "Besitz";

    public Eigene_Tonnen_Filter_Async() {
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
                    output_string = String.valueOf(output_initial.get(searchfor));
                switch (output_string) {
                    case "0":
                        switch (i) {
                            case 0:
                                MainActivity.CBBlau.setChecked(false);
                                break;
                            case 1:
                                MainActivity.CBGruen.setChecked(false);
                                break;
                            case 2:
                                MainActivity.CBSchwarz.setChecked(false);
                                break;
                            case 3:
                                MainActivity.CBGelb.setChecked(false);
                                break;
                        }
                        break;
                    case "1":
                        switch (i) {
                            case 0:
                                MainActivity.CBBlau.setChecked(true);
                                break;
                            case 1:
                                MainActivity.CBGruen.setChecked(true);
                                break;
                            case 2:
                                MainActivity.CBSchwarz.setChecked(true);
                                break;
                            case 3:
                                MainActivity.CBGelb.setChecked(true);
                                break;
                        }
                        break;
                    default:
                        System.out.println(output_string);
                }
            }
        } catch (JSONException e) {
            System.out.println("Nothing Found!");
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
