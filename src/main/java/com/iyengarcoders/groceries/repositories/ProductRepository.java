package com.iyengarcoders.groceries.repositories;

import com.iyengarcoders.groceries.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, String> {
    @Query("SELECT p from Product p WHERE p.productCategory.id = :categoryId")
    List<Product> findByCategoryId(@Param("categoryId") String categoryId);
}
