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

public class Update_Async extends AsyncTask<String,Integer,String> {

    String urlstring;

    public Update_Async() {
        //Komentatnasfsafd
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
