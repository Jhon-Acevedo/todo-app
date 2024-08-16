package com.mindhub.todolist.domain.task.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TaskCreateDto {
    Long id;
    String title;
    String description;
    String status;
    Long user;
}
