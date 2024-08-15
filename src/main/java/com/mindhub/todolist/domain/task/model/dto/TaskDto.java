package com.mindhub.todolist.domain.task.model.dto;

import com.mindhub.todolist.domain.user.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TaskDto {

    Long id;
    String title;
    String description;
    String status;
    User user;
}
