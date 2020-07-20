package com.iyengarcoders.groceries.entity;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.Objects;

import static com.iyengarcoders.groceries.utils.Constants.AddressType;

@Embeddable
public class Address {

//    @Id
//    @GeneratedValue(strategy=GenerationType.AUTO)
//    @Column(name="id")
//    private Long id;


//    @Enumerated(EnumType.STRING)
//    @Column(name = "address_type")
//    private AddressType addressType = AddressType.DEFAULT;

    @NotNull
    @Size(min = 5, max = 100)
    @Column(name = "line1")
    private String line1;

    @Size(min=5, max = 50)
    @Column(name = "line2")
    private String line2;

    @NotNull
    @Size(max = 50)
    @Column(name = "city")
    private String city;

    @NotNull
    @Size(max = 50)
    @Column(name = "state")
    private String state;

    @NotNull
    @Size(max = 50)
    @Column(name = "country")
    private String country;

    @NotNull
    @Size(max = 6)
    @Column(name = "zip_code")
    private String zipCode;

//    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id", nullable = false)
//    private User user;

    @Column(name = "last_used")
    private Boolean lastUsed = false;

    public Address() {
    }

    public Address(@NotNull @Size(min = 5, max = 100) String line1, @Size(min = 5, max = 100) String line2, @NotNull @Size(max = 100) String city, @NotNull @Size(max = 100) String state, @NotNull @Size(max = 100) String country, @NotNull @Size(max = 6) String zipCode, Boolean lastUsed) {
//        this.addressType = addressType;
        this.line1 = line1;
        this.line2 = line2;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipCode = zipCode;
        this.lastUsed = lastUsed;
    }

//    public Long getId() {
//        return id;
//    }

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

//    public AddressType getAddressType() {
//        return addressType;
//    }
//
//    public void setAddressType(AddressType addressType) {
//        this.addressType = addressType;
//    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }

    public Boolean getLastUsed() {
        return lastUsed;
    }

    public void setLastUsed(Boolean lastUsed) {
        this.lastUsed = lastUsed;
    }
}
