package com.example.nyt.Retrofit;

import android.support.annotation.Nullable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Multimedium {
@Nullable
    @SerializedName("url")
    @Expose
    public String url = null;
@Nullable
    @SerializedName("format")
    @Expose
    public String format = null;
    @Nullable
    @SerializedName("height")
    @Expose
    public Integer height = 0;
    @SerializedName("width")
    @Expose
    public Integer width = 0;
    @Nullable
    @SerializedName("type")
    @Expose
    public String type = null;
    @Nullable
    @SerializedName("subtype")
    @Expose
    public String subtype = null;
    @Nullable
    @SerializedName("caption")
    @Expose
    public String caption = null;
    @Nullable
    @SerializedName("copyright")
    @Expose
    public String copyright = null;

}
