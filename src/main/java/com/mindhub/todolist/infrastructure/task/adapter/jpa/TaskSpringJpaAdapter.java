package com.mindhub.todolist.infrastructure.task.adapter.jpa;

import com.mindhub.todolist.infrastructure.task.adapter.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskSpringJpaAdapter extends JpaRepository<TaskEntity, Long> {
}
