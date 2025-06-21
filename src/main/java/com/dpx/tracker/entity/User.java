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
    private UUID uuid;

    @Email
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "start_work_date", nullable = false)
    private LocalDate startWorkDate;

    @Column(name = "end_work_date")
    private LocalDate endWorkDate;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    @ManyToMany
    @JoinTable(
            name = "users_roles",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns ={@JoinColumn(name = "role_id")}
    )
    private Set<Role> roles = new HashSet<>();


}
