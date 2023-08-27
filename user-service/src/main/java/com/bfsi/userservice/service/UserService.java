package com.bfsi.userservice.service;

import com.bfsi.userservice.dto.UserRequest;

public interface UserService {
    UserRequest registerUser(UserRequest userRequest);

    UserRequest fetchUser(int userId);
}
