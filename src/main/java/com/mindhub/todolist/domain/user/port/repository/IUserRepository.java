package com.mindhub.todolist.domain.user.port.repository;

import com.mindhub.todolist.domain.user.model.entity.User;

import java.util.List;
import java.util.Optional;

public interface IUserRepository {

    User save(User user);

    void deleteById(Long id);

    User update(User user);
}
