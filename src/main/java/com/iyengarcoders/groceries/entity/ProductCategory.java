package com.iyengarcoders.groceries.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "product_category")
public class ProductCategory {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Type(type = "uuid-char")
    @Column(name="id", length = 36, nullable = false)
    private UUID id;
    @Column(name = "name")
    private String name;
    @Column(name="description")
    private String description;
    @OneToMany(mappedBy = "productCategory", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Product> products = new HashSet<>();

    public ProductCategory() {
    }

    public ProductCategory(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
