package com.iyengarcoders.groceries.repositories;

import com.iyengarcoders.groceries.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
