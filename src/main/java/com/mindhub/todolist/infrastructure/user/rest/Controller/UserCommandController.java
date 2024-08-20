package com.mindhub.todolist.infrastructure.user.rest.Controller;

import com.mindhub.todolist.application.user.command.UserCreateHandler;
import com.mindhub.todolist.application.user.command.UserDeleteHandler;
import com.mindhub.todolist.application.user.command.UserEditHandler;
import com.mindhub.todolist.domain.user.model.dto.UserDto;
import com.mindhub.todolist.domain.user.model.dto.command.UserCreateCommand;
import com.mindhub.todolist.domain.user.model.dto.command.UserEditCommand;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Tag(name = "User")
@AllArgsConstructor
public class UserCommandController {

//    private final UserCreateHandler userCreateHandler;
    private final UserEditHandler userEditHandler;
    private final UserDeleteHandler userDeleteHandler;

//    @PostMapping
//    @Operation(summary = "Create a new user")
//    public UserDto create(@RequestBody UserCreateCommand userCreateCommand) {
//        return userCreateHandler.execute(userCreateCommand);
//    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a user")
    public ResponseEntity<?> deleteUserById(@PathVariable Long id) {
        userDeleteHandler.execute(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Edit a user")
    public UserDto userEdit(@RequestBody UserEditCommand userEditCommand,
                            @PathVariable Long id) {
        return userEditHandler.execute(userEditCommand, id);
    }

}
