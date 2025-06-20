package com.dpx.tracker.entity;

import jakarta.persistence.*;
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

    @Column(name = "score_after_evaluation", nullable = false)
    private int scoreAfterEvaluation;

    @Column(name = "efficiency_progress", nullable = false)
    private double efficiencyProgress;

    @Column(name = "note")
    private String note;

}
