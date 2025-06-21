package com.dpx.tracker.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "skills_levels")
public class SkillLevel {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "points",nullable = false)
    private int points;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "skill_level_stage_id", nullable = false)
    private SkillLevelStage skillLevelStage;
}

