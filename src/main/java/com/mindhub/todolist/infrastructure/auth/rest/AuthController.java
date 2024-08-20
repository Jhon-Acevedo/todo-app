package com.mindhub.todolist.infrastructure.auth.rest;

import com.mindhub.todolist.application.user.command.UserCreateHandler;
import com.mindhub.todolist.domain.user.model.dto.UserDto;
import com.mindhub.todolist.domain.user.model.dto.command.UserCreateCommand;
import com.mindhub.todolist.infrastructure.auth.config.JwtUtils;
import com.mindhub.todolist.infrastructure.auth.rest.dto.LoginUser;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@Tag(name = "Auth")
@AllArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtil;
    private final UserCreateHandler userCreateHandler;

    @PostMapping("/login")
    @Operation(summary = "Login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginUser loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.username(),
                        loginRequest.password()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtil.generateClaims(authentication.getName());
        Map<String, String> response = new HashMap<>();
        response.put("token", jwt);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    @Operation(summary = "Create a new user")
    public ResponseEntity<?> create(@RequestBody UserCreateCommand userCreateCommand) {
        var response = userCreateHandler.execute(userCreateCommand);
        return new ResponseEntity<>(response, ResponseEntity.status(201).build().getStatusCode());
    }
}
