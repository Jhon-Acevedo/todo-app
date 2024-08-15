package com.mindhub.todolist.domain.user.service;

import com.mindhub.todolist.domain.user.model.entity.User;
import com.mindhub.todolist.domain.user.port.dao.UserDao;

import java.util.List;

public class UserAllService {

    private final UserDao userDao;

    public UserAllService(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> execute() {
        return userDao.getAll();
    }
}
