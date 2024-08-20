package com.mindhub.todolist.domain.user.model.dto.command;

import com.mindhub.todolist.domain.user.model.entity.Rol;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserCreateCommand{

    private String username;
    private String password;
    private String email;
    private Long rolId;

}
