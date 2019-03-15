package com.example.joy.cancerhub.models;

public class Info {
    private String cancer_info,coping_info,nav_careInfo,contactus,aboutus;

    public Info(){}
    public Info(String cancer_info,String coping_info,String nav_careInfo,String contactus,String aboutus){
        this.cancer_info = cancer_info;
        this.coping_info = coping_info;
        this.nav_careInfo = nav_careInfo;
        this.contactus = contactus;
        this.aboutus = aboutus;
    }

    public String getCancer_info() {
        return cancer_info;
    }

    public void setCancer_info(String cancer_info) {
        this.cancer_info = cancer_info;
    }

    public String getCoping_info() {
        return coping_info;
    }

    public void setCoping_info(String coping_info) {
        this.coping_info = coping_info;
    }

    public String getNav_careInfo() {
        return nav_careInfo;
    }

    public void setNav_careInfo(String nav_careInfo) {
        this.nav_careInfo = nav_careInfo;
    }

    public String getContactus() {
        return contactus;
    }

    public void setContactus(String contactus) {
        this.contactus = contactus;
    }

    public String getAboutus() {
        return aboutus;
    }

    public void setAboutus(String aboutus) {
        this.aboutus = aboutus;
    }
}

