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

    @Setter
    private Rol rol;

    private Set<Task> tasks;

    public User(String username, String password, String email, Rol rol) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.rol = rol;
    }

    public User(Long id, String username, String password, String email, Rol rol) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.rol = rol;
    }

    public User requestToCreate(UserCreateCommand userCreateCommand) {
        return new User(
                userCreateCommand.getUsername(),
                userCreateCommand.getPassword(),
                userCreateCommand.getEmail(),
                new Rol(userCreateCommand.getRolId(), null)
        );
    }

}