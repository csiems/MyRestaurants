package com.example.lsiems.myrestaurants.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lsiems.myrestaurants.R;
import com.example.lsiems.myrestaurants.models.Business;
import com.example.lsiems.myrestaurants.ui.BusinessDetailActivity;
import com.example.lsiems.myrestaurants.util.ItemTouchHelperViewHolder;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class BusinessViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, ItemTouchHelperViewHolder {
  private static final int MAX_WIDTH = 200;
  private static final int MAX_HEIGHT = 200;
  @Bind(R.id.restaurantImageView) ImageView mRestaurantImageView;
  @Bind(R.id.restaurantNameTextView) TextView mNameTextView;
  @Bind(R.id.categoryTextView) TextView mCategoryTextView;
  @Bind(R.id.ratingTextView) TextView mRatingTextView;
  private Context mContext;
  List<Business> mBusinesses = new ArrayList<>();

  public BusinessViewHolder(View itemView, List<Business> businesses) {
    super(itemView);
    ButterKnife.bind(this, itemView);
    mContext = itemView.getContext();
    mBusinesses = businesses;
    itemView.setOnClickListener(this);
  }

  @Override
  public void onClick(View v) {
    Intent intent = new Intent(mContext, BusinessDetailActivity.class);
    intent.putExtra("position", getLayoutPosition() + "");
    intent.putExtra("businesses", Parcels.wrap(mBusinesses));
    mContext.startActivity(intent);
  }

  public void bindBusiness(Business business) {
    Picasso.with(mContext)
            .load(business.imageUrl)
            .resize(MAX_WIDTH, MAX_HEIGHT)
            .centerCrop()
            .into(mRestaurantImageView);
    mNameTextView.setText(business.getName());
    mCategoryTextView.setText(business.getCategories().get(0).toString());
    mRatingTextView.setText("Rating: " + business.getRating() + "/5");
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
