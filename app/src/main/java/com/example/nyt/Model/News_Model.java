package com.example.nyt.Model;

import java.util.ArrayList;

public class News_Model {

    public static ArrayList<String> getSection() {
        return section;
    }

    public static void setSection(ArrayList<String> section) {
        News_Model.section = section;
    }

    public static ArrayList<String> getTitle() {
        return title;
    }

    public static void setTitle(ArrayList<String> title) {
        News_Model.title = title;
    }

    public static ArrayList<String> getByline() {
        return byline;
    }

    public static void setByline(ArrayList<String> byline) {
        News_Model.byline = byline;
    }

    public static ArrayList<String> getUrl() {
        return url;
    }

    public static void setUrl(ArrayList<String> url) {
        News_Model.url = url;
    }

    static ArrayList<String> section;
    static ArrayList<String> title;
    static ArrayList<String> byline;
    static ArrayList<String> url;

}
