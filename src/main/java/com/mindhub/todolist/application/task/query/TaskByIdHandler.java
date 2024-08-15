package com.mindhub.todolist.application.task.query;

import com.mindhub.todolist.application.task.mapper.TaskDtoMapper;
import com.mindhub.todolist.domain.task.model.dto.TaskDto;
import com.mindhub.todolist.domain.task.port.dao.TaskDao;
import org.springframework.stereotype.Component;

@Component
public class TaskByIdHandler {

    private final TaskDao taskDao;
    private final TaskDtoMapper taskDtoMapper;

    public TaskByIdHandler(TaskDao taskDao, TaskDtoMapper taskDtoMapper) {
        this.taskDao = taskDao;
        this.taskDtoMapper = taskDtoMapper;
    }

    public TaskDto execute(Long id){
        return taskDtoMapper.toDto(taskDao.getById(id));
    }

}
