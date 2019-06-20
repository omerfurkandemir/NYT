package com.example.nyt;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Parse {

    ArrayList<String> display_title = new ArrayList<>();
    ArrayList<String> mpaa_rating = new ArrayList<>();
    ArrayList<String> critics_pick = new ArrayList<>();
    ArrayList<String> byline = new ArrayList<>();
    ArrayList<String> headline = new ArrayList<>();
    ArrayList<String> summary_short = new ArrayList<>();
    ArrayList<String> publication_date = new ArrayList<>();
    ArrayList<String> opening_date = new ArrayList<>();
    ArrayList<String> date_updated = new ArrayList<>();
    ArrayList<String> multimedia = new ArrayList<>();
    ArrayList<String> src = new ArrayList<>();

    String status, copyright;
    Boolean has_more;
    Integer num_results;

    String multimedia_string, src_string;

    public Parse(String response) {


        try {

            JSONObject jsonResponse = new JSONObject(String.valueOf(response));
            status = jsonResponse.getString("status");
            copyright = jsonResponse.getString("copyright");
            has_more = jsonResponse.getBoolean("has_more");
            num_results = jsonResponse.getInt("num_results");
            JSONArray results = jsonResponse.getJSONArray("results");
            for (int i = 0; i < results.length(); i++) {
                JSONObject userDetail = results.getJSONObject(i);
                display_title.add(userDetail.getString("display_title"));
                mpaa_rating.add(userDetail.getString("mpaa_rating"));
                critics_pick.add(userDetail.getString("critics_pick"));
                byline.add(userDetail.getString("byline"));
                headline.add(userDetail.getString("headline"));
                summary_short.add(userDetail.getString("summary_short"));
                publication_date.add(userDetail.getString("publication_date"));
                opening_date.add(userDetail.getString("opening_date"));
                date_updated.add(userDetail.getString("date_updated"));

                multimedia_string = userDetail.getString("multimedia");

                if(multimedia_string == "null"){
                    multimedia.add("null");
                    src.add("null");
                }
                else{
                    JSONObject multi = new JSONObject(userDetail.getString("multimedia"));
                    src_string = multi.getString("src");
                    multimedia.add(multimedia_string);
                    src.add(src_string);
                }
            }


            Model.setStatus(status);
            Model.setCopyright(copyright);
            Model.setHas_more(has_more);
            Model.setNum_results(num_results);

            Model.setDisplay_title(display_title);
            Model.setMpaa_rating(mpaa_rating);
            Model.setCritics_pick(critics_pick);
            Model.setByline(byline);
            Model.setHeadline(headline);
            Model.setSummary_short(summary_short);
            Model.setPublication_date(publication_date);
            Model.setOpening_date(opening_date);
            Model.setDate_updated(date_updated);
            Model.setSrc(src);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
