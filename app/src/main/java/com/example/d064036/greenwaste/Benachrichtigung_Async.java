package com.example.d064036.greenwaste;


import android.os.AsyncTask;
import android.provider.Settings;
import android.service.voice.VoiceInteractionService;
import android.widget.CheckBox;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Benachrichtigung_Async extends AsyncTask<String,Integer,String> {

    CheckBox change;
    String searchfor = "Benachrichtigungen";

    public Benachrichtigung_Async() {
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
                output_string = output_string + output_initial.get(searchfor);

            }
            System.out.println(output_string);
            switch (output_string) {
                case "Tag":
                    EinstellungenActivity.RBbenachrichtigung.check(R.id.tag);
                    break;
                case "Woche":
                    EinstellungenActivity.RBbenachrichtigung.check(R.id.woche);
                    break;
                case "Keine":
                    EinstellungenActivity.RBbenachrichtigung.check(R.id.keine);
                    break;
                default:
                    EinstellungenActivity.RBbenachrichtigung.check(R.id.keine);
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
