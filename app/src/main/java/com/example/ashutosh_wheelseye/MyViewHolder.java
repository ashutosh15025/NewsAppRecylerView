package com.example.ashutosh_wheelseye;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {
   ImageView newsImage;
   TextView newsTitle;
   TextView newsHeading;
   public ConstraintLayout linear;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        newsImage=itemView.findViewById(R.id.thumbnail);
        newsTitle=itemView.findViewById(R.id.newstitle);
        newsHeading=itemView.findViewById(R.id.newsheading);
       linear=itemView.findViewById(R.id.mainlayout);

    }
}
