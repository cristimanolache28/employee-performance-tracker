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
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Size(min = 15, message = "The description must to have at least 15 characters")
    @Column(name = "description", nullable = false)
    private String description;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users = new HashSet<>();

    public Role(UUID id, String name, String description, Set<User> users) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.users = users;
    }

    public Role() {
    }
}
