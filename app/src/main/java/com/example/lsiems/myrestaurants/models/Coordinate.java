package com.example.lsiems.myrestaurants.models;

import org.parceler.Parcel;

import java.util.HashMap;
import java.util.Map;

@Parcel
public class Coordinate {

    public Double latitude;
    public Double longitude;
//    public Map<String, Object> additionalProperties = new HashMap<>();

    public Coordinate()  {
        //empty bean constructor for Parcel
    }

    public Coordinate(Double latitude, Double longitude, Map<String, Object> additionalProperties) {
        this.latitude = latitude;
        this.longitude = longitude;
//        this.additionalProperties = additionalProperties;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

//    public Map<String, Object> getAdditionalProperties() {
//        return this.additionalProperties;
//    }
//
//    public void setAdditionalProperty(String name, Object value) {
//        this.additionalProperties.put(name, value);
//    }

}