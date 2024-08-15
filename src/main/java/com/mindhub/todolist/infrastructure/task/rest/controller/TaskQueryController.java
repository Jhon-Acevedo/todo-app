package com.mindhub.todolist.infrastructure.task.rest.controller;


import com.mindhub.todolist.application.task.query.TaskAllHandler;
import com.mindhub.todolist.application.task.query.TaskByIdHandler;
import com.mindhub.todolist.domain.task.model.dto.TaskDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@Tag(name = "Task")
public class TaskQueryController {

    private final TaskAllHandler taskAllHandler;
    private final TaskByIdHandler taskByIdHandler;

    public TaskQueryController(TaskAllHandler taskAllHandler, TaskByIdHandler taskByIdHandler) {
        this.taskAllHandler = taskAllHandler;
        this.taskByIdHandler = taskByIdHandler;
    }

    @GetMapping
    @Operation(summary = "Get all tasks")
    public List<TaskDto> getAll() {
        return taskAllHandler.execute();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a task by id")
    public TaskDto getById(@PathVariable Long id) {
        return taskByIdHandler.execute(id);
    }

}
