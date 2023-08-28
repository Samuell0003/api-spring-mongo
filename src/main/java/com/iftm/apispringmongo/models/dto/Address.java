package com.iftm.apispringmongo.models.dto;

public class Address {
    private String stree;
    private int number;
    private String city;
    private String country;

    public Address(int number, String city, String country) {
        this.number = number;
        this.city = city;
        this.country = country;
    }

    public Address() { }

    public String getStree() {
        return stree;
    }

    public void setStree(String stree) {
        this.stree = stree;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    
    
}
