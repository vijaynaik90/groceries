package com.iyengarcoders.groceries.bootstrap;

import com.iyengarcoders.groceries.entity.*;
import com.iyengarcoders.groceries.repositories.*;
import com.iyengarcoders.groceries.services.FilesService;
import com.iyengarcoders.groceries.utils.Constants;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.util.Date;

@Component
public class BootstrapData implements CommandLineRunner {

    private final ProductRepository productRepository;

    private final ProductCategoryRepository productCategoryRepository;

    private final UserRepository userRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private FilesService filesService;

    @Autowired
    private FileRepository fileRepository;


    public BootstrapData(ProductRepository productRepository, ProductCategoryRepository productCategoryRepository, UserRepository userRepository) {
        this.productRepository = productRepository;
        this.productCategoryRepository = productCategoryRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Product product1 = new Product("sku-123","orange", "best ornages in Mumbai", 10.10,1.0,Constants.UnitOfMeasure.KILOGRAM, new Date(),2);
        Product product2 = new Product("sku-234","mango", "best mangoes in Mumbai", 20.00,0.5,Constants.UnitOfMeasure.DOZEN,new Date(),5);

        Product product3 = new Product("sku-345","cabbage", "best cabbge in Mumbai", 15.15,250.00,Constants.UnitOfMeasure.GRAM,new Date(),10);
        Product product4 = new Product("sku-567","Coconut Juice", "best cocunuts in Mumbai", 70.00,1.00,Constants.UnitOfMeasure.LITRE,new Date(),10);

        ProductCategory prodCategory1 = new ProductCategory("fruits", "nice tasty fruits");
        ProductCategory prodCategory2 = new ProductCategory("vegetables", "nice tasty veggies");
        ProductCategory prodCategory3 = new ProductCategory("juices", "nice tasty juices");

        prodCategory1.addProducts(product1);
        prodCategory1.addProducts(product2);

        prodCategory2.addProducts(product3);
        prodCategory3.addProducts(product4);

        productCategoryRepository.save(prodCategory1);
        productCategoryRepository.save(prodCategory2);
        productCategoryRepository.save(prodCategory3);

        File file1 = new File(getClass().getResource("/static/orange.jpg").getFile());
        DiskFileItem diskFileItem1 = new DiskFileItem("file","image/jpeg",false, file1.getName(),(int)file1.length(),file1.getParentFile());
        diskFileItem1.getOutputStream();
        MultipartFile multipartFile1 = new CommonsMultipartFile(diskFileItem1);

        File file2 = new File(getClass().getResource("/static/mango.jpg").getFile());
        DiskFileItem diskFileItem2 = new DiskFileItem("file","image/jpeg",false, file2.getName(),(int)file2.length(),file2.getParentFile());
        diskFileItem2.getOutputStream();
        MultipartFile multipartFile2 = new CommonsMultipartFile(diskFileItem2);

        Product savedProduct1 = productRepository.save(product1);
        Product savedProduct2 = productRepository.save(product2);
        productRepository.save(product3);
        productRepository.save(product4);

        filesService.storeFile(multipartFile1,savedProduct1.getId(),true);
        filesService.storeFile(multipartFile2,savedProduct1.getId(),true);


        Name name = new Name("Vijay", "Simha    ", "Naik");
        Address address1 = new Address("747 Golf View Road", "Flat No. 501","Mumbai", "MH", "India", "400071",false);
        Address address2 = new Address("330 Jaksonvile Road", null,"Philadelphia", "PA", "USA", "18974",true);

        ShippingAddress shippingAddress1 = new ShippingAddress();
        shippingAddress1.setAddress(address1);

        ShippingAddress shippingAddress2 = new ShippingAddress();
        shippingAddress2.setAddress(address2);

        ShippingAddress shippingAddress3 = new ShippingAddress();
        shippingAddress3.setAddress(address2);

        User user1 = new User("vijaynaik90", name,"123234", null,"vijay@vijay.com");
        User user2 = new User("ramyamandyam420", name,"123234", null,"ramya@ramya.com");

        user1.addAddress(shippingAddress1);
        user1.addAddress(shippingAddress2);

        user2.addAddress(shippingAddress3);

        userRepository.save(user1);
        userRepository.save(user2);
        /* TODO: if we do below get this error:
            org.springframework.dao.InvalidDataAccessApiUsageException: detached entity passed to persist
            Look into it.
         */
//        address1.setUser(user1);
//        addressRepository.save(address1);

        CartItem item1 = new CartItem();
        item1.setProduct(product1);
        item1.setQuantity(3.50);
        item1.setTotalPrice((item1.getQuantity()/item1.getProduct().getUnit())*item1.getProduct().getPrice());

        CartItem item2 = new CartItem();
        item2.setProduct(product2);
        item2.setQuantity(2.00);
        // quantity/unit * price
        item2.setTotalPrice((item2.getQuantity()/item2.getProduct().getUnit())*item2.getProduct().getPrice());

        Cart cart = new Cart();
        cart.setCustomer(user1);
        cart.addCartItem(item1);
        cart.addCartItem(item2);

        cartRepository.save(cart);
        System.out.println("********* Bootstrap Data *********");

        System.out.println("Product Count:" + productRepository.count());

        System.out.println("User Count:" + userRepository.count());


    }
}
