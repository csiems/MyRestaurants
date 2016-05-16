package com.example.lsiems.myrestaurants.models;

import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Parcel
public class SearchResponse {

    public ArrayList<Business> businesses = new ArrayList<>();
    public Integer total;

    public SearchResponse() {
        //empty bean constructor for Parcel
    }

    public SearchResponse(ArrayList<Business> businesses, Integer total) {
        this.businesses = businesses;
        this.total = total;
    }

    public ArrayList<Business> getBusinesses() {
        return businesses;
    }

    public void setBusinesses(ArrayList<Business> businesses) {
        this.businesses = businesses;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

}
