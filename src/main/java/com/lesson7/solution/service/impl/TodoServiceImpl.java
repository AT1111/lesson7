package com.lesson7.solution.service.impl;

import com.lesson7.solution.entity.TaskHistory;
import com.lesson7.solution.entity.Todo;
import com.lesson7.solution.exception.EntityNotFoundException;
import com.lesson7.solution.mapper.TodoMapper;
import com.lesson7.solution.model.TodoCreateDto;
import com.lesson7.solution.model.TodoResponseDto;
import com.lesson7.solution.model.TodoUpdateDto;
import com.lesson7.solution.repository.TaskHistoryRepository;
import com.lesson7.solution.repository.TodoRepository;
import com.lesson7.solution.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class TodoServiceImpl implements TodoService {
    private final TodoRepository todoRepository;
    private final TaskHistoryRepository taskHistoryRepository;
    private final TodoMapper todoMapper;

    @Override
    public TodoResponseDto create(TodoCreateDto todoCreateDto) {
        return todoMapper.toResponseDto(todoRepository.save(todoMapper.createToModel(todoCreateDto)));
    }

    @Transactional
    @Override
    public TodoResponseDto update(Long id, TodoUpdateDto todoUpdateDto) {
        Todo todoOld = todoRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Todo with id " + id + " not found."));

        Todo todoNew = todoMapper.updateToModel(todoUpdateDto);
        todoNew.setId(id);
        todoNew.setCreatedDate(todoOld.getCreatedDate());
        todoNew = todoRepository.saveAndFlush(todoNew);

        TaskHistory taskHistory = new TaskHistory();
        taskHistory.setOldState(todoOld.toString());
        taskHistory.setNewState(todoNew.toString());

        taskHistory.setChangeDate(LocalDateTime.now());
        taskHistory.setTodo(todoNew);
        taskHistoryRepository.save(taskHistory);

        return todoMapper.toResponseDto(todoNew);
    }

    @Override
    public void delete(Long id) {
        todoRepository.deleteById(id);
    }

    @Override
    public List<TodoResponseDto> findAll() {
        return todoRepository.findAll().stream().map(todoMapper::toResponseDto).toList();
    }
}
