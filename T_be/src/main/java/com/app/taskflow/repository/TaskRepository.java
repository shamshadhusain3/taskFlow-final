package com.app.taskflow.repository;


import com.app.taskflow.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
    Task findByTaskId(String taskId);
}
