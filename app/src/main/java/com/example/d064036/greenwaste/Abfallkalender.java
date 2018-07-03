package com.example.d064036.greenwaste;

import java.util.Date;

public class Abfallkalender implements Comparable<Abfallkalender> {

    String tonne;
    Date datum;

    public String getTonne() {
        return tonne;
    }

    public void setTonne(String tonne) {
        this.tonne = tonne;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Abfallkalender(String tonne, Date datum) {

        this.tonne = tonne;
        this.datum = datum;
    }

    @Override
    public int compareTo(Abfallkalender o) {
        return getDatum().compareTo(o.getDatum());
    }
}

