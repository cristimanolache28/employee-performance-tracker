package com.dpx.tracker.service.impl;

import com.dpx.tracker.repository.UserRepository;
import com.dpx.tracker.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDto createUser(UserDto userDto) {
        return null;
    }
    
}
