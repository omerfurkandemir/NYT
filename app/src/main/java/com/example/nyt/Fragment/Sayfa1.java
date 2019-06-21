package com.example.nyt.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.nyt.Adapter.Adapter;
import com.example.nyt.Adapter.NumberAdapter;
import com.example.nyt.Model.Model;
import com.example.nyt.Parse.Parse;
import com.example.nyt.R;

import java.util.ArrayList;


public class Sayfa1 extends Fragment {
    private static final String TAG = "Sayfa1";

    private String url = "https://api.nytimes.com/svc/movies/v2/reviews/search.json?query=name&api-key=2hfqKd3QI7m64EKQ0LIDFCkFCIVrMZNe" ;
    RecyclerView recyclerView, number;
    private ArrayList<Model> mList = new ArrayList<>();

    private Adapter myAdapter;
    private NumberAdapter nmAdapter;

    EditText editText;
    Button search;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sayfa1, container, false);

        editText = (EditText) view.findViewById(R.id.edtext);
        search = (Button) view.findViewById(R.id.btn_searh);
        recyclerView = (RecyclerView) view.findViewById(R.id.main_list);
        number = (RecyclerView) view.findViewById(R.id.number_rv);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                url = "https://api.nytimes.com/svc/movies/v2/reviews/search.json?query=" + editText.getText() + "&api-key=2hfqKd3QI7m64EKQ0LIDFCkFCIVrMZNe" ;
                editText.setText("");
                mList.clear();
                vget();
            }
        });

        vget();
        SnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView (recyclerView);

        return view;
    }

    public void vget() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("snow", response.toString());
                Parse parse = new Parse(response);

                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
                recyclerView.setHasFixedSize(true);


                myAdapter = new Adapter(getActivity().getApplicationContext(), Model.getDisplay_title());
                recyclerView.setAdapter(myAdapter);

                number.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
                number.setHasFixedSize(true);

                nmAdapter = new NumberAdapter(getActivity().getApplicationContext(), Model.getDisplay_title());
                number.setAdapter(nmAdapter);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("snow", "onErrorResponse: " + error.getMessage().toString());
            }
        }) ;
        RequestQueue queue = Volley.newRequestQueue(getActivity().getApplicationContext());
        queue.add(stringRequest);
    }

}
