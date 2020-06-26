package com.iyengarcoders.groceries.services;

import com.iyengarcoders.groceries.entity.Cart;
import com.iyengarcoders.groceries.entity.CartItem;
import com.iyengarcoders.groceries.entity.User;
import com.iyengarcoders.groceries.repositories.CartRepository;
import com.iyengarcoders.groceries.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class CartService {

    // add item to cart.
    // add more than 1 item to cart

    // get cart details.
    // update cart.

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private UserRepository userRepository;

    public Cart getCartForUser(String userId) {
        UUID userUuid = UUID.fromString(userId);
        Optional<User> optionalCustomer = userRepository.findById(userUuid);
        if(!optionalCustomer.isPresent()) {
            // throw some error
        }
        User customer = optionalCustomer.get();
        Optional<Cart> optionalCart = cartRepository.findByCustomer(customer);
        return optionalCart.isPresent() ? optionalCart.get() : null;

    }
    // to be called once user logs in/registers and cart is not yet created
    public Cart initCart(String userId) {
        UUID userUuid = UUID.fromString(userId);
        Optional<User> optionalCustomer = userRepository.findById(userUuid);
        if(!optionalCustomer.isPresent()) {
            // throw some error
        }
        Cart cart = new Cart();
        cart.setCustomer(optionalCustomer.get());
        return cartRepository.save(cart);
    }
    // assuming that the client will send request at once to store all the cart items to cart
    public void addItemsToCart(List<CartItem> cartItems) {
        
    }
}
