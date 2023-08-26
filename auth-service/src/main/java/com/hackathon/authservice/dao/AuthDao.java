package com.hackathon.authservice.dao;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackathon.authservice.model.User;

@Repository
public interface AuthDao extends JpaRepository<User, Integer>{
    Optional<User> findByName(String name);
}
