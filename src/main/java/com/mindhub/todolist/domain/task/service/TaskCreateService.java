package com.mindhub.todolist.domain.task.service;

import com.mindhub.todolist.domain.task.model.dto.command.TaskCreateCommand;
import com.mindhub.todolist.domain.task.model.entity.Task;
import com.mindhub.todolist.domain.task.port.repository.ITaskRepository;

public class TaskCreateService {

    private final ITaskRepository taskRepository;

    public TaskCreateService(ITaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task execute(TaskCreateCommand createCommand) {
        var taskToCreate = new Task().requestToCreate(createCommand);
        return taskRepository.save(taskToCreate);
    }

}
