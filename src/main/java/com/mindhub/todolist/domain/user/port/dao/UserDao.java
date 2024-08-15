package com.mindhub.todolist.domain.user.port.dao;

import com.mindhub.todolist.domain.user.model.entity.User;

import java.util.List;

public interface UserDao {

    User getById(Long id);
    List<User> getAll();
}
