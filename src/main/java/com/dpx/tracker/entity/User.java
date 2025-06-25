package com.dpx.tracker.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    private UUID id;

    @Email
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDate createdAt;

    @Column(name = "update_at")
    private LocalDate updateAt;

    @Column(name = "is_employed", nullable = false)
    private Boolean isEmployed;

    @OneToOne(mappedBy = "user")
    private Employee employee;

    @ManyToMany
    @JoinTable(
            name = "users_roles",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns ={@JoinColumn(name = "role_id")}
    )
    private Set<Role> roles = new HashSet<>();

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(String email, String password, Boolean isEmployed, LocalDate updateAt, Set<Role> roles) {
        this.email = email;
        this.password = password;
        this.isEmployed = isEmployed;
        this.updateAt = updateAt;
        this.roles = roles;
    }

}
