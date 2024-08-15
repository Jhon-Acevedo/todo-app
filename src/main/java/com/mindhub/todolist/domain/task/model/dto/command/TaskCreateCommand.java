package com.mindhub.todolist.domain.task.model.dto.command;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TaskCreateCommand {

    private String title;
    private String description;
    private String status;

}
