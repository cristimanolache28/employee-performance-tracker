package com.dpx.tracker.entity;

import com.dpx.tracker.enums.EducationalStage;
import com.dpx.tracker.enums.Gender;
import com.dpx.tracker.enums.GeneralLevel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.*;

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

    @Column(name = "CNP", nullable = false, unique = true)
    private String CNP;

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

    @Column(name = "birth_day", nullable = false)
    private LocalDate birthDay;

    @Column(name = "update_at")
    private LocalDate updateAt;

    @Column(name = "start_work_date", nullable = false, updatable = false)
    private LocalDate startWorkDate;

    @Column(name = "end_work_date")
    private LocalDate endWorkDate;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PerformanceEvaluation> performanceEvaluations = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "position_id", nullable = false)
    private Position position;

    @ManyToMany
    @JoinTable(
            name = "employees_skills",
            joinColumns = {@JoinColumn(name = "employee_id")},
            inverseJoinColumns = {@JoinColumn(name = "skill_id")},
            uniqueConstraints = @UniqueConstraint(columnNames = {"employee_id", "skill_id"})
    )
    private Set<Skill> skills = new HashSet<>();
}
