package com.mindhub.todolist.application.task.command;

import com.mindhub.todolist.application.task.mapper.TaskCreateDtoMapper;
import com.mindhub.todolist.application.task.mapper.TaskDtoMapper;
import com.mindhub.todolist.domain.task.model.dto.TaskCreateDto;
import com.mindhub.todolist.domain.task.model.dto.TaskDto;
import com.mindhub.todolist.domain.task.model.dto.command.TaskCreateCommand;
import com.mindhub.todolist.domain.task.model.entity.Task;
import com.mindhub.todolist.domain.task.port.repository.ITaskRepository;
import com.mindhub.todolist.domain.task.service.TaskCreateService;
import org.springframework.stereotype.Component;

@Component
public class TaskCreateHandler {

    private final TaskCreateService taskCreateService;
    private final TaskCreateDtoMapper taskDtoMapper;

    public TaskCreateHandler(TaskCreateService taskCreateService, TaskCreateDtoMapper taskDtoMapper) {
        this.taskCreateService = taskCreateService;
        this.taskDtoMapper = taskDtoMapper;
    }

    public TaskCreateDto execute(TaskCreateCommand command) {
        return taskDtoMapper.toDto(taskCreateService.execute(command));
    }
}