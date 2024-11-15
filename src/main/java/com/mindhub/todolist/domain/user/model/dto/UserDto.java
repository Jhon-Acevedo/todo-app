package com.mindhub.todolist.domain.user.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDto{

    private Long id;
    private String username;
    private String password;
    private String email;
    private String rol;
}
