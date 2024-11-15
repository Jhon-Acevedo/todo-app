package com.mindhub.todolist.application.user.query;

import com.mindhub.todolist.application.user.mapper.UserDtoMapper;
import com.mindhub.todolist.domain.user.model.dto.UserDto;
import com.mindhub.todolist.domain.user.service.UserAllService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserAllHandler {

    private final UserAllService userAllService;
    private final UserDtoMapper userDtoMapper;

    public UserAllHandler(UserAllService userAllService, UserDtoMapper userDtoMapper) {
        this.userAllService = userAllService;
        this.userDtoMapper = userDtoMapper;
    }

    public List<UserDto> execute() {
        return userAllService.execute()
                .stream()
                .map(userDtoMapper::toDto)
                .collect(Collectors.toList());
    }
}
