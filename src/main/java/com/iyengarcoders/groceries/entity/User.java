package com.iyengarcoders.groceries.entity;

import javax.persistence.*;
import java.util.*;

// This table may chnage in future.
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue
    @Column(name="id")
    private UUID id;

    @Column(name="username")
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
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Address> addresses = new HashSet<>();

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Order> orders = new ArrayList<>();


    public User() {
    }

    public User(String username, Name name, String cellPhone, String homePhone, String emailAddress) {
        this.username = username;
        this.name = name;
        this.cellPhone = cellPhone;
        this.homePhone = homePhone;
        this.emailAddress = emailAddress;
//        this.addresses = addresses;
    }


    public UUID getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }

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

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    public void addAddress(Address address) {
        addresses.add(address);
        address.setUser(this);
    }

    public void removeAddress(Address address) {
        addresses.remove(address);
        address.setUser(null);
    }
}
