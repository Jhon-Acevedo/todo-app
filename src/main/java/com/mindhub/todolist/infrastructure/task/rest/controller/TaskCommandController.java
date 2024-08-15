package com.mindhub.todolist.infrastructure.task.rest.controller;

import com.mindhub.todolist.application.task.command.TaskCreateHandler;
import com.mindhub.todolist.application.task.command.TaskDeleteHandler;
import com.mindhub.todolist.application.task.command.TaskEditHandler;
import com.mindhub.todolist.domain.task.model.dto.TaskDto;
import com.mindhub.todolist.domain.task.model.dto.command.TaskCreateCommand;
import com.mindhub.todolist.domain.task.model.dto.command.TaskEditCommand;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
@Tag(name = "Task")
public class TaskCommandController {

    private final TaskCreateHandler taskCreateHandler;
    private final TaskEditHandler taskEditHandler;
    private final TaskDeleteHandler taskDeleteHandler;

    public TaskCommandController(TaskCreateHandler taskCreateHandler, TaskEditHandler taskEditHandler, TaskDeleteHandler taskDeleteHandler) {
        this.taskCreateHandler = taskCreateHandler;
        this.taskEditHandler = taskEditHandler;
        this.taskDeleteHandler = taskDeleteHandler;
    }


    @PostMapping
    @Operation(summary = "Create a new task")
    public TaskDto create(@RequestBody TaskCreateCommand createCommand) {
        return taskCreateHandler.execute(createCommand);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Edit a task", description = "STATUS:  PENDING,\n" +
            "    IN_PROGRESS,\n" +
            "    COMPLETED")
    public TaskDto edit(@RequestBody TaskEditCommand taskEditCommand, @PathVariable Long id) {
        return taskEditHandler.execute(taskEditCommand, id);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a task")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        taskDeleteHandler.execute(id);
        return ResponseEntity.noContent().build();
    }

}
