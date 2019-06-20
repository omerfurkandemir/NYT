package com.example.nyt.Retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface RestInterface {

    @GET()
    Call<Repo> getRepo(@Url String url);

}
