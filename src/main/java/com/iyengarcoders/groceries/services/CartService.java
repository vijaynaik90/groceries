package com.iyengarcoders.groceries.services;

import com.iyengarcoders.groceries.dto.CartDto;
import com.iyengarcoders.groceries.entity.Cart;
import com.iyengarcoders.groceries.entity.CartItem;
import com.iyengarcoders.groceries.entity.UserProfile;
import com.iyengarcoders.groceries.mappers.CartMapper;
import com.iyengarcoders.groceries.repositories.CartRepository;
import com.iyengarcoders.groceries.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    // add item to cart.
    // add more than 1 item to cart

    // get cart details.
    // update cart.

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CartMapper cartMapper;

    public CartDto getCartForUser(String userId) {
//        UUID userUuid = UUID.fromString(userId);
        Optional<UserProfile> optionalCustomer = userRepository.findById(userId);
        if(!optionalCustomer.isPresent()) {
            // throw some error
        }
        UserProfile customer = optionalCustomer.get();
        Cart cart = cartRepository.findByCustomer(customer).get();
        return cartMapper.toCartDto(cart, customer);

    }
    // to be called once user logs in/registers and cart is not yet created
    public CartDto initCart(String userId) {
//        UUID userUuid = UUID.fromString(userId);
        Optional<UserProfile> optionalCustomer = userRepository.findById(userId);
        UserProfile customer = optionalCustomer.get();
        if(!optionalCustomer.isPresent()) {
            // throw some error
        }

        // check if cart already exists. then retrun that cart.

        Cart cart = null;
        cart = cartRepository.findByCustomer(customer).get();
        if(cart != null)
            return cartMapper.toCartDto(cart,customer);
        else {
            cart = new Cart();
            cart.setCustomer(optionalCustomer.get());
            return cartMapper.toCartDto(cartRepository.save(cart), customer);
        }

    }

    // assuming that the client will send request at once to store all the cart items to cart
    public void addItemsToCart(List<CartItem> cartItems) {
        
    }
}
