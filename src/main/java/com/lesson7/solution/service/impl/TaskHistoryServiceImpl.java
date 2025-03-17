package com.lesson7.solution.service.impl;

import com.lesson7.solution.mapper.TaskHistoryMapper;
import com.lesson7.solution.model.TaskHistoryResponseDto;
import com.lesson7.solution.repository.TaskHistoryRepository;
import com.lesson7.solution.service.TaskHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TaskHistoryServiceImpl implements TaskHistoryService {
    private final TaskHistoryRepository taskHistoryRepository;
    private final TaskHistoryMapper taskHistoryMapper;

    @Override
    public List<TaskHistoryResponseDto> findByTodoId(Long id) {
        return taskHistoryRepository.findAllByTodoId(id).stream()
            .map(taskHistoryMapper::toResponseDto)
            .toList();
    }
}
