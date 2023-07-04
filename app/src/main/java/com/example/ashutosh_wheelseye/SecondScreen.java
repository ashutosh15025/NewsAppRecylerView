package com.example.ashutosh_wheelseye;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.audiofx.AudioEffect;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class SecondScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen);
        Intent i = getIntent();
        Newsobjectd obj = (Newsobjectd) i.getSerializableExtra("sampleObject");
        ImageView image=findViewById(R.id.rowimage);
        TextView  title=findViewById(R.id.rowtitle);
        TextView  desc=findViewById(R.id.rowdescription);

        Glide.with(this)

                .load(
                        obj.image
                )

                .into(image);


        title.setText(obj.getNewsTitle().toString());
        desc.setText(obj.getNewstext().toString());
    }
}