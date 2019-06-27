package com.example.nyt.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.transition.Slide;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.example.nyt.Model.Model;
import com.example.nyt.MySingleton;
import com.example.nyt.R;

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

        View view = LayoutInflater.from(ctx.getApplicationContext()).inflate(R.layout.single_item, viewGroup, false);

        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @SuppressLint("ResourceAsColor")
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

        if (img_url != null) {
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
        if (i == 0) {
            myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    cagir(myViewHolder, i);
                }
            });
            myViewHolder.number1.setBackgroundResource(R.drawable.bg1);
            myViewHolder.number6.setBackgroundResource(R.drawable.bg);
        } else if (i == 1) {
            myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    cagir(myViewHolder, i);
                }
            });
            myViewHolder.number2.setBackgroundResource(R.drawable.bg1);
            myViewHolder.number7.setBackgroundResource(R.drawable.bg);
        } else if (i == 2) {
            myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    cagir(myViewHolder, i);
                }
            });
            myViewHolder.number3.setBackgroundResource(R.drawable.bg1);
            myViewHolder.number8.setBackgroundResource(R.drawable.bg);
        } else if (i == 3) {
            myViewHolder.number4.setBackgroundResource(R.drawable.bg1);
            myViewHolder.number9.setBackgroundResource(R.drawable.bg);
        } else if (i == 4) {
            myViewHolder.number5.setBackgroundResource(R.drawable.bg1);
            myViewHolder.number10.setBackgroundResource(R.drawable.bg);
        } else if (i == 5) {
            myViewHolder.number6.setBackgroundResource(R.drawable.bg1);
            myViewHolder.number1.setBackgroundResource(R.drawable.bg);
        } else if (i == 6) {
            myViewHolder.number7.setBackgroundResource(R.drawable.bg1);
            myViewHolder.number2.setBackgroundResource(R.drawable.bg);
        } else if (i == 7) {
            myViewHolder.number8.setBackgroundResource(R.drawable.bg1);
            myViewHolder.number3.setBackgroundResource(R.drawable.bg);
        } else if (i == 8) {
            myViewHolder.number9.setBackgroundResource(R.drawable.bg1);
            myViewHolder.number4.setBackgroundResource(R.drawable.bg);
        } else if (i == 9) {
            myViewHolder.number10.setBackgroundResource(R.drawable.bg1);
            myViewHolder.number5.setBackgroundResource(R.drawable.bg);
        }

        //switch (i) {
        //   // case 0:
        //   //
        //   // case 1:
        //   //     myViewHolder.number2.setBackgroundResource(R.drawable.bg1);
        //   // case 2:
        //   //     myViewHolder.number3.setBackgroundResource(R.drawable.bg1);
        //   // case 3:
        //   //     myViewHolder.number4.setBackgroundResource(R.drawable.bg1);
        //   // case 4:
        //   //     myViewHolder.number5.setBackgroundResource(R.drawable.bg1);
        //    case 5:
        //        myViewHolder.number6.setBackgroundResource(R.drawable.bg1);
        //    case 6:
        //        myViewHolder.number7.setBackgroundResource(R.drawable.bg1);
        //    case 7:
        //        myViewHolder.number8.setBackgroundResource(R.drawable.bg1);
        //    case 8:
        //        myViewHolder.number9.setBackgroundResource(R.drawable.bg1);
        //    case 9:
        //        myViewHolder.number10.setBackgroundResource(R.drawable.bg1);
        //}
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView title, byline, date;
        private ImageView image;
        private TextView number1, number2, number3, number4, number5, number6, number7, number8, number9, number10;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.main_title);
            byline = (TextView) itemView.findViewById(R.id.byline);
            date = (TextView) itemView.findViewById(R.id.date);
            image = (ImageView) itemView.findViewById(R.id.image);

            number1 = (TextView) itemView.findViewById(R.id.number1);
            number2 = (TextView) itemView.findViewById(R.id.number2);
            number3 = (TextView) itemView.findViewById(R.id.number3);
            number4 = (TextView) itemView.findViewById(R.id.number4);
            number5 = (TextView) itemView.findViewById(R.id.number5);
            number6 = (TextView) itemView.findViewById(R.id.number6);
            number7 = (TextView) itemView.findViewById(R.id.number7);
            number8 = (TextView) itemView.findViewById(R.id.number8);
            number9 = (TextView) itemView.findViewById(R.id.number9);
            number10 = (TextView) itemView.findViewById(R.id.number10);

        }
    }

    public int cagir(@NonNull final MyViewHolder myViewHolder, final int i){
        final String model = nList.get(i);

        ArrayList<String> headline = Model.getHeadline();
        ArrayList<String> byline = Model.getByline();
        ArrayList<String> date = Model.getPublication_date();
        final ArrayList<String> img = Model.getSrc();

        myViewHolder.title.setText(headline.get(i));
        myViewHolder.byline.setText(byline.get(i));
        myViewHolder.date.setText(date.get(i));

        String img_url = img.get(i);

        if (img_url != null) {
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
        return i;
    }
}