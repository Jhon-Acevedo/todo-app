package com.mindhub.todolist.domain.task.port.repository;

import com.mindhub.todolist.domain.task.model.entity.Task;

public interface ITaskRepository {

    Task save(Task request);

    void deleteById(Long id);

    Task update(Task request);

}
