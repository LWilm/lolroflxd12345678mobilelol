package com.example.d064036.greenwaste;


import android.os.AsyncTask;
import android.widget.Button;
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

import static com.example.d064036.greenwaste.MainActivity.BtnTonne1;
import static com.example.d064036.greenwaste.MainActivity.BtnTonne2;
import static com.example.d064036.greenwaste.MainActivity.BtnTonne3;
import static com.example.d064036.greenwaste.MainActivity.BtnTonne4;
import static com.example.d064036.greenwaste.MainActivity.EdtEntleerung1;
import static com.example.d064036.greenwaste.MainActivity.EdtEntleerung2;
import static com.example.d064036.greenwaste.MainActivity.EdtEntleerung3;
import static com.example.d064036.greenwaste.MainActivity.EdtEntleerung4;

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
        DateFormat format2 = new SimpleDateFormat("d.M.yyyy");
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

//            for(Abfallkalender a : AbfallkalenderList){
//                System.out.println("Datum:" + a.getDatum());
//                System.out.println("Tonne: " + a.getTonne());
//            }

            int j = 1;
            for(Abfallkalender f : AbfallkalenderList){
                tonnehelp = f.getTonne();
                datumhelp = f.getDatum();
                String reportDate = format2.format(datumhelp);

                System.out.println(reportDate);
                switch(j){
                    case 1:
                        EdtEntleerung1.setText(reportDate);
                        switch (tonnehelp){
                            case "1": BtnTonne1.setBackgroundResource(R.drawable.ic_blau); break;
                            case "2": BtnTonne1.setBackgroundResource(R.drawable.ic_braun); break;
                            case "3": BtnTonne1.setBackgroundResource(R.drawable.ic_schwarz); break;
                            case "4": BtnTonne1.setBackgroundResource(R.drawable.ic_gelb); break;
                        }
                        break;
                    case 2:
                        EdtEntleerung2.setText(reportDate);
                        switch (tonnehelp){
                            case "1": BtnTonne2.setBackgroundResource(R.drawable.ic_blau); break;
                            case "2": BtnTonne2.setBackgroundResource(R.drawable.ic_braun); break;
                            case "3": BtnTonne2.setBackgroundResource(R.drawable.ic_schwarz); break;
                            case "4": BtnTonne2.setBackgroundResource(R.drawable.ic_gelb); break;
                        }
                        break;
                    case 3:
                        EdtEntleerung3.setText(reportDate);
                        switch (tonnehelp){
                            case "1": BtnTonne3.setBackgroundResource(R.drawable.ic_blau); break;
                            case "2": BtnTonne3.setBackgroundResource(R.drawable.ic_braun); break;
                            case "3": BtnTonne3.setBackgroundResource(R.drawable.ic_schwarz); break;
                            case "4": BtnTonne3.setBackgroundResource(R.drawable.ic_gelb); break;
                        }
                        break;
                    case 4:
                        EdtEntleerung4.setText(reportDate);
                        switch (tonnehelp){
                            case "1": BtnTonne4.setBackgroundResource(R.drawable.ic_blau); break;
                            case "2": BtnTonne4.setBackgroundResource(R.drawable.ic_braun); break;
                            case "3": BtnTonne4.setBackgroundResource(R.drawable.ic_schwarz); break;
                            case "4": BtnTonne4.setBackgroundResource(R.drawable.ic_gelb); break;
                        }
                        break;
                }

                j = j + 1 ;
            }
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
