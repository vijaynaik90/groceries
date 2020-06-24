package com.iyengarcoders.groceries.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue
    @Column(name="id")
    private UUID id;
    @Column(name="sku")
    private String sku;
    @Column(name="name")
    private String name;
    @Column(name="price")
    private Double price;
    @Column(name="weight")
    private Double weight;
    @Column(name="description")
    private String description;
    @Column(name="created_at")
    private Date createdAt;
    @Column(name="stock")
    private Integer stock;

    @Lob
    private Byte[] image;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private ProductCategory productCategory;

    public Product() {
    }

    public Product (String sku, String name, String description, Double price, Double weight, Date createdAt, Integer stock) {
        this.sku = sku;
        this.name = name;
        this.description = description;
        this.price = price;
        this.weight = weight;
        this.createdAt = createdAt;
        this.stock = stock;
    }

    public UUID getId() {
        return id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
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

    public void setCreatedAr(Date createdAt) {
        this.createdAt = createdAt;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
