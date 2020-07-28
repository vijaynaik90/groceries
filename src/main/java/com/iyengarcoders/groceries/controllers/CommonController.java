package com.iyengarcoders.groceries.controllers;

import com.iyengarcoders.groceries.dto.PingDto;
import com.iyengarcoders.groceries.repositories.UserRepository;
import com.iyengarcoders.groceries.security.JwtTokenProvider;
import com.iyengarcoders.groceries.security.payload.JwtAuthenticationResponse;
import com.iyengarcoders.groceries.security.payload.LoginRequest;
import com.iyengarcoders.groceries.security.payload.SignUpRequest;
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

//    @Autowired
//    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @RequestMapping(value = "/ping", method = GET)
    public PingDto ping() {
        PingDto ping = new PingDto("Hello!! Groceries Server is running fine!!", new Date());
        return ping;
    }



    @PostMapping("/signin")
    public ResponseEntity<JwtAuthenticationResponse> authenticateUser(@Valid @RequestBody LoginRequest loginRequest){
        return null;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signUpUser(@Valid @RequestBody SignUpRequest signUpRequest){
        // Following conditions have to be checked.
        // 1) Username already exists.
        // 2)Email Address in use
        return null;
    }
}
