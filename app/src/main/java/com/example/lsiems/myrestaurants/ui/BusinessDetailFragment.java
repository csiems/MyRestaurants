package com.example.lsiems.myrestaurants.ui;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lsiems.myrestaurants.MyRestaurantsApplication;
import com.example.lsiems.myrestaurants.R;
import com.example.lsiems.myrestaurants.models.Business;
import com.firebase.client.Firebase;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;

public class BusinessDetailFragment extends Fragment implements View.OnClickListener {
    private Firebase mFirebaseRef;
    private String mCurrentUserUid;
    private Business mBusiness;
    private static final int MAX_WIDTH = 400;
    private static final int MAX_HEIGHT = 300;
    @Bind(R.id.restaurantImageView) ImageView mImageLabel;
    @Bind(R.id.restaurantNameTextView) TextView mNameLabel;
    @Bind(R.id.cuisineTextView) TextView mCategoriesLabel;
    @Bind(R.id.ratingTextView) TextView mRatingLabel;
    @Bind(R.id.websiteTextView) TextView mWebsiteLabel;
    @Bind(R.id.phoneTextView) TextView mPhoneLabel;
    @Bind(R.id.addressTextView) TextView mAddressLabel;
    @Bind(R.id.saveRestaurantButton) TextView mSaveBusinessButton;


    public static BusinessDetailFragment newInstance(Business business) {
        BusinessDetailFragment businessDetailFragment = new BusinessDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("business", Parcels.wrap(business));
        businessDetailFragment.setArguments(args);
        return businessDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBusiness = Parcels.unwrap(getArguments().getParcelable("business"));
        mFirebaseRef = MyRestaurantsApplication.getAppInstance().getFirebaseRef();
        mCurrentUserUid = mFirebaseRef.getAuth().getUid();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_restaurant_detail, container, false);
        ButterKnife.bind(this, view);

        Picasso.with(view.getContext())
                .load(mBusiness.imageUrl)
                .resize(MAX_WIDTH, MAX_HEIGHT)
                .centerCrop()
                .into(mImageLabel);
        mNameLabel.setText(mBusiness.name);
        mCategoriesLabel.setText(android.text.TextUtils.join(", ", mBusiness.categories));
        mRatingLabel.setText(Double.toString(mBusiness.rating) + "/5");
        mPhoneLabel.setText(mBusiness.phone);
        mAddressLabel.setText(android.text.TextUtils.join(", ", mBusiness.location.address));

        mWebsiteLabel.setOnClickListener(this);
        mPhoneLabel.setOnClickListener(this);
        mAddressLabel.setOnClickListener(this);
        mSaveBusinessButton.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        if (v == mWebsiteLabel) {
            Intent webIntent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse(mBusiness.url));
            startActivity(webIntent);
        }
        if (v == mPhoneLabel) {
            Intent phoneIntent = new Intent(Intent.ACTION_DIAL,
                    Uri.parse("tel:" + mBusiness.getPhone()));
            startActivity(phoneIntent);
        }
        if (v == mAddressLabel) {
            Intent mapIntent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("geo:" + mBusiness.location.coordinate.latitude
                            + "," + mBusiness.location.coordinate.longitude
                            + "?q=(" + mBusiness.name + ")"));
            startActivity(mapIntent);
        }
        if (v == mSaveBusinessButton) {
            mFirebaseRef.child("businesses/" + mCurrentUserUid + "/"
                    + mBusiness.name).setValue(mBusiness);
            Toast.makeText(getContext(), "Saved", Toast.LENGTH_SHORT).show();
        }
    }
}
