package com.example.lsiems.myrestaurants.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.lsiems.myrestaurants.models.Business;
import com.example.lsiems.myrestaurants.ui.BusinessDetailFragment;

import java.util.ArrayList;

public class BusinessPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Business> mBusinesses;

    public BusinessPagerAdapter(FragmentManager fm, ArrayList<Business> businesses) {
        super(fm);
        mBusinesses = businesses;
    }

    @Override
    public Fragment getItem(int position) {
        return BusinessDetailFragment.newInstance(mBusinesses.get(position));
    }

    @Override
    public int getCount() {
        return mBusinesses.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mBusinesses.get(position).getName();
    }
}
