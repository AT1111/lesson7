package com.lesson7.solution.controller;

import com.lesson7.solution.model.TaskHistoryResponseDto;
import com.lesson7.solution.model.TodoCreateDto;
import com.lesson7.solution.model.TodoResponseDto;
import com.lesson7.solution.model.TodoUpdateDto;
import com.lesson7.solution.service.TaskHistoryService;
import com.lesson7.solution.service.TodoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/todos")
public class TodoController {
    private final TodoService todoService;
    private final TaskHistoryService taskHistoryService;

    @PostMapping
    public TodoResponseDto create(@RequestBody @Valid TodoCreateDto todoCreateDto) {
        return todoService.create(todoCreateDto);
    }

    @PutMapping("/{id}")
    public TodoResponseDto update(@PathVariable Long id, @RequestBody @Valid TodoUpdateDto todoUpdateDto) {
        return todoService.update(id, todoUpdateDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        todoService.delete(id);
    }

    @GetMapping
    public List<TodoResponseDto> findAll() {
        return todoService.findAll();
    }

    @GetMapping("/{id}/history")
    public List<TaskHistoryResponseDto> viewTaskHistory(@PathVariable Long id) {
        return taskHistoryService.findByTodoId(id);
    }
}
