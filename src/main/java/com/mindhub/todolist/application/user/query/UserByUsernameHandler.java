package com.mindhub.todolist.application.user.query;

import com.mindhub.todolist.application.user.mapper.UserDtoMapper;
import com.mindhub.todolist.domain.user.model.dto.UserDto;
import com.mindhub.todolist.domain.user.service.UserByUsernameService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserByUsernameHandler {

    private final UserByUsernameService userByUsernameService;
    private final UserDtoMapper userDtoMapper;

    public UserDto execute(String username) {
        return userDtoMapper
                .toDto(userByUsernameService.execute(username).orElseThrow());
    }

}
