package com.dpx.tracker.mapper;


import com.dpx.tracker.dto.user.UserCreateDto;
import com.dpx.tracker.dto.user.UserResponseDto;
import com.dpx.tracker.dto.user.UserUpdateDto;
import com.dpx.tracker.entity.Role;
import com.dpx.tracker.entity.User;
import com.dpx.tracker.repository.RoleRepository;
import jakarta.persistence.EntityNotFoundException;

import java.util.Set;
import java.util.stream.Collectors;

public final class UserMapper {

    private UserMapper() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static User userCreateDto(UserCreateDto  userCreateDto) {
        if (userCreateDto == null) {
            return null;
        }
        return new User(
                userCreateDto.email(),
                userCreateDto.password()
        );
    }

    public static User userUpdateDto(UserUpdateDto userUpdateDto, RoleRepository roleRepository) {
        if (userUpdateDto == null) {
            return null;
        }

        Set<Role> roles = userUpdateDto.roles().stream()
                .map(roleId -> roleRepository.findById(roleId)
                        .orElseThrow(() -> new EntityNotFoundException("Role not found: " + roleId)))
                .collect(Collectors.toSet());

        return new User(
                userUpdateDto.email(),
                userUpdateDto.password(),
                userUpdateDto.isEmployed(),
                userUpdateDto.updateAt(),
                roles
        );
    }

    public static UserResponseDto userResponseDto(User user) {
        return new UserResponseDto(
                user.getId(),
                user.getEmail(),
                user.getCreatedAt(),
                user.getIsEmployed(),
                EmployeeMapper.toLiteDto(user.getEmployee()),
                user.getRoles().stream()
                    .map(RoleMapper::toDto)
                    .collect(Collectors.toSet())
        );
    }
}
