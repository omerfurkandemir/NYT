package com.example.nyt.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.example.nyt.Model.News_Model;
import com.example.nyt.MySingleton;
import com.example.nyt.R;

import java.util.ArrayList;

public class NumberAdapter extends RecyclerView.Adapter<NumberAdapter.MyViewHolder> {

    private Context ctx;
    private ArrayList<String> nList;
    private MySingleton mySingleton;
    private ImageLoader mImageLoader;


    public NumberAdapter(Context ctx, ArrayList<String> nList) {
        this.ctx = ctx;
        this.nList = nList;
        mySingleton = MySingleton.getInstance(ctx);
        mImageLoader = mySingleton.getImageLoader();
    }

    @NonNull
    @Override
    public NumberAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(ctx.getApplicationContext()).inflate(R.layout.number,viewGroup,false);

        NumberAdapter.MyViewHolder myViewHolder = new NumberAdapter.MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final NumberAdapter.MyViewHolder myViewHolder, final int i) {

        //final String model = nList.get(i);

        ArrayList<String> section = News_Model.getSection();

        myViewHolder.title.setText(String.valueOf(i));

    }

    @Override
    public int getItemCount() {
        return nList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView title, byline, date;
        private ImageView image;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.number1);

        }
    }
}
