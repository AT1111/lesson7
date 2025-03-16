package com.lesson7.solution.mapper;

import com.lesson7.solution.config.MapperConfig;
import com.lesson7.solution.entity.Todo;
import com.lesson7.solution.model.TodoCreateDto;
import com.lesson7.solution.model.TodoResponseDto;
import com.lesson7.solution.model.TodoUpdateDto;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface TodoMapper {

    Todo createToModel(TodoCreateDto dto);

    Todo updateToModel(TodoUpdateDto dto);

    TodoResponseDto toResponseDto(Todo todo);
}
