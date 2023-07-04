package com.example.ashutosh_wheelseye;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements recycleinterface {
    RecyclerView recyclerView;
    ArrayList<Newsobjectd> dataArrayList=new ArrayList<>();
    NewsAdapter adapter;
    RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.wheelsnews);

        adapter =new NewsAdapter(MainActivity.this,dataArrayList,this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        dataArrayList = new ArrayList<>();
        requestQueue = Volley.newRequestQueue(this);

        parseJson();
    }

    private void parseJson() {


        String url = "https://newsapi.org/v2/everything?q=tesla&from=2023-06-04&sortBy=publishedAt&apiKey=9cdf39ba853d428e827ea47b2ed5f783";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url,null, new Response.Listener<JSONObject>() {


            @Override
            public void onResponse(JSONObject response) {
                try {
                    int results = response.getInt("totalResults");
                    Log.d("result", "Results found: " + results);

                    JSONArray newsArticles = response.getJSONArray("articles");

                    for (int i = 0; i < newsArticles.length(); i++) {
                        JSONObject article = newsArticles.getJSONObject(i);

                        String title = article.getString("title");
                        String description = article.getString("description");
                        String date = article.getString("publishedAt");
                        String urlToImage = article.getString("urlToImage");


                        dataArrayList.add(new Newsobjectd(urlToImage,title, description,"ashesnnn"));

                        Log.d("size_now", "onResponse: "+dataArrayList.size());
                        adapter =new NewsAdapter(MainActivity.this,dataArrayList,MainActivity.this);
                        recyclerView.setAdapter(adapter);
                    }

                } catch (JSONException e) {
                    Log.d("size_now", "onResponse: "+dataArrayList.size());
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Log.d("size_now", "onResponse: "+error.networkResponse.statusCode);
            }


        }){


            @Override
            public Map< String, String > getHeaders() throws AuthFailureError {
                HashMap< String, String > headers = new HashMap < String, String > ();
                //headers.put("Content-Type", "application/json");
                headers.put("Content-Type", "application/json; charset=UTF-8");
                headers.put("User-Agent", "Mozilla/5.0");
                return headers;
            }

        };
        requestQueue.add(jsonObjectRequest);
        requestQueue.getCache().clear();

    }


    @Override
    public void onNewsClicked(Newsobjectd newsobjectd) {
        Intent i = new Intent(this, SecondScreen.class);
        i.putExtra("sampleObject", newsobjectd);
        startActivity(i);
    }
}