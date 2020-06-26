package com.iyengarcoders.groceries.bootstrap;

import com.iyengarcoders.groceries.entity.*;
import com.iyengarcoders.groceries.repositories.*;
import com.iyengarcoders.groceries.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashSet;

@Component
public class BootstrapData implements CommandLineRunner {

    private final ProductRepository productRepository;

    private final ProductCategoryRepository productCategoryRepository;

    private final UserRepository userRepository;

    @Autowired
    private CartRepository cartRepository;


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
        Address address1 = new Address(Constants.AddressType.SHIPPING,"747 Golf View Road", null,"Mumbai", "MH", "India", "400071",false);

        User user1 = new User("vijaynaik90", name,"123234", null,"test@test.com");
        user1.addAddress(address1);

        userRepository.save(user1);
        /* TODO: if we do below get this error:
            org.springframework.dao.InvalidDataAccessApiUsageException: detached entity passed to persist
            Look into it.
         */
//        address1.setUser(user1);
//        addressRepository.save(address1);

        CartItem item = new CartItem();
        item.setProduct(product1);
        item.setQuantity(5);
        item.setTotalPrice(item.getQuantity()*item.getProduct().getPrice());

        Cart cart = new Cart();
        cart.setCustomer(user1);
        cart.addCartItem(item);

        cartRepository.save(cart);
        System.out.println("********* Bootstrap Data *********");

        System.out.println("Product Count:" + productRepository.count());

        System.out.println("User Count:" + userRepository.count());



    }
}
