package com.mindhub.todolist.application.user.query;

import com.mindhub.todolist.application.user.mapper.UserDtoMapper;
import com.mindhub.todolist.domain.user.model.dto.UserDto;
import com.mindhub.todolist.domain.user.service.UserByIdService;
import org.springframework.stereotype.Component;

@Component
public class UserByIdHandler {

    private final UserByIdService userByIdService;
    private final UserDtoMapper userDtoMapper;

    public UserByIdHandler(UserByIdService userByIdService, UserDtoMapper userDtoMapper) {
        this.userByIdService = userByIdService;
        this.userDtoMapper = userDtoMapper;
    }

    public UserDto execute(Long id){
        return userDtoMapper
                .toDto(userByIdService.execute(id));
    }

}
