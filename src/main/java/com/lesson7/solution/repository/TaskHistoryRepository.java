package com.lesson7.solution.repository;

import com.lesson7.solution.entity.TaskHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskHistoryRepository extends JpaRepository<TaskHistory, Long> {
    @Query(value = "select * from taskhistory t where t.todo_id = ?", nativeQuery = true)
    List<TaskHistory> findAllByTodoId(@Param("todo_id") Long todoId);
}
