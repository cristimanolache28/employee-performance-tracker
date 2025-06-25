package com.dpx.tracker.service;

import com.dpx.tracker.dto.user.UserCreateDto;
import com.dpx.tracker.dto.user.UserResponseDto;

public interface UserService {

    UserResponseDto createUser(UserCreateDto userCreateDto);

}
