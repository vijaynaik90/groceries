package com.iyengarcoders.groceries.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

public class CartDto {

    private String cartId;

    private Date createdAt;

    @JsonProperty("customer")
    private UserDto userDto;

    @JsonProperty("cartItems")
    private List<CartItemDto> cartItemsDto;

    public CartDto() {
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    public List<CartItemDto> getCartItemsDto() {
        return cartItemsDto;
    }

    public void setCartItemsDto(List<CartItemDto> cartItemsDto) {
        this.cartItemsDto = cartItemsDto;
    }
}
