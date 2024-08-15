package com.mindhub.todolist.application.task.query;

import com.mindhub.todolist.application.task.mapper.TaskDtoMapper;
import com.mindhub.todolist.domain.task.model.dto.TaskDto;
import com.mindhub.todolist.domain.task.port.dao.TaskDao;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TaskAllHandler {

    private final TaskDao taskDao;
    private final TaskDtoMapper taskDtoMapper;


    public TaskAllHandler(TaskDao taskDao, TaskDtoMapper taskDtoMapper) {
        this.taskDao = taskDao;
        this.taskDtoMapper = taskDtoMapper;
    }

    public List<TaskDto> execute() {
        return taskDao.getAll()
                .stream()
                .map(taskDtoMapper::toDto)
                .collect(Collectors.toList());
    }
}
