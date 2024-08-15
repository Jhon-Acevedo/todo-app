package com.mindhub.todolist.domain.task.service;

import com.mindhub.todolist.domain.task.model.dto.command.TaskEditCommand;
import com.mindhub.todolist.domain.task.model.entity.Task;
import com.mindhub.todolist.domain.task.port.dao.TaskDao;
import com.mindhub.todolist.domain.task.port.repository.ITaskRepository;

public class TaskEditService {

    private final TaskDao taskDao;
    private final ITaskRepository taskRepository;

    public TaskEditService(TaskDao taskDao, ITaskRepository taskRepository) {
        this.taskDao = taskDao;
        this.taskRepository = taskRepository;
    }

    public Task execute(TaskEditCommand taskEditCommand, Long id) {

        var currentTask = taskDao.getById(id);

        var taskToUpdate = new Task(
                currentTask.getId(),
                taskEditCommand.getTitle(),
                taskEditCommand.getDescription(),
                taskEditCommand.getStatus()
        );

        return taskRepository.update(taskToUpdate);

    }

}
