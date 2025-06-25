package com.dpx.tracker.util;

import java.util.Set;
import java.util.UUID;

public final class ValidationDto {

    // ----- Validation methods for User DTO fields -----
    private ValidationDto() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static void validateEmail(String email) {
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email can not be null or blank");
        }
        if (!email.matches("^[\\w-.]+@[\\w-]+\\.[a-zA-Z]{2,}$")) {
            throw new IllegalArgumentException("Email format is invalid");
        }
    }

    public static void validatePassword(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }
        if (password.length() < 5 || password.length() > 64) {
            throw new IllegalArgumentException("Password length must be between 5 and 64 characters");
        }
    }

    public static void validateRole(Set<UUID> roleId) {
       if (roleId == null || roleId.isEmpty()) {
           throw new IllegalArgumentException("Role ID must not be null or empty.");
       }
    }

    // ----- Validation methods for Role DTO fields -----
    public static void validateRoleName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Role name can not be null or blank");
        }
        if (name.length() < 5 || name.length() > 20) {
            throw new IllegalArgumentException("Role length name must be between 5 and 20 characters");
        }
    }

    public static void validateRoleDescription(String description) {
        if (description == null || description.length() < 15) {
            throw new IllegalArgumentException("Description has to have more then 15 characters.");
        }
    }

}
