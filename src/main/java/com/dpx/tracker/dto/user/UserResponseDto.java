package com.dpx.tracker.dto.user;

import com.dpx.tracker.dto.EmployeeLiteDto;
import com.dpx.tracker.dto.role.RoleResponseDto;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

public record UserResponseDto (
        UUID id,
        String email,
        LocalDate createdAt,
        Boolean isEmployed,
        EmployeeLiteDto employee,
        Set<RoleResponseDto> roles
) {

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        UUID id;
        String email;
        LocalDate createdAt;
        Boolean isEmployed;
        EmployeeLiteDto employee;
        Set<RoleResponseDto> roles;

        public Builder id(UUID id) {
            this.id = id;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder createAt(LocalDate createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder isEmployed(Boolean isEmployed) {
            this.isEmployed = isEmployed;
            return this;
        }

        public Builder employee(EmployeeLiteDto employee) {
            this.employee = employee;
            return this;
        }

        public Builder roles(Set<RoleResponseDto> roles) {
            this.roles = roles;
            return this;
        }

        public UserResponseDto build() {
            return new UserResponseDto(
                id,
                email,
                createdAt,
                isEmployed,
                employee,
                roles
            );
        }
    }
}
