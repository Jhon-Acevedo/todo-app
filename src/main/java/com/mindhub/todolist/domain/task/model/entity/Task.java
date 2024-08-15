package com.mindhub.todolist.domain.task.model.entity;

import com.mindhub.todolist.domain.task.model.dto.command.TaskCreateCommand;
import com.mindhub.todolist.domain.user.model.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class Task {

    private Long id;
    private String title;
    private String description;
    private Status status;
    private User user;

    public Task(Long id, String title, String description, Status status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
    }

    public Task(Long id, String title, String description, Status status, User user) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.user = user;
    }

    public Task requestToCreate(TaskCreateCommand createCommand, User user) {
        return new Task(
                null,
                createCommand.getTitle(),
                createCommand.getDescription(),
                Status.PENDING,
                user
        );
    }
}
