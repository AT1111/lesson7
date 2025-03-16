package com.lesson7.solution.service;

import com.lesson7.solution.model.TodoCreateDto;
import com.lesson7.solution.model.TodoResponseDto;
import com.lesson7.solution.model.TodoUpdateDto;

import java.util.List;

public interface TodoService {

    TodoResponseDto create(TodoCreateDto todo);

    TodoResponseDto update(Long id, TodoUpdateDto todo);

    void delete(Long id);

    List<TodoResponseDto> findAll();
}
