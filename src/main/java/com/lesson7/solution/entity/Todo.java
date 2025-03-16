package com.lesson7.solution.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

import static com.lesson7.solution.entity.TodoPriority.LOW;
import static com.lesson7.solution.entity.TodoStatus.PENDING;

@JsonAutoDetect
@Data
@Entity
@Table(name = "todo")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, length = 100)
    private String title;

    @Column(length = 500)
    private String description;

    @Column(nullable = false, name = "duedate")
    private LocalDateTime dueDate;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private TodoPriority priority;

    @Enumerated(value = EnumType.ORDINAL)
    private TodoStatus status;

    @CreationTimestamp
    @Column(nullable = false, name = "createddate")
    private LocalDateTime createdDate;

    @UpdateTimestamp
    @Column(name = "updateddate")
    private LocalDateTime updatedDate;

    @Column(nullable = false, name = "userid")
    private Long userId;

    public Todo() {
        this.userId = 1L;
        this.priority = LOW;
        this.status = PENDING;
    }
}
