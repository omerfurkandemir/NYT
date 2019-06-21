package com.example.nyt.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.example.nyt.Fragment.Sayfa2;
import com.example.nyt.Model.Model;
import com.example.nyt.Model.News_Model;
import com.example.nyt.MySingleton;
import com.example.nyt.R;
import com.example.nyt.Retrofit.Repo;
import com.example.nyt.Retrofit.Result;

import java.util.ArrayList;
import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyViewHolder> {

    private Context ctx;
    private ArrayList<String> nList;
    private MySingleton mySingleton;
    private ImageLoader mImageLoader;


    public NewsAdapter(Context ctx, ArrayList<String> nList) {
        this.ctx = ctx;
        this.nList = nList;
        mySingleton = MySingleton.getInstance(ctx);
        mImageLoader = mySingleton.getImageLoader();
    }

    @NonNull
    @Override
    public NewsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(ctx.getApplicationContext()).inflate(R.layout.news_item,viewGroup,false);

        NewsAdapter.MyViewHolder myViewHolder = new NewsAdapter.MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final NewsAdapter.MyViewHolder myViewHolder, final int i) {

        //final String model = nList.get(i);

        ArrayList<String> section = News_Model.getSection();
        ArrayList<String> title = News_Model.getTitle();
        ArrayList<String> byline = News_Model.getByline();
        final ArrayList<String> img = News_Model.getUrl();

        myViewHolder.title.setText(title.get(i));
        myViewHolder.byline.setText(byline.get(i));
        myViewHolder.date.setText(section.get(i));

        final String img_url = img.get(i);

        if(img_url!= null){
            mImageLoader.get(img_url, new ImageLoader.ImageListener() {
                @Override
                public void onResponse(ImageLoader.ImageContainer response, boolean isImmediate) {
                        myViewHolder.image.setImageBitmap(response.getBitmap());
                }

                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });
        }

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

            title = (TextView) itemView.findViewById(R.id.main_title);
            byline = (TextView) itemView.findViewById(R.id.byline);
            date = (TextView) itemView.findViewById(R.id.date);
            image = (ImageView) itemView.findViewById(R.id.image);

        }
    }
}
