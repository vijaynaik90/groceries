package com.iyengarcoders.groceries.services;

import com.iyengarcoders.groceries.dto.ProductDto;
import com.iyengarcoders.groceries.entity.Product;
import com.iyengarcoders.groceries.mappers.ProductMapper;
import com.iyengarcoders.groceries.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;


    // get single product
    public ProductDto getProduct(String productId) {
//        UUID productUuid = UUID.fromString(productId);
        return productRepository
                .findById(productId)
                .map(product -> {
                    // convert to productDto
                    return productMapper.productToProductDto(product);

                })
                .orElseThrow(() -> new IllegalArgumentException("Product not found:"+ productId));


        // convert product to productDTO
    }

    // get all Products.
    public List<ProductDto> getAllProducts() {
        List<Product> productList = productRepository.findAll();
        return productList
                .stream()
                .map(productMapper::productToProductDto)
                .collect(Collectors.toList());
    }


    public List<ProductDto> getProductByCategory(String categoryId) {
        List<Product> productList = productRepository.findByCategoryId(categoryId);
        return productList
                .stream()
                .map(productMapper::productToProductDto)
                .collect(Collectors.toList());
    }

    // update product. nostly will be used by admin users.
    public ProductDto createOrUpdateProduct(Product product) {
        return null;
    }

}
