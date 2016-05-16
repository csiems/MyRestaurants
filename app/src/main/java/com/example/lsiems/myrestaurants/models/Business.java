package com.example.lsiems.myrestaurants.models;

import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Parcel
public class Business {

    public ArrayList<ArrayList<String>> categories = new ArrayList<>();
    public String displayPhone;
    public String id;
    public String imageUrl;
    public Boolean isClaimed;
    public Boolean isClosed;
    public Location location;
    public String mobileUrl;
    public String name;
    public String phone;
    public Double rating;
    public String ratingImgUrl;
    public String ratingImgUrlLarge;
    public String ratingImgUrlSmall;
    public Integer reviewCount;
    public String snippetImageUrl;
    public String snippetText;
    public String url;

    public Business() {
        //empty bean constructor
    }

    public Business(ArrayList<ArrayList<String>> categories, String displayPhone, String id, String imageUrl, Boolean isClaimed, Boolean isClosed, Location location, String mobileUrl, String name, String phone, Double rating, String ratingImgUrl, String ratingImgUrlLarge, String ratingImgUrlSmall, Integer reviewCount, String snippetImageUrl, String snippetText, String url) {
        this.categories = categories;
        this.displayPhone = displayPhone;
        this.id = id;
        this.imageUrl = imageUrl;
        this.isClaimed = isClaimed;
        this.isClosed = isClosed;
        this.location = location;
        this.mobileUrl = mobileUrl;
        this.name = name;
        this.phone = phone;
        this.rating = rating;
        this.ratingImgUrl = ratingImgUrl;
        this.ratingImgUrlLarge = ratingImgUrlLarge;
        this.ratingImgUrlSmall = ratingImgUrlSmall;
        this.reviewCount = reviewCount;
        this.snippetImageUrl = snippetImageUrl;
        this.snippetText = snippetText;
        this.url = url;
    }

    public ArrayList<ArrayList<String>> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<ArrayList<String>> categories) {
        this.categories = categories;
    }

    public String getDisplayPhone() {
        return displayPhone;
    }

    public void setDisplayPhone(String displayPhone) {
        this.displayPhone = displayPhone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Boolean getIsClaimed() {
        return isClaimed;
    }

    public void setIsClaimed(Boolean isClaimed) {
        this.isClaimed = isClaimed;
    }

    public Boolean getIsClosed() {
        return isClosed;
    }

    public void setIsClosed(Boolean isClosed) {
        this.isClosed = isClosed;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getMobileUrl() {
        return mobileUrl;
    }

    public void setMobileUrl(String mobileUrl) {
        this.mobileUrl = mobileUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getRatingImgUrl() {
        return ratingImgUrl;
    }

    public void setRatingImgUrl(String ratingImgUrl) {
        this.ratingImgUrl = ratingImgUrl;
    }

    public String getRatingImgUrlLarge() {
        return ratingImgUrlLarge;
    }

    public void setRatingImgUrlLarge(String ratingImgUrlLarge) {
        this.ratingImgUrlLarge = ratingImgUrlLarge;
    }

    public String getRatingImgUrlSmall() {
        return ratingImgUrlSmall;
    }

    public void setRatingImgUrlSmall(String ratingImgUrlSmall) {
        this.ratingImgUrlSmall = ratingImgUrlSmall;
    }

    public Integer getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(Integer reviewCount) {
        this.reviewCount = reviewCount;
    }

    public String getSnippetImageUrl() {
        return snippetImageUrl;
    }

    public void setSnippetImageUrl(String snippetImageUrl) {
        this.snippetImageUrl = snippetImageUrl;
    }

    public String getSnippetText() {
        return snippetText;
    }

    public void setSnippetText(String snippetText) {
        this.snippetText = snippetText;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
