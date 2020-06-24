package com.iyengarcoders.groceries.repositories;

import com.iyengarcoders.groceries.entity.ProductCategory;
import org.springframework.data.repository.CrudRepository;

public interface ProductCategoryRepository extends CrudRepository<ProductCategory, Long> {
}
