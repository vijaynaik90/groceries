package com.iyengarcoders.groceries.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "product_category")
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;
    @Column(name="category_name")
    private String categoryName;
    @Column(name="description")
    private String description;
    @OneToMany(mappedBy = "productCategory", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Product> products = new HashSet<>();

    public ProductCategory() {
    }

    public ProductCategory(String categoryName, String description) {
        this.categoryName = categoryName;
        this.description = description;
    }

    public int getId() {
        return id;
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

    public void addProducts(Product product) {
        products.add(product);
        product.setProductCategory(this);
    }

    public void removeProduct(Product product) {
        products.remove(product);
        product.setProductCategory(null);
    }
}
