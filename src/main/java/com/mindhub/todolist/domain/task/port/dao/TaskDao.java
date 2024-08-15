package com.mindhub.todolist.domain.task.port.dao;

import com.mindhub.todolist.domain.task.model.entity.Task;

import java.util.List;

public interface TaskDao {

    Task getById(Long id);

    List<Task> getAll();

    List<Task> getByIds(List<Long> tasksIds);
}
