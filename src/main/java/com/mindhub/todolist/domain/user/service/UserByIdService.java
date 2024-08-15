package com.mindhub.todolist.domain.user.service;

import com.mindhub.todolist.domain.user.model.entity.User;
import com.mindhub.todolist.domain.user.port.dao.UserDao;

public class UserByIdService {

    private final UserDao userDao;

    public UserByIdService(UserDao userDao) {
        this.userDao = userDao;
    }

    public User execute(Long id){
        return userDao.getById(id);
    }
}
