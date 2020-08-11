package com.iyengarcoders.groceries.services;

import com.iyengarcoders.groceries.dto.AddressDto;
import com.iyengarcoders.groceries.dto.UserProfileDto;
import com.iyengarcoders.groceries.entity.Address;
import com.iyengarcoders.groceries.entity.Name;
import com.iyengarcoders.groceries.entity.ShippingAddress;
import com.iyengarcoders.groceries.entity.UserProfile;
import com.iyengarcoders.groceries.mappers.UserProfileMapper;
import com.iyengarcoders.groceries.repositories.UserRepository;
import com.iyengarcoders.groceries.security.GroceryUserDetailsService;
import com.iyengarcoders.groceries.security.payload.SignUpRequest;
import com.iyengarcoders.groceries.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;

@Service
public class UserService {

    @Resource(name="groceryUserDetailsService")
    private GroceryUserDetailsService groceryUserDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserProfileMapper userProfileMapper;


    public UserProfileDto createNewUser(SignUpRequest request, boolean isAdmin) {
        String encodedPassword = passwordEncoder.encode(request.getPassword());
        Collection<Constants.RoleName> roles = isAdmin ? Collections.singletonList(Constants.RoleName.ROLE_ADMIN) : Collections.singletonList(Constants.RoleName.ROLE_USER);

        //TODO: check if username already exists.
        String username = groceryUserDetailsService.createUserInDB(request.getUsername(), request.getEmail(), new HashSet<>(roles), encodedPassword);
        if(username == null) {
            // could not create user
        }

        Name name = new Name(request.getFirstName(), request.getMiddleName() , request.getLastName());
        UserProfile userProfile = new UserProfile();
        userProfile.setUsername(username);
        userProfile.setName(name);
        for(AddressDto addressDto: request.getShippingAddresses()) {
            Address address = new Address(addressDto.getLine1(),addressDto.getLine2(), addressDto.getCity(), addressDto.getState(), addressDto.getCountry(),addressDto.getZipCode(),addressDto.getLastUsed());
            ShippingAddress shippingAddress = new ShippingAddress();
            shippingAddress.setAddress(address);
            userProfile.addAddress(shippingAddress);
        }

        userProfile.setCellPhone(request.getCellPhone());
        userProfile.setHomePhone(request.getHomePhone());
        userProfile.setEmailAddress(request.getEmail());
        // user created in users so create in user_profile table now
        UserProfile savedUserProfile = userRepository.save(userProfile);
        return userProfileMapper.toUserDto(savedUserProfile);
    }

    public UserProfile getUserProfileEntity(String username) {
        Optional<UserProfile> optionalUserProfile =  userRepository.findByUsername(username);
        if(!optionalUserProfile.isPresent()) {
            // throw error
        }
        return optionalUserProfile.get();
    }
}
