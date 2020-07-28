package com.iyengarcoders.groceries.dto;

public class ShippingAddressDto {
    private String addressId;

    private String line1;

    private String line2;

    private String city;

    private String state;

    private String country;

    private String zipCode;

    private Boolean lastUsed;

    public ShippingAddressDto() {
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Boolean getLastUsed() {
        return lastUsed;
    }

    public void setLastUsed(Boolean lastUsed) {
        this.lastUsed = lastUsed;
    }
}
