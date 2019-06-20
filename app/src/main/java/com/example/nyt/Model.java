package com.example.nyt;

import java.util.ArrayList;

public class Model {

    public static ArrayList<String> getDisplay_title() {
        return display_title;
    }

    public static void setDisplay_title(ArrayList<String> display_title) {
        Model.display_title = display_title;
    }

    public static ArrayList<String> getMpaa_rating() {
        return mpaa_rating;
    }

    public static void setMpaa_rating(ArrayList<String> mpaa_rating) {
        Model.mpaa_rating = mpaa_rating;
    }

    static ArrayList<String> getCritics_pick() {
        return critics_pick;
    }

    public static void setCritics_pick(ArrayList<String> critics_pick) {
        Model.critics_pick = critics_pick;
    }

    public static ArrayList<String> getByline() {
        return byline;
    }

    public static void setByline(ArrayList<String> byline) {
        Model.byline = byline;
    }

    public static ArrayList<String> getHeadline() {
        return headline;
    }

    public static void setHeadline(ArrayList<String> headline) {
        Model.headline = headline;
    }

    public static ArrayList<String> getSummary_short() {
        return summary_short;
    }

    public static void setSummary_short(ArrayList<String> summary_short) {
        Model.summary_short = summary_short;
    }

    public static ArrayList<String> getPublication_date() {
        return publication_date;
    }

    public static void setPublication_date(ArrayList<String> publication_date) {
        Model.publication_date = publication_date;
    }

    public static ArrayList<String> getOpening_date() {
        return opening_date;
    }

    public static void setOpening_date(ArrayList<String> opening_date) {
        Model.opening_date = opening_date;
    }

    public static ArrayList<String> getDate_updated() {
        return date_updated;
    }

    public static void setDate_updated(ArrayList<String> date_updated) {
        Model.date_updated = date_updated;
    }

    public static ArrayList<String> getSrc() {
        return src;
    }

    public static void setSrc(ArrayList<String> src) {
        Model.src = src;
    }

    static ArrayList<String> display_title;
    static ArrayList<String> mpaa_rating;
    static ArrayList<String> critics_pick;
    static ArrayList<String> byline;
    static ArrayList<String> headline;
    static ArrayList<String> summary_short;
    static ArrayList<String> publication_date;
    static ArrayList<String> opening_date;
    static ArrayList<String> date_updated;
    static ArrayList<String> src;


    public static String getStatus() {
        return status;
    }

    public static void setStatus(String status) {
        Model.status = status;
    }

    public static String getCopyright() {
        return copyright;
    }

    public static void setCopyright(String copyright) {
        Model.copyright = copyright;
    }

    public static boolean isHas_more() {
        return has_more;
    }

    public static void setHas_more(boolean has_more) {
        Model.has_more = has_more;
    }

    public static int getNum_results() {
        return num_results;
    }

    public static void setNum_results(int num_results) {
        Model.num_results = num_results;
    }

    static String status;
    static String copyright;
    static boolean has_more;
    static int num_results;



}


