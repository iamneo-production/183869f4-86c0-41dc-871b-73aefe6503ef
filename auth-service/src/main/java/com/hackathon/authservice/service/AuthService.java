package com.hackathon.authservice.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hackathon.authservice.config.JwtService;
import com.hackathon.authservice.dao.AuthDao;
import com.hackathon.authservice.model.User;

@Service
public class AuthService implements Serializable{
    @Autowired
    AuthDao authDao;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    public String saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        authDao.save(user);
        return "user added to the system";
    }

    public String generateToken(String username) {
        return jwtService.generateToken(username);
    }

    public void validateToken(String token) {
        jwtService.validateToken(token);
    }
}
