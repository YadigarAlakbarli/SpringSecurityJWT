package com.company.springsecurityjwt.controller;

import com.company.springsecurityjwt.model.JwtRequest;
import com.company.springsecurityjwt.model.JwtRespons;
import com.company.springsecurityjwt.security.CustomUserDetailsService;
import com.company.springsecurityjwt.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jwt")
public class JwtController {
    @Autowired
    AuthenticationManager am;
    @Autowired
    CustomUserDetailsService userDetailsService;
    @Autowired
    JwtTokenUtil jwtUtil;

    @PostMapping("/generatetoken")
    public String generateToken(@RequestBody JwtRequest request) {
        System.out.println("Hello World");
        boolean isAuthenticated = am.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()))
                .isAuthenticated();

        if (!isAuthenticated)
            throw new BadCredentialsException("username or password incorrect");

        UserDetails userDetails =userDetailsService.loadUserByUsername(request.getEmail());
         return jwtUtil.generateToken(userDetails);
    }
}
