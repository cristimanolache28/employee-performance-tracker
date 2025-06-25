package com.dpx.tracker.dto.user;

import com.dpx.tracker.entity.Role;


import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

public record UserUpdateDto (
        String email,
        String password,
        LocalDate updateAt,
        Boolean isEmployed,
        Set<UUID> roles
) {
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        String email;
        String password;
        LocalDate updateAt;
        Boolean isEmployed;
        Set<UUID> roles;

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder updateAt(LocalDate updateAt) {
            this.updateAt = updateAt;
            return this;
        }

        public Builder isEmployed(Boolean isEmployed) {
            this.isEmployed = isEmployed;
            return this;
        }

        public Builder roles(Set<UUID> roles) {
            this.roles = roles;
            return this;
        }

        public UserUpdateDto build() {
            return new UserUpdateDto(
                    email,
                    password,
                    updateAt,
                    isEmployed,
                    roles
            );
        }
    }
}
