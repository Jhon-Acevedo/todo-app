package com.mindhub.todolist.application.task.command;

import com.mindhub.todolist.application.task.mapper.TaskDtoMapper;
import com.mindhub.todolist.domain.task.model.dto.TaskDto;
import com.mindhub.todolist.domain.task.model.dto.command.TaskEditCommand;
import com.mindhub.todolist.domain.task.service.TaskEditService;
import org.springframework.stereotype.Component;

@Component
public class TaskEditHandler {

    private final TaskEditService taskEditService;
    private final TaskDtoMapper taskDtoMapper;

    public TaskEditHandler(TaskEditService taskEditService, TaskDtoMapper taskDtoMapper) {
        this.taskEditService = taskEditService;
        this.taskDtoMapper = taskDtoMapper;
    }

    public TaskDto execute(TaskEditCommand taskEditCommand, Long id) {
        return taskDtoMapper.toDto(taskEditService.execute(taskEditCommand, id));
    }
}
