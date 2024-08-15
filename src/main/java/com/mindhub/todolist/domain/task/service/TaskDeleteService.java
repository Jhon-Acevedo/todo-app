package com.mindhub.todolist.domain.task.service;

import com.mindhub.todolist.domain.task.port.dao.TaskDao;
import com.mindhub.todolist.domain.task.port.repository.ITaskRepository;

public class TaskDeleteService {

    private final ITaskRepository taskRepository;
    private final TaskDao taskDao;

    public TaskDeleteService(ITaskRepository taskRepository, TaskDao taskDao) {
        this.taskRepository = taskRepository;
        this.taskDao = taskDao;
    }

    public void execute(Long id){
        var task = taskDao.getById(id);
        taskRepository.deleteById(task.getId());
    }

}
