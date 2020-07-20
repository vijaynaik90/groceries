package com.iyengarcoders.groceries.controllers;

import com.iyengarcoders.groceries.dto.CartDto;
import com.iyengarcoders.groceries.entity.Cart;
import com.iyengarcoders.groceries.entity.CartItem;
import com.iyengarcoders.groceries.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cart")
public class CartController {

    // add multiple items to cart(also cover single item case)
    // get cart for user
    // get all items in cart
    // delete item from cart
    // update cart item.

    @Autowired
    private CartService cartService;
    // maybe authinfo is also passed here?
    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    public CartDto getCartItems(@PathVariable("userId") String userId) {
     return cartService.getCartForUser(userId);
    }

    @RequestMapping(value = "/user/{userId}", method = RequestMethod.POST)
    public CartDto initUserCart(@PathVariable("userId") String userId) {
        return cartService.initCart(userId);
    }

    @RequestMapping(value = "/items/add", method = RequestMethod.POST)
    public CartDto addItemsToCart(List<String> cartItems, String userId) {
        return null;
    }


}
