package com.mindhub.todolist.infrastructure.task.adapter.jpa.repository;

import com.mindhub.todolist.domain.task.model.entity.Task;
import com.mindhub.todolist.domain.task.port.repository.ITaskRepository;
import com.mindhub.todolist.infrastructure.task.adapter.jpa.TaskSpringJpaAdapter;
import com.mindhub.todolist.infrastructure.task.adapter.mapper.TaskMapper;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class TaskH2Repository implements ITaskRepository {

    private final TaskSpringJpaAdapter taskSpringJpaAdapter;
    private final TaskMapper taskMapper;

    public TaskH2Repository(TaskSpringJpaAdapter taskSpringJpaAdapter, TaskMapper taskMapper) {
        this.taskSpringJpaAdapter = taskSpringJpaAdapter;
        this.taskMapper = taskMapper;
    }

    @Override
    public Task save(Task request) {
        var taskToSave = taskMapper.toCreateEntity(request);
        var taskSaved = taskSpringJpaAdapter.save(taskToSave);
        return taskMapper.toDomain(taskSaved);
    }

    @Override
    public void deleteById(Long id) {
        taskSpringJpaAdapter.deleteById(id);
    }

    @Override
    public Task update(Task request) {
        var taskToUpdate = taskMapper.toEntity(request);
        var taskUpdated = taskSpringJpaAdapter.save(taskToUpdate);
        return taskMapper.toDomain(taskUpdated);
    }
}
