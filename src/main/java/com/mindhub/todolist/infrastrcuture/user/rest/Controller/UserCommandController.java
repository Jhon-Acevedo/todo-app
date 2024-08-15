package com.mindhub.todolist.infrastrcuture.user.rest.Controller;

import com.mindhub.todolist.application.user.command.UserCreateHandler;
import com.mindhub.todolist.domain.user.model.dto.UserDto;
import com.mindhub.todolist.domain.user.model.dto.command.UserCreateCommand;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@Tag(name = "User")
public class UserCommandController {

    private final UserCreateHandler userCreateHandler;

    public UserCommandController(UserCreateHandler userCreateHandler) {
        this.userCreateHandler = userCreateHandler;
    }

    @PostMapping
    @Operation(summary = "Create a new user")
    public UserDto create(@RequestBody UserCreateCommand userCreateCommand) {
        return userCreateHandler.execute(userCreateCommand);
    }


}
