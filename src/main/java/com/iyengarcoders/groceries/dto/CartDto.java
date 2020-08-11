package com.iyengarcoders.groceries.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class CartDto {

    private UUID cartId;

    private Date createdAt;

    @JsonProperty("customer")
    private UserProfileDto userProfileDto;

    @JsonProperty("cartItems")
    private List<CartItemDto> cartItemsDto;

    public CartDto() {
    }

    public UUID getCartId() {
        return cartId;
    }

    public void setCartId(UUID cartId) {
        this.cartId = cartId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public UserProfileDto getUserProfileDto() {
        return userProfileDto;
    }

    public void setUserProfileDto(UserProfileDto userProfileDto) {
        this.userProfileDto = userProfileDto;
    }

    public List<CartItemDto> getCartItemsDto() {
        return cartItemsDto;
    }

    public void setCartItemsDto(List<CartItemDto> cartItemsDto) {
        this.cartItemsDto = cartItemsDto;
    }
}
