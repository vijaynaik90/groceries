package com.iyengarcoders.groceries.entity;

import com.iyengarcoders.groceries.utils.Constants;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Column(name="id", columnDefinition = "CHAR", length = 36, nullable = false)
    private String id;
    @Column(name="sku")
    private String sku;
    @Column(name="name")
    private String name;
    @Column(name="price")
    private Double price;
    // 10Rs/ kg
    // 5 Rs/ 250g
    // 10 Rs/ litre
    // 100Rs / bag

    @Column(name="unit")
    private Double unit;

    @Enumerated(EnumType.STRING)
    @Column(name = "unitOfMeasure")
    private Constants.UnitOfMeasure unitOfMeasure;

    @Column(name="description")
    private String description;
    @Column(name="created_at")
    private Date createdAt;
    @Column(name="stock")
    private Integer stock;

    @OneToMany(mappedBy = "product")
    private List<Files> images = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private ProductCategory productCategory;

    public Product() {
    }

    public Product (String sku, String name, String description, Double price, Double unit, Constants.UnitOfMeasure unitOfMeasure, Date createdAt, Integer stock) {
        this.sku = sku;
        this.name = name;
        this.description = description;
        this.price = price;
        this.unit = unit;
        this.unitOfMeasure = unitOfMeasure;
        this.createdAt = createdAt;
        this.stock = stock;
    }

    public String getId() {
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

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public List<Files> getImages() {
        return images;
    }

    public void setImages(List<Files> images) {
        this.images = images;
    }

    public void addImage(Files file) {
        images.add(file);
        file.setProduct(this);
    }

    public void removeImage(Files file) {
        images.remove(file);
        file.setProduct(null);
    }

    public Constants.UnitOfMeasure getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(Constants.UnitOfMeasure unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
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
