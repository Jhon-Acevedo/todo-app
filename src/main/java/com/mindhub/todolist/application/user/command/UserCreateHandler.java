package com.mindhub.todolist.application.user.command;

import com.mindhub.todolist.application.user.mapper.UserDtoMapper;
import com.mindhub.todolist.domain.user.model.dto.UserDto;
import com.mindhub.todolist.domain.user.model.dto.command.UserCreateCommand;
import com.mindhub.todolist.domain.user.service.UserCreateService;
import org.springframework.stereotype.Component;

@Component
public class UserCreateHandler {

    private final UserCreateService userCreateService;
    private final UserDtoMapper userMapper;

    public UserCreateHandler(UserCreateService userCreateService, UserDtoMapper userMapper) {
        this.userCreateService = userCreateService;
        this.userMapper = userMapper;
    }

    public UserDto execute(UserCreateCommand userCreateCommand) {
        return userMapper.toDto(userCreateService.execute(userCreateCommand));
    }

}
