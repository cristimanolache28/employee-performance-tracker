package com.dpx.tracker.dto.role;

import java.util.UUID;

public record RoleResponseDto(
    UUID id,
    String name,
    String description
) {

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private UUID id;
        private String name;
        private String description;

        public Builder id(UUID id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public RoleResponseDto build() {
            return new RoleResponseDto(
                    id,
                    name,
                    description
            );
        }
    }
 }
