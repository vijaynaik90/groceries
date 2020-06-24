package com.iyengarcoders.groceries.repositories;

import com.iyengarcoders.groceries.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}