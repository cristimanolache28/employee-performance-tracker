package com.dpx.tracker.entity;

import com.dpx.tracker.enums.EducationalStage;
import com.dpx.tracker.enums.Gender;
import com.dpx.tracker.enums.GeneralLevel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(name = "general_level", nullable = false)
    private GeneralLevel generalLevel;

    @Column(name = "address", nullable = false)
    private String address;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", nullable = false)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    @Column(name = "educational_stage", nullable = false)
    private EducationalStage educationalStage;

    @Column(name = "birthday", nullable = false)
    private LocalDate birthday;

    @ManyToMany
    @JoinTable(
            name = "employees_skills",
            joinColumns = {@JoinColumn(name = "employee_id")},
            inverseJoinColumns = {@JoinColumn(name = "skill_id")}
    )
    private List<Skill> skills = new ArrayList<>();

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<PerformanceEvaluation> performanceEvaluations = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;


}
