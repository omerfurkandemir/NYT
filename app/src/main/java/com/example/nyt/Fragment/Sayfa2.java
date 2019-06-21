package com.example.nyt.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nyt.Adapter.Adapter;
import com.example.nyt.Adapter.NewsAdapter;
import com.example.nyt.Model.Model;
import com.example.nyt.Model.News_Model;
import com.example.nyt.R;
import com.example.nyt.Retrofit.ApiClient;
import com.example.nyt.Retrofit.Repo;
import com.example.nyt.Retrofit.RestInterface;
import com.example.nyt.Retrofit.Result;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Sayfa2 extends Fragment {
    private static final String TAG = "Sayfa2";
   public ArrayList<News_Model> mList;

    RestInterface restInterface;

    RecyclerView recyclerView;
    private NewsAdapter myAdapter;

    ArrayList<String> section = new ArrayList<>();
    ArrayList<String> title = new ArrayList<>();
    ArrayList<String> byline = new ArrayList<>();
    ArrayList<String> url = new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sayfa2, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_news);

        restInterface = ApiClient.getClient().create(RestInterface.class);
        Call<Repo> call = restInterface.getRepo("svc/topstories/v2/science.json?api-key=2hfqKd3QI7m64EKQ0LIDFCkFCIVrMZNe");

        call.enqueue(new Callback<Repo>() {
            @Override
            public void onResponse(Call<Repo> call, Response<Repo> response) {

                Repo repoList = new Repo();

                repoList = response.body();

                for (int i = 0; i < repoList.results.size(); i++) {
                    section.add(repoList.results.get(i).section);
                    title.add(repoList.results.get(i).title);
                    byline.add(repoList.results.get(i).byline);
                    News_Model.setSection(section);
                    News_Model.setTitle(title);
                    News_Model.setByline(byline);

                    recyclerView.setLayoutManager(new GridLayoutManager(getActivity().getApplicationContext(), 1));
                    recyclerView.setHasFixedSize(true);

                    myAdapter = new NewsAdapter(getActivity().getApplicationContext(), News_Model.getSection());
                    recyclerView.setAdapter(myAdapter);
                    if (repoList.results.get(i).multimedia.size() == 0) {
                        url.add("null");
                        News_Model.setUrl(url);
                    } else {
                        url.add(repoList.results.get(i).multimedia.get(3).url);
                        News_Model.setUrl(url);
                    }
                }
            }

            @Override
            public void onFailure(Call<Repo> call, Throwable t) {
                System.out.println("Hata deneme");
            }
        });

        return view;
    }
}
