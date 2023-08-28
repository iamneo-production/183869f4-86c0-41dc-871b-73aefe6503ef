package com.hackathon.authservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hackathon.authservice.dto.AuthenticationDto;
import com.hackathon.authservice.model.User;
import com.hackathon.authservice.service.AuthService;

import org.springframework.security.core.Authentication;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService service;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public ResponseEntity<String> addNewUser(@RequestBody User user) {
        try{
            return new ResponseEntity<>(service.saveUser(user), HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<>("User adding failed!", HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/token")
    public ResponseEntity<String> getToken(@RequestBody AuthenticationDto authRequest) {
        try{
            System.out.println(authRequest.toString());
            Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
            System.out.println(authenticate.isAuthenticated());
            if (authenticate.isAuthenticated()) {
                return new ResponseEntity<>(service.generateToken(authRequest.getUsername()), HttpStatus.OK);
            } else {
                throw new RuntimeException("invalid access");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<>("Token getting failed!", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/validate")
    public ResponseEntity<String> validateToken(@RequestParam("token") String token) {
        try{
            System.out.println("Called");
            service.validateToken(token);
            return new ResponseEntity<>("Token is valid", HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<>("Token validation failed!", HttpStatus.BAD_REQUEST);
    }
}
