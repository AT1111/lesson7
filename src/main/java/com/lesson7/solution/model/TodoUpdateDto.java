package com.lesson7.solution.model;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

@Data
public class TodoUpdateDto {
    @NotEmpty(message = "Title can't be empty")
    @Length(max = 100)
    private String title;

    @Length(max = 500)
    private String description;

    @NotEmpty
    private LocalDateTime dueDate;

    private String priority;

    @NotEmpty
    private String status;
}
