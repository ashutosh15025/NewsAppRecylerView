package com.example.ashutosh_wheelseye;
import java.io.Serializable;

@SuppressWarnings("serial")
public class Newsobjectd implements Serializable {
    String image;
    String NewsTitle;
    String Newstext;
    String Url;

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public Newsobjectd(String image, String newsTitle, String newstext, String url) {
        this.image = image;
        NewsTitle = newsTitle;
        Newstext = newstext;
        Url=url;
    }
    public Newsobjectd() {

    }
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getNewsTitle() {
        return NewsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        NewsTitle = newsTitle;
    }

    public String getNewstext() {
        return Newstext;
    }

    public void setNewstext(String newstext) {
        Newstext = newstext;
    }
}
