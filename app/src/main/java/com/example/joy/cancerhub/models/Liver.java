package com.example.joy.cancerhub.models;

public class Liver {
    String overview;
    String medical_illustrations;
    String diagnosis;

    public Liver(){}
    public Liver(String overview,String medical_illustrations,String diagnosis){
        this.overview = overview;
        this.diagnosis = diagnosis;
        this.medical_illustrations = medical_illustrations;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }
}
