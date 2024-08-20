package com.mindhub.todolist.domain.user.service;

import com.mindhub.todolist.domain.user.model.dto.command.UserEditCommand;
import com.mindhub.todolist.domain.user.model.entity.Rol;
import com.mindhub.todolist.domain.user.model.entity.User;
import com.mindhub.todolist.domain.user.port.dao.UserDao;
import com.mindhub.todolist.domain.user.port.repository.IUserRepository;

public class UserEditService {

    private final UserDao userDao;
    private final IUserRepository userRepository;

    public UserEditService(UserDao userDao, IUserRepository userRepository) {
        this.userDao = userDao;
        this.userRepository = userRepository;
    }

    public User execute(UserEditCommand userEditCommand, Long id) {
        var currentUser = userDao.getById(id);

        var taskToUpdate = new User(
                currentUser.getId(),
                userEditCommand.getUsername(),
                userEditCommand.getPassword(),
                userEditCommand.getEmail(),
                currentUser.getRol()
        );
        return userRepository.update(taskToUpdate);
    }

}
