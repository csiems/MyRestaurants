package com.example.lsiems.myrestaurants.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lsiems.myrestaurants.R;
import com.example.lsiems.myrestaurants.models.Business;

import java.util.ArrayList;

/**
 * Created by Guest on 3/22/16.
 */
public class BusinessListAdapter extends RecyclerView.Adapter<BusinessViewHolder> {
    private ArrayList<Business> mBusinesses = new ArrayList<>();
    private Context mContext;

    public BusinessListAdapter(Context context, ArrayList<Business> restaurants) {
        mContext = context;
        mBusinesses = restaurants;
    }

    @Override
    public BusinessViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.restaurant_list_item, parent, false);
        BusinessViewHolder viewHolder = new BusinessViewHolder(view, mBusinesses);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(BusinessViewHolder holder, int position) {
        holder.bindBusiness(mBusinesses.get(position));
    }

    @Override
    public int getItemCount() {
        return mBusinesses.size();
    }
}


