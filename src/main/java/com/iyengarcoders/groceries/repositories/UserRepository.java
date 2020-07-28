package com.iyengarcoders.groceries.repositories;

import com.iyengarcoders.groceries.entity.UserProfile;
import com.iyengarcoders.groceries.security.GroceryUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<UserProfile, String> {
//    @Query("SELECT a.username, a.password, a.enabled,a.is_locked,a.is_expired, b.email" +
//            "from users a INNER JOIN user_profile b on (a.username = b.username)" +
//            "where a.username = :usernameOrEmail or lower(b.email) = :usernameOrEmail")
//    GroceryUser loadUserByUsernameOrEmailAddress(String usernameOrEmail);

//    Boolean existsByUsername(String username);

    Optional<UserProfile> findByUsername(String username);

    Boolean existsByUsernameOrEmailAddress(String username,String emailAddress);
}
