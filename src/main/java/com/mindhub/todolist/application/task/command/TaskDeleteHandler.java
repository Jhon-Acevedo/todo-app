package com.mindhub.todolist.application.task.command;

import com.mindhub.todolist.domain.task.service.TaskDeleteService;
import org.springframework.stereotype.Component;

@Component
public class TaskDeleteHandler {

    private final TaskDeleteService taskDeleteService;

    public TaskDeleteHandler(TaskDeleteService taskDeleteService) {
        this.taskDeleteService = taskDeleteService;
    }

    public void execute(Long id) {
        taskDeleteService.execute(id);
    }
}
