package com.mindhub.todolist.domain.task.model.dto.command;

import com.mindhub.todolist.domain.task.model.entity.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TaskEditCommand {

    private String title;
    private String description;
    private Status status;
}
