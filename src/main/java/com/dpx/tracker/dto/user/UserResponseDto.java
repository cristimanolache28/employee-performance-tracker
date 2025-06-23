package com.dpx.tracker.dto.user;

import com.dpx.tracker.dto.EmployeeLiteDto;
import com.dpx.tracker.dto.RoleLiteDto;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

public record UserResponseDto (
        UUID id,
        String email,
        LocalDate createdAt,
        Boolean isEmployed,
        EmployeeLiteDto employee,
        Set<RoleLiteDto> roles
) {

}
