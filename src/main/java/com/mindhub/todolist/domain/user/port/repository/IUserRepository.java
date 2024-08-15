package com.mindhub.todolist.domain.user.port.repository;

import com.mindhub.todolist.domain.user.model.entity.User;

import java.util.List;

public interface IUserRepository {
    User findByUsername(String username);

    User save(User user);

    User findById(Long id);

    List<User> findAll();

    void delete(User user);
}
