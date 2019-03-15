package com.example.joy.cancerhub.models;

public class Prognosis {

    public String cancerDisease;
    public float riskscore ;
    public String riskLevel;
    public String advice;

    public Prognosis() {
    }

    public Prognosis(String cancerDisease, float riskscore, String riskLevel, String advice) {
        this.cancerDisease = cancerDisease;
        this.riskscore = riskscore;
        this.riskLevel = riskLevel;
        this.advice = advice;
    }
    public String getCancerDisease() {
        return cancerDisease;
    }

    public void setCancerDisease(String cancerDisease) {
        this.cancerDisease = cancerDisease;
    }

    public double getRiskscore() {
        return riskscore;
    }

    public void setRiskscore(float riskscore) {
        this.riskscore = riskscore;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice;
    }
}
