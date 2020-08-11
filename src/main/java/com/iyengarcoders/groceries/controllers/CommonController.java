package com.iyengarcoders.groceries.controllers;

import com.iyengarcoders.groceries.dto.PingDto;
import com.iyengarcoders.groceries.dto.UserProfileDto;
import com.iyengarcoders.groceries.repositories.UserRepository;
import com.iyengarcoders.groceries.security.GroceryUser;
import com.iyengarcoders.groceries.security.GroceryUserDetailsService;
import com.iyengarcoders.groceries.security.JwtTokenProvider;
import com.iyengarcoders.groceries.security.payload.ApiResponse;
import com.iyengarcoders.groceries.security.payload.JwtAuthenticationResponse;
import com.iyengarcoders.groceries.security.payload.LoginRequest;
import com.iyengarcoders.groceries.security.payload.SignUpRequest;
import com.iyengarcoders.groceries.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Collections;
import java.util.Date;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/api/v1")
public class CommonController {


    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    private GroceryUserDetailsService userDetailsService;

    @Autowired
    private UserService userService;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @RequestMapping(value = "/ping", method = GET)
    public PingDto ping() {
        PingDto ping = new PingDto("Hello!! Groceries Server is running fine!!", new Date());
        return ping;
    }



    @PostMapping("/signin")
    public ResponseEntity<JwtAuthenticationResponse> authenticateUser(@Valid @RequestBody LoginRequest loginRequest){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsernameOrEmail(),loginRequest.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        GroceryUser userPrincipal = (GroceryUser) authentication.getPrincipal();
        String username = userPrincipal.getUsername();
        String jwt = jwtTokenProvider.generateToken(username);
        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt,username));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signUpUser(@Valid @RequestBody SignUpRequest signUpRequest){
        // Following conditions have to be checked.
        // 1) Username already exists.
        // 2)Email Address in use
        if(userDetailsService.loadUsersByUsername(signUpRequest.getUsername()).size() > 0) {
            return new ResponseEntity(new ApiResponse(false, "Username already exists"),HttpStatus.BAD_REQUEST);
        }
        UserProfileDto newUser = userService.createNewUser(signUpRequest,false);

        System.out.println("Created USer:" + newUser.toString());

        String jwt = jwtTokenProvider.generateToken(newUser.getUsername());

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/api/users/{username}")
                .buildAndExpand(newUser.getUsername()).toUri();

        return ResponseEntity.created(location).body(new JwtAuthenticationResponse(jwt,newUser.getUsername()));
    }
}
