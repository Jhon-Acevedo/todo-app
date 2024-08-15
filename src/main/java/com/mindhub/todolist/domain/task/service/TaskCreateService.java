package com.mindhub.todolist.domain.task.service;

import com.mindhub.todolist.domain.task.model.dto.command.TaskCreateCommand;
import com.mindhub.todolist.domain.task.model.entity.Task;
import com.mindhub.todolist.domain.task.port.repository.ITaskRepository;
import com.mindhub.todolist.domain.user.port.dao.UserDao;

public class TaskCreateService {

    private final ITaskRepository taskRepository;
    private final UserDao userDao;

    public TaskCreateService(ITaskRepository taskRepository, UserDao userDao) {
        this.taskRepository = taskRepository;
        this.userDao = userDao;
    }

    public Task execute(TaskCreateCommand createCommand) {
        var user = userDao.getById(createCommand.getUser());
        var taskToCreate = new Task().requestToCreate(createCommand, user);
        return taskRepository.save(taskToCreate);
    }

}
