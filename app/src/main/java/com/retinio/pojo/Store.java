package com.retinio.pojo;

/**
 * Created by prempal on 30/3/16.
 */
public class Store {

    private String name;
    private String rating;
    private String address;
    private String latitude;
    private String longitude;
    private String offer;
    private String imageURL;
    private boolean offerAvailable;
    private boolean docAvailable;
    private boolean buyAvailable;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getOffer() {
        return offer;
    }

    public void setOffer(String offer) {
        this.offer = offer;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public boolean isOfferAvailable() {
        return offerAvailable;
    }

    public void setOfferAvailable(boolean offerAvailable) {
        this.offerAvailable = offerAvailable;
    }

    public boolean isDocAvailable() {
        return docAvailable;
    }

    public void setDocAvailable(boolean docAvailable) {
        this.docAvailable = docAvailable;
    }

    public boolean isBuyAvailable() {
        return buyAvailable;
    }

    public void setBuyAvailable(boolean buyAvailable) {
        this.buyAvailable = buyAvailable;
    }
}
