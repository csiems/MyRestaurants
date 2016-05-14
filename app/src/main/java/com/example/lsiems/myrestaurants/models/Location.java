package com.example.lsiems.myrestaurants.models;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Location {

    private List<String> address = new ArrayList<String>();
    private String city;
    private Coordinate coordinate;
    private String countryCode;
    private String crossStreets;
    private List<String> displayAddress = new ArrayList<String>();
    private Double geoAccuracy;
    private List<String> neighborhoods = new ArrayList<String>();
    private String postalCode;
    private String stateCode;
    private Map<String, Object> additionalProperties = new HashMap<>();

    public Location(List<String> address, String city, Coordinate coordinate, String countryCode, String crossStreets, List<String> displayAddress, Double geoAccuracy, List<String> neighborhoods, String postalCode, String stateCode, Map<String, Object> additionalProperties) {
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
        this.additionalProperties = additionalProperties;
    }

    public List<String> getAddress() {
        return address;
    }

    public void setAddress(List<String> address) {
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

    public List<String> getDisplayAddress() {
        return displayAddress;
    }

    public void setDisplayAddress(List<String> displayAddress) {
        this.displayAddress = displayAddress;
    }

    public Double getGeoAccuracy() {
        return geoAccuracy;
    }

    public void setGeoAccuracy(Double geoAccuracy) {
        this.geoAccuracy = geoAccuracy;
    }

    public List<String> getNeighborhoods() {
        return neighborhoods;
    }

    public void setNeighborhoods(List<String> neighborhoods) {
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

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
