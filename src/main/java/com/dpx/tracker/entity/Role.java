package com.dpx.tracker.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "Roles")
public class Role {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "role", nullable = false, unique = true)
    private String role;

    @Size(min = 10, message = "The description must to have at least 10 characters")
    @Column(name = "description", nullable = false)
    private String description;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users = new HashSet<>();

    public Role(UUID id, String role, String description, Set<User> users) {
        this.id = id;
        this.role = role;
        this.description = description;
        this.users = users;
    }

    public Role() {
    }
}
