package com.iyengarcoders.groceries.controllers;

import com.iyengarcoders.groceries.dto.ProductDto;
import com.iyengarcoders.groceries.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/all", method = GET)
    public List<ProductDto> getAllProducts() {
        return productService.getAllProducts();
    }

    @RequestMapping(value = "/{productId}", method = GET)
    public ProductDto getSingleProduct(@PathVariable String productId) {
        ProductDto productDto = null;
        try{
            productDto =  productService.getProduct(productId);
        } catch (Exception e) {
            System.out.println("Exception");
        }
        return productDto;
    }

    @RequestMapping(value = "category/{categoryId}", method = GET)
    public List<ProductDto> getProductByCategory(@PathVariable String categoryId) {
        List<ProductDto> productList = null;
        try{
            productList =  productService.getProductByCategory(categoryId);
        } catch (Exception e) {
            System.out.println("Exception");
        }
        return productList;
    }


}
