package com.example.lsiems.myrestaurants.models;

import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Parcel
public class Location {

    public ArrayList<String> address = new ArrayList<>();
    public String city;
    public Coordinate coordinate;
    public String countryCode;
    public String crossStreets;
    public ArrayList<String> displayAddress = new ArrayList<>();
    public Double geoAccuracy;
    public ArrayList<String> neighborhoods = new ArrayList<>();
    public String postalCode;
    public String stateCode;

    public Location() {
        //empty bean constructor
    }

    public Location(ArrayList<String> address, String city, Coordinate coordinate, String countryCode, String crossStreets, ArrayList<String> displayAddress, Double geoAccuracy, ArrayList<String> neighborhoods, String postalCode, String stateCode) {
        this.address = address;
        this.city = city;
        this.coordinate = coordinate;
        this.countryCode = countryCode;
        this.crossStreets = crossStreets;
        this.displayAddress = displayAddress;
        this.geoAccuracy = geoAccuracy;
        this.neighborhoods = neighborhoods;
        this.postalCode = postalCode;
        this.stateCode = stateCode;
    }

    public ArrayList<String> getAddress() {
        return address;
    }

    public void setAddress(ArrayList<String> address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCrossStreets() {
        return crossStreets;
    }

    public void setCrossStreets(String crossStreets) {
        this.crossStreets = crossStreets;
    }

    public ArrayList<String> getDisplayAddress() {
        return displayAddress;
    }

    public void setDisplayAddress(ArrayList<String> displayAddress) {
        this.displayAddress = displayAddress;
    }

    public Double getGeoAccuracy() {
        return geoAccuracy;
    }

    public void setGeoAccuracy(Double geoAccuracy) {
        this.geoAccuracy = geoAccuracy;
    }

    public ArrayList<String> getNeighborhoods() {
        return neighborhoods;
    }

    public void setNeighborhoods(ArrayList<String> neighborhoods) {
        this.neighborhoods = neighborhoods;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

}
