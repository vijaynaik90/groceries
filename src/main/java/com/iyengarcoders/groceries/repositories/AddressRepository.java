package com.iyengarcoders.groceries.repositories;

import com.iyengarcoders.groceries.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
