package com.iyengarcoders.groceries.repositories;

import com.iyengarcoders.groceries.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CartItemRepository extends JpaRepository<CartItem, String> {
}
