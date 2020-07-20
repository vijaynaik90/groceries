package com.iyengarcoders.groceries.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class ProductDto {


    private String productId;

    private String name;

    private Double price;

    private Double unit;

    private String unitOfMeasure;

    private String description;

    private Date createdAt;

    private Integer stock;



    @JsonProperty("productCategory")
    private ProductCategoryDto categoryDto;

    public ProductDto() {
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getUnit() {
        return unit;
    }

    public void setUnit(Double unit) {
        this.unit = unit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public ProductCategoryDto getCategoryDto() {
        return categoryDto;
    }

    public void setCategoryDto(ProductCategoryDto categoryDto) {
        this.categoryDto = categoryDto;
    }

    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(String unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }
}
