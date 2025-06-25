package com.dpx.tracker.util;

public final class ValidationDto {

    private ValidationDto() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static void validateEmail(String email) {
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email cannot be null or blank");
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
}
