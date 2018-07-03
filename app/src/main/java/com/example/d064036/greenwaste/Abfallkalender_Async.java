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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class Abfallkalender_Async extends AsyncTask<String,Integer,String> {

    CheckBox change;
    String datum = "Datum";
    String tonne = "Tonne";
    String Abfallkalender[][];
    String tonnehelp;
    Date datumhelp;
    String lolhelp;
    ArrayList<Abfallkalender> AbfallkalenderList = new ArrayList<Abfallkalender>();
    Abfallkalender Abfallkalenderhelp;
//    String help;

    public Abfallkalender_Async() {
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        String output_string = "";
        System.out.println("alex hat nen kleinen penis");

        DateFormat format = new SimpleDateFormat("yyyy-M-d");
//        Date date = format.parse(string);

        try {
            JSONArray result = new JSONArray(s);
            JSONObject output_initial;
            Abfallkalender = new String[2][result.length()];

            for (int i = 0; i < result.length(); i++) {
                output_initial = result.getJSONObject(i);
                datumhelp = null;
                lolhelp = "";
                lolhelp = lolhelp + output_initial.get(datum);
//                System.out.println(lolhelp);
                datumhelp = format.parse(lolhelp);
//
                tonnehelp = "";
                tonnehelp = tonnehelp + output_initial.get(tonne);
//
                Abfallkalenderhelp = new Abfallkalender(tonnehelp, datumhelp);
                AbfallkalenderList.add(Abfallkalenderhelp);
            }

            Collections.sort(AbfallkalenderList);

            int j = 1;
            for(Abfallkalender a : AbfallkalenderList){

                

                System.out.println("Datum:" + a.getDatum());
                System.out.println("Tonne: " + a.getTonne());
                j =+ 1 ;
            }




//            System.out.println(Arrays.deepToString(Abfallkalender));

//            System.out.println(Abfallkalender[0][15]);

//            System.out.println(Abfallkalender);
            System.out.println(Arrays.deepToString(Abfallkalender));
//            switch (output_string) {
//                case "Tag":
//                    EinstellungenActivity.RBbenachrichtigung.check(R.id.tag);
//                    break;
//                case "Woche":
//                    EinstellungenActivity.RBbenachrichtigung.check(R.id.woche);
//                    break;
//                case "Keine":
//                    EinstellungenActivity.RBbenachrichtigung.check(R.id.keine);
//                    break;
//                default:
//                    EinstellungenActivity.RBbenachrichtigung.check(R.id.keine);
//            }
        } catch (JSONException e) {
            System.out.println("Nothing Found!");
            e.printStackTrace();
        } catch (Exception e) {
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
