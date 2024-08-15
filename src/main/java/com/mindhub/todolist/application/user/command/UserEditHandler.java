package com.mindhub.todolist.application.user.command;

import com.mindhub.todolist.application.user.mapper.UserDtoMapper;
import com.mindhub.todolist.domain.user.model.dto.UserDto;
import com.mindhub.todolist.domain.user.model.dto.command.UserEditCommand;
import com.mindhub.todolist.domain.user.service.UserEditService;
import org.springframework.stereotype.Component;

@Component
public class UserEditHandler {

    private final UserEditService userEditService;
    private final UserDtoMapper userDtoMapper;

    public UserEditHandler(UserEditService userEditService, UserDtoMapper userDtoMapper) {
        this.userEditService = userEditService;
        this.userDtoMapper = userDtoMapper;
    }

    public UserDto execute(UserEditCommand userEditCommand, Long id) {
        return userDtoMapper.toDto(userEditService.execute(userEditCommand, id));
    }
}
