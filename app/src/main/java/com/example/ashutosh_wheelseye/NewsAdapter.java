package com.example.ashutosh_wheelseye;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Response;
import com.bumptech.glide.Glide;

import org.json.JSONObject;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<MyViewHolder> {
    Context context;
    ArrayList<Newsobjectd>News;

    public NewsAdapter(Context context, ArrayList<Newsobjectd> news, recycleinterface listener) {
        this.context = context;
        News = news;
        this.listener = listener;
    }

    recycleinterface listener;



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.newsframe,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.newsTitle.setText(News.get(position).getNewsTitle());
        holder.newsHeading.setText(News.get(position).getNewstext());

       Glide.with(holder.itemView.getContext()).load(News.get(position).image).into(holder.newsImage);
      holder.linear.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              listener.onNewsClicked(News.get(position));
          }
      });
    }

    @Override
    public int getItemCount() {


        return News.size();
    }

}
