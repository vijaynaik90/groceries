package com.iyengarcoders.groceries.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Column(name="id", columnDefinition = "CHAR", length = 36, nullable = false)
    private String id;

    @Column(name="created_at")
    private Date createdAt;

    @OneToOne
    @JoinColumn(name = "customer_id")
    @JsonIgnore
    private User customer;

    public Cart() {
    }

    @OneToMany(mappedBy = "cart", cascade= CascadeType.ALL, fetch = FetchType.EAGER)
    private List<CartItem> cartItems = new ArrayList<>();

    public Cart(User customer) {
        this.customer = customer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public void addCartItem(CartItem item) {
        this.cartItems.add(item);
        item.setCart(this);
    }

    public void removeCartItem(CartItem item) {
        cartItems.remove(item);
        item.setCart(null);
    }
}
