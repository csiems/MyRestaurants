package com.example.lsiems.myrestaurants.services;

import com.example.lsiems.myrestaurants.models.SearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface YelpAPI {
    @GET("/v2/search")
    Call<SearchResponse> search(
            @Query("term") String term,
            @Query("location") String location
    );
}
