package com.example.lsiems.myrestaurants.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.lsiems.myrestaurants.R;
import com.example.lsiems.myrestaurants.models.Restaurant;
import com.example.lsiems.myrestaurants.util.FirebaseRecyclerAdapter;
import com.firebase.client.Query;
import com.firebase.client.core.view.View;

/**
 * Created by lsiems on 3/28/16.
 */
public class FirebaseRestaurantListAdapter extends FirebaseRecyclerAdapter<RestaurantViewHolder, Restaurant> {

  public FirebaseRestaurantListAdapter(Query query, Class<Restaurant> itemClass) {
    super(query, itemClass);
  }

  @Override
  public RestaurantViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
  View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.restaurant_list_item, parent, false);
    return new RestaurantViewHolder(view, getItems());
  }

  @Override
  public void onBindViewHolder(RestaurantViewHolder holder, int position) {
    holder.bindRestaurant(getItem(position));
  }

  @Override
  protected void itemAdded(Restaurant item, String key, int position) {

  }

  @Override
  protected void itemChanged(Restaurant oldItem, Restaurant newItem, String key, int position) {

  }

  @Override
  protected void itemRemoved(Restaurant item, String key, int position) {

  }

  @Override
  protected void itemMoved(Restaurant item, String key, int oldPosition, int newPosition) {

  }
}