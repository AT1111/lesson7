package com.lesson7.solution.service;

import com.lesson7.solution.model.TaskHistoryResponseDto;

import java.util.List;

public interface TaskHistoryService {

    List<TaskHistoryResponseDto> findByTodoId(Long id);
}
