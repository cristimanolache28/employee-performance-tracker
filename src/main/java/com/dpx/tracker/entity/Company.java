package com.dpx.tracker.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "companies")
public class Company {
    @Id
    @GeneratedValue
    private UUID uuid;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "location", nullable = false)
    private String location;

    @Column(name = "address", nullable = false)
    private String address;

    // TODO: to change with a enum
    private String industry;

    @Column(name = "founded_date", nullable = false)
    private LocalDate foundedDate;

    @OneToMany(mappedBy = "companies", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Department> departments = new HashSet<>();
}
