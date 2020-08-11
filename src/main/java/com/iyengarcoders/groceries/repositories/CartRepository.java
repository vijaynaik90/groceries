package com.iyengarcoders.groceries.repositories;

import com.iyengarcoders.groceries.entity.Cart;
import com.iyengarcoders.groceries.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CartRepository extends JpaRepository<Cart, UUID> {

    Optional<Cart> findByCustomer(UserProfile userProfile);
}
