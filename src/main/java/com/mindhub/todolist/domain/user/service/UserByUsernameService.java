package com.mindhub.todolist.domain.user.service;

import com.mindhub.todolist.domain.user.model.entity.User;
import com.mindhub.todolist.domain.user.port.dao.UserDao;

import java.util.Optional;

public class UserByUsernameService {

    private final UserDao userDao;

    public UserByUsernameService(UserDao userDao) {
        this.userDao = userDao;
    }

    public Optional<User> execute(String username){
        return userDao.findByUserName(username);
    }
}
