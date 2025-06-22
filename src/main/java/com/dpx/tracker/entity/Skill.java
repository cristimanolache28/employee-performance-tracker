package com.dpx.tracker.entity;

import com.dpx.tracker.enums.SkillType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(
        name = "skills",
        uniqueConstraints = @UniqueConstraint(columnNames = {"name", "employee_id"})
)
public class Skill {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "skill_type", nullable = false)
    private SkillType skillType;

    @Column(name = "description", nullable = false)
    @Size(min = 10, message = "The description must have at least 10 characters")
    private String description;

    @ManyToMany(mappedBy = "skills")
    private Set<Employee> employees = new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "skill_level_id", nullable = false)
    private SkillLevel skillLevel;
}
