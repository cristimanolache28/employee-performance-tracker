package com.dpx.tracker.dto.user;

public record UserCreateDto (
        String email,
        String password
) {

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String email;
        private String password;

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public UserCreateDto build() {
            validateEmail(email);
            validatePassword(password);
            return new UserCreateDto(
                    email,
                    password
            );
        }

        private void validateEmail(String email) {
            if (email == null || email.isBlank()) {
                throw new IllegalArgumentException("Email cannot be null or blank");
            }
            if (!email.matches("^[\\w-.]+@[\\w-]+\\.[a-zA-Z]{2,}$")) {
                throw new IllegalArgumentException("Email format is invalid");
            }
        }

        private void validatePassword(String password) {
            if (password == null) {
                throw new IllegalArgumentException("Password cannot be null");
            }
            if (password.length() < 5 || password.length() > 64) {
                throw new IllegalArgumentException("Password length must be between 5 and 64 characters");
            }
        }

    }

}
