package com.dpx.tracker.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "skills_level_stages")
public class SkillLevelStage {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "name",nullable = false, unique = true)
    private String name;

    @Column(name = "description")
    @Size(min = 10, message = "The description must have at least 10 characters")
    private String description;

    @Column(name = "points", nullable = false)
    private int points;

}
