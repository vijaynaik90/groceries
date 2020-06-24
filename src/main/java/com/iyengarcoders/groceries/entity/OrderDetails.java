package com.iyengarcoders.groceries.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "order_details")
public class OrderDetails {

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "order_id", nullable = false, //
//            foreignKey = @ForeignKey(name = "ORDER_DETAIL_ORD_FK"))
//    private Order order;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "product_id", nullable = false, //
//            foreignKey = @ForeignKey(name = "ORDER_DETAIL_PROD_FK"))
//    private Product product;

    @EmbeddedId
    @JsonIgnore
    private OrderProductPK pk;

    @Column(name = "quanity", nullable = false)
    private Integer quanity;


    @Transient
    public Product getProduct() {
        return this.pk.getProduct();
    }

    @Transient
    public Double getTotalPrice() {
        return pk.getProduct().getPrice() * quanity;
    }


    public int getQuanity() {
        return quanity;
    }

    public void setQuanity(int quanity) {
        this.quanity = quanity;
    }
}
