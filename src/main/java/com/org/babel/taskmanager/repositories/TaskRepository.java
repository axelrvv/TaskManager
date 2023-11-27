package com.org.babel.taskmanager.repositories;

import com.org.babel.taskmanager.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
