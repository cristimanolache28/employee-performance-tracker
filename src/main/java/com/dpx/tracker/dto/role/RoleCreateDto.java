package com.dpx.tracker.dto.role;



public record  RoleCreateDto (
    String name,
    String description
) {
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String name;
        private String description;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public RoleCreateDto build() {
            return new RoleCreateDto(
                    name,
                    description
            );
        }

    }
}
