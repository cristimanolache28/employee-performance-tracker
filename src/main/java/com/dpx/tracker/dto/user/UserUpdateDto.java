package com.dpx.tracker.dto.user;

import com.dpx.tracker.entity.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.Set;

public record UserUpdateDto (
        @Email @NotBlank String email,
        @Size(min = 5, max = 64) String password,
        @NotNull LocalDate updateAt,
        @NotNull Boolean isEmployed,
        @NotNull @Size(min = 1) Set<Role> roles
) {

}
