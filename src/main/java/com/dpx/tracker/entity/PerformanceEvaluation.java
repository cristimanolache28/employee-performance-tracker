package com.dpx.tracker.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "performance_evaluations")
public class PerformanceEvaluation {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "evaluation_date", nullable = false)
    private LocalDate evaluationDate;

    @Column(name = "score_before_evaluation", nullable = false)
    private int scoreBeforeEvaluation;

    @Column(name = "new_gain_point", nullable = false)
    private int newGainPoint;

    @Column(name = "total_score", nullable = false)
    private int totalScore;

    @Column(name = "efficiency_progress", nullable = false)
    private double efficiencyProgress;

    @Column(name = "note")
    @Size(min = 10, message = "The note must have at least 10 characters")
    private String note;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "evaluator_id", nullable = false)
    private Employee evaluator;
}
