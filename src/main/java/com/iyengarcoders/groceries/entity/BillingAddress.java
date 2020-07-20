package com.iyengarcoders.groceries.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

public class BillingAddress {

    @Id
    @GeneratedValue
    @Column(name="id")
    private UUID id;

    @Embedded
    private Address address;
}
