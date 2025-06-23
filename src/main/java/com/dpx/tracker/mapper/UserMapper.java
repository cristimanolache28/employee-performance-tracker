package com.dpx.tracker.mapper;


import com.dpx.tracker.dto.user.UserCreateDto;
import com.dpx.tracker.entity.User;

public final class UserMapper {

    public static User userCreateDto(UserCreateDto  userCreateDto) {
        if (userCreateDto == null) {
            return null;
        }

        return new User(
                userCreateDto.email(),
                userCreateDto.password()
        );
    }


}
