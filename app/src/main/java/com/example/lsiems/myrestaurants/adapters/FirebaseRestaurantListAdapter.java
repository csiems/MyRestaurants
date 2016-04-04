package com.example.lsiems.myrestaurants.adapters;

import android.support.v4.view.MotionEventCompat;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ViewGroup;

import com.example.lsiems.myrestaurants.MyRestaurantsApplication;
import com.example.lsiems.myrestaurants.R;
import com.example.lsiems.myrestaurants.models.Restaurant;
import com.example.lsiems.myrestaurants.util.FirebaseRecyclerAdapter;
import com.example.lsiems.myrestaurants.util.ItemTouchHelperAdapter;
import com.example.lsiems.myrestaurants.util.OnStartDragListener;
import com.firebase.client.Firebase;
import com.firebase.client.Query;
import android.view.View;

import java.util.Collections;

/**
 * Created by lsiems on 3/28/16.
 */
public class FirebaseRestaurantListAdapter extends FirebaseRecyclerAdapter<RestaurantViewHolder, Restaurant> implements ItemTouchHelperAdapter{

  private final OnStartDragListener mDragStartListener;

  public FirebaseRestaurantListAdapter(Query query, Class<Restaurant> itemClass, OnStartDragListener dragStartListener) {
    super(query, itemClass);
    mDragStartListener = dragStartListener;
  }

  @Override
  public RestaurantViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.restaurant_list_item_drag, parent, false);
    return new RestaurantViewHolder(view, getItems());
  }

  @Override
  public void onBindViewHolder(final RestaurantViewHolder holder, int position) {
    holder.bindRestaurant(getItem(position));
    holder.mRestaurantImageView.setOnTouchListener(new View.OnTouchListener() {

      @Override
      public boolean onTouch(View v, MotionEvent event) {
        if (MotionEventCompat.getActionMasked(event) == MotionEvent.ACTION_DOWN) {
          mDragStartListener.onStartDrag(holder);
        }
        return false;
      }
    });
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

  @Override
  public boolean onItemMove(int fromPosition, int toPosition) {
    Collections.swap(getItems(), fromPosition, toPosition);
    notifyItemMoved(fromPosition, toPosition);
    return true;
  }

  @Override
  public void onItemDismiss(int position) {
    Firebase ref = MyRestaurantsApplication.getAppInstance().getFirebaseRef();
    ref.child("restaurants/" + ref.getAuth().getUid() + "/" + getItem(position).getName()).removeValue();
  }
}