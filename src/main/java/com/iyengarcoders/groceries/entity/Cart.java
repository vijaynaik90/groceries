package com.iyengarcoders.groceries.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Type(type = "uuid-char")
    @Column(name="id", length = 36, nullable = false)
    private UUID id;

    @Column(name="created_at")
    private Date createdAt;

    @OneToOne
    @JoinColumn(name = "customer_id")
    @JsonIgnore
    private UserProfile customer;

    public Cart() {
    }

    @OneToMany(mappedBy = "cart", cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private List<CartItem> cartItems = new ArrayList<>();

    public Cart(UserProfile customer) {
        this.customer = customer;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UserProfile getCustomer() {
        return customer;
    }

    public void setCustomer(UserProfile customer) {
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
