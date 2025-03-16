package com.lesson7.solution.mapper;

import com.lesson7.solution.config.MapperConfig;
import com.lesson7.solution.entity.TaskHistory;
import com.lesson7.solution.model.TaskHistoryResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapperConfig.class)
public interface TaskHistoryMapper {
    @Mapping(target = "todoId", source = "todo.id")
    TaskHistoryResponseDto toResponseDto(TaskHistory taskHistory);
}
