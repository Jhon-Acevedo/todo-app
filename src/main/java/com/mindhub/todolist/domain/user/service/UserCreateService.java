package com.mindhub.todolist.domain.user.service;

import com.mindhub.todolist.domain.user.model.dto.command.UserCreateCommand;
import com.mindhub.todolist.domain.user.model.entity.User;
import com.mindhub.todolist.domain.user.port.repository.IUserRepository;
import com.mindhub.todolist.infrastructure.user.adapter.jpa.IRolAdapterRepositoryJPA;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserCreateService {

    private final IUserRepository userRepository;

    public UserCreateService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User execute(UserCreateCommand userCreateCommand) {
        var userToCreate = new User().requestToCreate(userCreateCommand);
        userToCreate.setPassword(new BCryptPasswordEncoder().encode(userToCreate.getPassword()));
        return userRepository.save(userToCreate);
    }

}
