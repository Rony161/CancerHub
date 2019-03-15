package com.example.joy.cancerhub.models;

public class News {

    private String title, shortdesc, medNews,newsLink;

    public News(){}
    public News(String title,String shortdesc,String medNews,String newsLink){
        this.title =title;
        this.shortdesc = shortdesc;
        this.medNews = medNews;
        this.newsLink = newsLink;
    }
    public String getTitle(){return title;}
    public void setTitle(String title){this.title =title;}

    public String getShortdesc(){return shortdesc;}
    public void setShortdesc(String shortdesc){this.shortdesc = shortdesc;}

    public String getMedNews(){return medNews;}
    public void setMedNews(String medNews){this.medNews = medNews;}

    public String getNewsLink(){return newsLink;}
    public void setNewsLink(String newsLink){this.newsLink =newsLink;}


}
