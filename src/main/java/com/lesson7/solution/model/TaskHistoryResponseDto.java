package com.lesson7.solution.model;

import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TaskHistoryResponseDto {
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private Long todoId;

    @Column(nullable = false)
    private String oldState;

    @Column(nullable = false)
    private String newState;

    @Column(nullable = false)
    private LocalDateTime changeDate;

    private String changedBy;
}
