package com.iyengarcoders.groceries.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.*;

// This table may chnage in future.
@Entity
@Table(name = "user_profile")
public class UserProfile {

//    @Id
//    @GeneratedValue(generator = "uuid")
//    @GenericGenerator(name = "uuid", strategy = "uuid2")
//    @Column(name="id")
//    private String id;

    @Id
    @Column(name = "username",length = 50, nullable = false)
    private String username;

    @Embedded
    private Name name;
    @Column(name="cell_phone")
    private String cellPhone;
    @Column(name="home_phone")
    private String homePhone;

    @Column(name="email_address")
    private String emailAddress;


    // TODO: maybe this is not needed here.
    @OneToMany(mappedBy = "userProfile", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ShippingAddress> shippingAddresses = new ArrayList<>();

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Order> orders = new ArrayList<>();

    @OneToOne(mappedBy = "customer")
    private Cart cart;

    public UserProfile() {
    }

    public UserProfile(String username, Name name, String cellPhone, String homePhone, String emailAddress) {
        this.username = username;
        this.name = name;
        this.cellPhone = cellPhone;
        this.homePhone = homePhone;
        this.emailAddress = emailAddress;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public List<ShippingAddress> getShippingAddresses() {
        return shippingAddresses;
    }

    public void setShippingAddresses(List<ShippingAddress> shippingAddresses) {
        this.shippingAddresses = shippingAddresses;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public void addAddress(ShippingAddress address) {
        shippingAddresses.add(address);
        address.setUserProfile(this);
    }

    public void removeAddress(ShippingAddress address) {
        shippingAddresses.remove(address);
        address.setUserProfile(null);
    }
}
