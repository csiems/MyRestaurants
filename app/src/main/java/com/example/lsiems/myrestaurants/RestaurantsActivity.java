package com.example.lsiems.myrestaurants;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class RestaurantsActivity extends AppCompatActivity {
    @Bind(R.id.listView) ListView mListView;
    @Bind(R.id.locationTextView) TextView mLocationTextView;
    private String[] restaurants = new String[] { "Fire On The Mountain", "Burrito Azteca", "Po'Shines", "Posies'", "The Breakside", "Tin Shed Garden Cafe", "Bunk", "La Sirenita", "Fat Head's Brewery", "Eastside Deli", "Pizzicato", "Potbelly Sandwiches", "Flavour Spot" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String location = intent.getStringExtra("location");

        getRestaurants(location);
    }

    private void getRestaurants(String location) {
        final YelpService yelpService = new YelpService(this);

        yelpService.findRestaurants(location, new Callback() {
            @Override
            public void onFailure(Call call, IOException ioe) {
                ioe.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    String jsonData = response.body().string();
                    if (response.isSuccessful()) {
                        Log.v("JSON DATA", jsonData);
                    }
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        });
    }
}
