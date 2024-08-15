package com.mindhub.todolist.infrastrcuture.user.rest.Controller;

import com.mindhub.todolist.application.user.query.UserAllHandler;
import com.mindhub.todolist.application.user.query.UserByIdHandler;
import com.mindhub.todolist.domain.user.model.dto.UserDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
@Tag(name = "User")
public class UserQueryController {

    private final UserAllHandler userAllHandler;
    private final UserByIdHandler userByIdHandler;

    public UserQueryController(UserAllHandler userAllHandler, UserByIdHandler userByIdHandler) {
        this.userAllHandler = userAllHandler;
        this.userByIdHandler = userByIdHandler;
    }

    @GetMapping
    @Operation(summary = "Get all users")
    public List<UserDto> getAll() {
        return userAllHandler.execute();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get user by id")
    public UserDto getById(@PathVariable Long id) {
        return userByIdHandler.execute(id);
    }

}
