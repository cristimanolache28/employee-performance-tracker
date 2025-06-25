package com.dpx.tracker.service.impl;

import com.dpx.tracker.dto.user.UserCreateDto;
import com.dpx.tracker.dto.user.UserResponseDto;
import com.dpx.tracker.entity.User;
import com.dpx.tracker.repository.UserRepository;
import com.dpx.tracker.service.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserResponseDto createUser(UserCreateDto userCreateDto) {
        User user = new User();
        user.setEmail(userCreateDto.email());
        user.setPassword(userCreateDto.password());
        user.setCreatedAt(LocalDate.now());
        user.setIsEmployed(false);
        user.setRoles("USER");

    }
}
