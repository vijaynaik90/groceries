package com.iyengarcoders.groceries.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CartItemDto {

    private String itemId;

    @JsonProperty("product")
    private ProductDto productDto;

    private Double quantity;

    private double totalPrice;

    public CartItemDto() {
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public ProductDto getProductDto() {
        return productDto;
    }

    public void setProductDto(ProductDto productDto) {
        this.productDto = productDto;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
