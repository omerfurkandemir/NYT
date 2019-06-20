package com.example.nyt.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nyt.Adapter.Adapter;
import com.example.nyt.Adapter.NewsAdapter;
import com.example.nyt.Model.Model;
import com.example.nyt.R;
import com.example.nyt.Retrofit.ApiClient;
import com.example.nyt.Retrofit.Repo;
import com.example.nyt.Retrofit.RestInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Sayfa2 extends Fragment {
    private static final String TAG = "Sayfa2";

    RestInterface restInterface;

    RecyclerView recyclerView;
    private NewsAdapter myAdapter;

    static Response section_res, title_res, byline_res, url_res;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sayfa2, container, false);

        restInterface = ApiClient.getClient().create(RestInterface.class);
        Call<Repo> call = restInterface.getRepo("svc/topstories/v2/science.json?api-key=2hfqKd3QI7m64EKQ0LIDFCkFCIVrMZNe");

        call.enqueue(new Callback<Repo>() {
            @Override
            public void onResponse(Call<Repo> call, Response<Repo> response) {
                Repo repoList = new Repo();

                //section_res = response;

                repoList = response.body();


                for (int i = 0; i < repoList.results.size(); i++) {
                    System.out.println(repoList.results.get(i).section);
                    System.out.println(repoList.results.get(i).title);
                    System.out.println(repoList.results.get(i).byline);
                    if (repoList.results.get(i).multimedia.size() == 0) {
                        System.out.println("null");
                    } else {
                        System.out.println(repoList.results.get(i).multimedia.get(4).url);
                    }
                }
            }

            @Override
            public void onFailure(Call<Repo> call, Throwable t) {
                System.out.println("Hata deneme");
            }
        });

        //recyclerView = (RecyclerView) view.findViewById(R.id.recycler_news);
        //recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        //recyclerView.setHasFixedSize(true);
//
        //myAdapter = new NewsAdapter(getActivity().getApplicationContext(), Model.getDisplay_title());
        //recyclerView.setAdapter(myAdapter);

        return view;
    }
}
