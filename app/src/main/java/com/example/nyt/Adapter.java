package com.example.nyt;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private Context ctx;
    private ArrayList<String> nList;
    private MySingleton mySingleton;
    private ImageLoader mImageLoader;


    public Adapter(Context ctx, ArrayList<String> nList) {
        this.ctx = ctx;
        this.nList = nList;
        mySingleton = MySingleton.getInstance(ctx);
        mImageLoader = mySingleton.getImageLoader();
    }

    @NonNull
    @Override
    public Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(ctx.getApplicationContext()).inflate(R.layout.single_item,viewGroup,false);

        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, final int i) {

        final String model = nList.get(i);

        ArrayList<String> headline = Model.getHeadline();
        ArrayList<String> byline = Model.getByline();
        ArrayList<String> date = Model.getPublication_date();
        final ArrayList<String> img = Model.getSrc();

        myViewHolder.title.setText(headline.get(i));
        myViewHolder.byline.setText(byline.get(i));
        myViewHolder.date.setText(date.get(i));

        String img_url = img.get(i);

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