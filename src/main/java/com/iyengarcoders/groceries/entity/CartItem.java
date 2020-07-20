package com.iyengarcoders.groceries.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "cart_item")
public class CartItem {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Column(name="id", columnDefinition = "CHAR", length = 36, nullable = false)
    private String id;

    @ManyToOne
    @JoinColumn(name="cart_id")
    @JsonIgnore
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private Double quantity;

    private Double totalPrice;

    public CartItem() {
    }

    public CartItem(Cart cart, Product product, Double quantity) {
        this.cart = cart;
        this.product = product;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
