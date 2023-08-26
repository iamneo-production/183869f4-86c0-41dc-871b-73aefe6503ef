package com.bfsi.userservice.controller;

import com.bfsi.userservice.dto.UserRequest;
import com.bfsi.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/user")
    public UserRequest registerUser(UserRequest userRequest) {
        return userService.registerUser(userRequest);
    }

    @GetMapping("/user/{userId}")
    public UserRequest fetchUser(@PathVariable int userId) {
        return userService.fetchUser(userId);
    }
}
