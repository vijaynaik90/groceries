package com.iyengarcoders.groceries.dto;

import java.util.List;

public class UserProfileDto {
    private String username;
    private String firstName;
    private String middleName;
    private String lastName;
    private String emailAddress;
    private String cellPhone;
    private String homePhone;
    private List<ShippingAddressDto> shippingAddresses;

    public UserProfileDto() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public List<ShippingAddressDto> getShippingAddresses() {
        return shippingAddresses;
    }

    public void setShippingAddresses(List<ShippingAddressDto> shippingAddresses) {
        this.shippingAddresses = shippingAddresses;
    }
}

