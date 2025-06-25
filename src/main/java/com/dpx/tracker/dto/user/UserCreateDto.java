package com.dpx.tracker.dto.user;

import com.dpx.tracker.util.ValidationDto;

import java.util.Set;
import java.util.UUID;

public record UserCreateDto (
        String email,
        String password,
        Set<UUID> roleId
) {

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String email;
        private String password;
        private Set<UUID> roleId;

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder roleId(Set<UUID> roleId) {
            this.roleId = roleId;
            return this;
        }

        public UserCreateDto build() {
            ValidationDto.validateEmail(email);
            ValidationDto.validatePassword(password);
            return new UserCreateDto(
                    email,
                    password,
                    roleId
            );
        }
    }
}
