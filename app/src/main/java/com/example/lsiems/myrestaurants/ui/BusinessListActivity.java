package com.example.lsiems.myrestaurants.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.lsiems.myrestaurants.BuildConfig;
import com.example.lsiems.myrestaurants.MyRestaurantsApplication;
import com.example.lsiems.myrestaurants.R;
import com.example.lsiems.myrestaurants.adapters.BusinessListAdapter;
import com.example.lsiems.myrestaurants.models.Business;
import com.example.lsiems.myrestaurants.models.SearchResponse;
import com.example.lsiems.myrestaurants.services.YelpAPI;
import com.example.lsiems.myrestaurants.services.YelpAPIFactory;
import com.firebase.client.Firebase;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class BusinessListActivity extends AppCompatActivity {
  public static final String TAG = MainActivity.class.getSimpleName();
  final String YELP_CONSUMER_KEY = BuildConfig.YELP_CONSUMER_KEY;
  final String YELP_CONSUMER_SECRET = BuildConfig.YELP_CONSUMER_SECRET;
  final String YELP_TOKEN = BuildConfig.YELP_TOKEN;
  final String YELP_TOKEN_SECRET = BuildConfig.YELP_TOKEN_SECRET;
  @Bind(R.id.recyclerView) RecyclerView mRecyclerView;
  private BusinessListAdapter mAdapter;
  public ArrayList<Business> mBusinesses = new ArrayList<>();
  private SharedPreferences mSharedPreferences;
  private SharedPreferences.Editor mEditor;
  private String mRecentAddress;
  private Firebase mFirebaseRef;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_restaurants);
    ButterKnife.bind(this);

    mFirebaseRef = MyRestaurantsApplication.getAppInstance().getFirebaseRef();
    mSharedPreferences = this.getSharedPreferences(getString(R.string.preference_file_key),
            Context.MODE_PRIVATE);
    mRecentAddress = mSharedPreferences.getString("location", null);
    mEditor = mSharedPreferences.edit();

    if (mRecentAddress != null) {
      getRestaurants(mRecentAddress);
    }

  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.menu_search, menu);
    ButterKnife.bind(this);

    MenuItem menuItem = menu.findItem(R.id.action_search);
    SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);

    searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
      @Override
      public boolean onQueryTextSubmit(String query) {
        addToSharedPreferences(query);
        getRestaurants(query);
        return false;
      }

      @Override
      public boolean onQueryTextChange(String newText) {
        return false;
      }
    });
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case R.id.action_logout:
        this.logout();
        return true;
    }
    return super.onOptionsItemSelected(item);
  }

  private void addToSharedPreferences(String location) {
    mEditor.putString("location", location).commit();
  }

  private void logout() {
    mFirebaseRef.unauth();
    Intent intent = new Intent(this, LoginActivity.class);
    startActivity(intent);
  }


  private void getRestaurants(String location) {
    String term = "food";
    YelpAPIFactory apiFactory = new YelpAPIFactory(YELP_CONSUMER_KEY, YELP_CONSUMER_SECRET, YELP_TOKEN, YELP_TOKEN_SECRET);
    YelpAPI yelpAPI = apiFactory.createAPI();
    retrofit2.Call<SearchResponse> call = yelpAPI.search(term, location);
    retrofit2.Callback<SearchResponse> callback = new retrofit2.Callback<SearchResponse>() {
      @Override
      public void onResponse(retrofit2.Call<SearchResponse> call, retrofit2.Response<SearchResponse> response) {
        SearchResponse searchResponse = response.body();
        mBusinesses = searchResponse.getBusinesses();

        BusinessListActivity.this.runOnUiThread(new Runnable() {
          @Override
          public void run() {
            mAdapter = new BusinessListAdapter(getApplicationContext(), mBusinesses);
            mRecyclerView.setAdapter(mAdapter);
            RecyclerView.LayoutManager layoutManager =
                    new LinearLayoutManager(BusinessListActivity.this);
            mRecyclerView.setLayoutManager(layoutManager);
            mRecyclerView.setHasFixedSize(true);
          }
        });

      }
      @Override
      public void onFailure(retrofit2.Call<SearchResponse> call, Throwable t) {
        Log.d(TAG, t.toString());
      }
    };
    call.enqueue(callback);

  }
}
