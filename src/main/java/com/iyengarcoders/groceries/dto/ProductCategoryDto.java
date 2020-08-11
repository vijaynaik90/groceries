package com.iyengarcoders.groceries.dto;

import java.util.UUID;

public class ProductCategoryDto {

    private UUID categoryId;

    private String categoryName;

    private String description;

    public ProductCategoryDto() {
    }

    public UUID getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(UUID categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
