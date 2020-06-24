package com.iyengarcoders.groceries.bootstrap;

import com.iyengarcoders.groceries.entity.*;
import com.iyengarcoders.groceries.repositories.ProductCategoryRepository;
import com.iyengarcoders.groceries.repositories.ProductRepository;
import com.iyengarcoders.groceries.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashSet;

@Component
public class BootstrapData implements CommandLineRunner {

    private final ProductRepository productRepository;

    private final ProductCategoryRepository productCategoryRepository;

    private final UserRepository userRepository;


    public BootstrapData(ProductRepository productRepository, ProductCategoryRepository productCategoryRepository, UserRepository userRepository) {
        this.productRepository = productRepository;
        this.productCategoryRepository = productCategoryRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Product product1 = new Product("sku-123","orange", "best ornages in Mumbai", 10.10,5.5,new Date(),2);
        Product product2 = new Product("sku-234","mango", "best mangoes in Mumbai", 20.00,15.5,new Date(),5);

        Product product3 = new Product("sku-345","cabbage", "best cabbge in Mumbai", 15.15,5.5,new Date(),10);

        ProductCategory prodCategory1 = new ProductCategory("fruits", "nice tasty fruits");
        ProductCategory prodCategory2 = new ProductCategory("vegetables", "nice tasty veggies");

        prodCategory1.addProducts(product1);
        prodCategory1.addProducts(product2);

        prodCategory2.addProducts(product3);

        productCategoryRepository.save(prodCategory1);
        productCategoryRepository.save(prodCategory2);

        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);


        Name name = new Name("Vijay", "Simha    ", "Naik");
        Address address1 = new Address(Address.AddressType.SHIPPING,"747 Golf View Road", null,"Mumbai", "MH", "India", "400071",false);

        User user1 = new User("vijaynaik90", name,"123234", null,"test@test.com",new HashSet<>());
        user1.addAddress(address1);

        userRepository.save(user1);
        System.out.println("Bootstrap Data");

        System.out.println("Product Count:" + productRepository.count());

        System.out.println("User Count:" + userRepository.count());



    }
}
