package com.bfsi.userservice.service.impl;

import com.bfsi.userservice.dto.UserRequest;
import com.bfsi.userservice.entity.User;
import com.bfsi.userservice.repository.UserRepository;
import com.bfsi.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserRequest registerUser(UserRequest userRequest) {
        User user = userRequest.toEntity(User.class);
        return userRepository.save(user).toDto(UserRequest.class);
    }

    @Override
    public UserRequest fetchUser(int userId) {
        return userRepository.findById(userId).orElseThrow(null).toDto(UserRequest.class);
    }
}
