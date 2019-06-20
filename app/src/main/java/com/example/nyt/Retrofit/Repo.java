package com.example.nyt.Retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Repo {

    @SerializedName("status")
    @Expose
    public String status;
    @SerializedName("copyright")
    @Expose
    public String copyright;
    @SerializedName("section")
    @Expose
    public String section;
    @SerializedName("last_updated")
    @Expose
    public String lastUpdated;
    @SerializedName("num_results")
    @Expose
    public Integer numResults;
    @SerializedName("results")
    @Expose
    public List<Result> results;

}
