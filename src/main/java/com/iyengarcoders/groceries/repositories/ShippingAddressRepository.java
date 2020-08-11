package com.iyengarcoders.groceries.repositories;

import com.iyengarcoders.groceries.entity.Address;
import com.iyengarcoders.groceries.entity.ShippingAddress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ShippingAddressRepository extends JpaRepository<ShippingAddress, UUID> {
}
