package com.mindhub.todolist.infrastructure.task.adapter.jpa.dao;

import com.mindhub.todolist.domain.task.model.entity.Task;
import com.mindhub.todolist.domain.task.model.exception.TaskException;
import com.mindhub.todolist.domain.task.port.dao.TaskDao;
import com.mindhub.todolist.infrastructure.task.adapter.jpa.TaskSpringJpaAdapter;
import com.mindhub.todolist.infrastructure.task.adapter.mapper.TaskMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class TaskH2Dao implements TaskDao {

    private final TaskSpringJpaAdapter taskSpringJpaAdapter;
    private final TaskMapper taskMapper;

    public TaskH2Dao(TaskSpringJpaAdapter taskSpringJpaAdapter, TaskMapper taskMapper) {
        this.taskSpringJpaAdapter = taskSpringJpaAdapter;
        this.taskMapper = taskMapper;
    }

    @Override
    public Task getById(Long id) {
        var optionalTask = taskSpringJpaAdapter.findById(id);
        return optionalTask.map(taskMapper::toDomain)
                .orElseThrow(() -> new TaskException("Task not found"));
    }

    @Override
    public List<Task> getAll() {
        return taskSpringJpaAdapter.findAll()
                .stream()
                .map(taskMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Task> getByIds(List<Long> tasksIds) {
        return List.of();
    }
}
