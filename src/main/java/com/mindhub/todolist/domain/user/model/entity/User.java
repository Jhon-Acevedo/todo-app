package com.mindhub.todolist.domain.user.model.entity;

import com.mindhub.todolist.domain.task.model.entity.Task;
import com.mindhub.todolist.domain.user.model.dto.command.UserCreateCommand;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@NoArgsConstructor
public class User {

    private Long id;

    @Setter
    private String username, password, email;
//    private Set<Task> tasks;

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public User(Long id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public User requestToCreate(UserCreateCommand userCreateCommand) {
       return new User(
               userCreateCommand.getUsername(),
               userCreateCommand.getPassword(),
               userCreateCommand.getEmail());
    }

}