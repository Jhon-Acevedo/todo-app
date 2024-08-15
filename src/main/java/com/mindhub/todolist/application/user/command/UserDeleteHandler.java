package com.mindhub.todolist.application.user.command;

import com.mindhub.todolist.domain.user.service.UserDeleteService;
import org.springframework.stereotype.Component;

@Component
public class UserDeleteHandler {

    private final UserDeleteService userDeleteService;

    public UserDeleteHandler(UserDeleteService userDeleteService) {
        this.userDeleteService = userDeleteService;
    }

    public void execute(Long id){
        userDeleteService.execute(id);
    }

}
