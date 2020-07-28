package com.iyengarcoders.groceries.repositories;

import com.iyengarcoders.groceries.entity.Cart;
import com.iyengarcoders.groceries.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, String> {

    Optional<Cart> findByCustomer(UserProfile userProfile);
}
