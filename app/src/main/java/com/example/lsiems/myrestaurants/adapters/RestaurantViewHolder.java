package com.example.lsiems.myrestaurants.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lsiems.myrestaurants.R;
import com.example.lsiems.myrestaurants.models.Restaurant;
import com.example.lsiems.myrestaurants.ui.RestaurantDetailActivity;
import com.example.lsiems.myrestaurants.util.ItemTouchHelperViewHolder;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by lsiems on 3/28/16.
 */
public class RestaurantViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, ItemTouchHelperViewHolder {
  private static final int MAX_WIDTH = 200;
  private static final int MAX_HEIGHT = 200;
  @Bind(R.id.restaurantImageView) ImageView mRestaurantImageView;
  @Bind(R.id.restaurantNameTextView) TextView mNameTextView;
  @Bind(R.id.categoryTextView) TextView mCategoryTextView;
  @Bind(R.id.ratingTextView) TextView mRatingTextView;
  private Context mContext;
  ArrayList<Restaurant> mRestaurants = new ArrayList<>();

  public RestaurantViewHolder(View itemView, ArrayList<Restaurant> restaurants) {
    super(itemView);
    ButterKnife.bind(this, itemView);
    mContext = itemView.getContext();
    mRestaurants = restaurants;
    itemView.setOnClickListener(this);
  }

  @Override
  public void onClick(View v) {
    Intent intent = new Intent(mContext, RestaurantDetailActivity.class);
    intent.putExtra("position", getLayoutPosition() + "");
    intent.putExtra("restaurants", Parcels.wrap(mRestaurants));
    mContext.startActivity(intent);
  }

  public void bindRestaurant(Restaurant restaurant) {
    Picasso.with(mContext)
            .load(restaurant.getImageUrl())
            .resize(MAX_WIDTH, MAX_HEIGHT)
            .centerCrop()
            .into(mRestaurantImageView);
    mNameTextView.setText(restaurant.getName());
    mCategoryTextView.setText(restaurant.getCategories().get(0));
    mRatingTextView.setText("Rating: " + restaurant.getRating() + "/5");
  }

  @Override
  public void onItemSelected() {
    itemView.animate()
            .alpha(0.7f)
            .scaleX(0.9f)
            .scaleY(0.9f)
            .setDuration(500);
  }

  @Override
  public void onItemClear() {
    itemView.animate()
            .alpha(1f)
            .scaleX(1f)
            .scaleY(1f);
  }
}