package com.mindhub.todolist.infrastructure.user.adapter.jpa.dao;

import com.mindhub.todolist.domain.user.model.entity.User;
import com.mindhub.todolist.domain.user.model.exception.UserException;
import com.mindhub.todolist.domain.user.port.dao.UserDao;
import com.mindhub.todolist.infrastructure.user.adapter.jpa.IUserAdapterRepositoryJPA;
import com.mindhub.todolist.infrastructure.user.adapter.mapper.UserMapper;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@Transactional
public class UserH2Dao implements UserDao {

    private final IUserAdapterRepositoryJPA userAdapterRepositoryJPA;
    private final UserMapper userMapper;

    public UserH2Dao(IUserAdapterRepositoryJPA userAdapterRepositoryJPA, UserMapper userMapper) {
        this.userAdapterRepositoryJPA = userAdapterRepositoryJPA;
        this.userMapper = userMapper;
    }

    @Override
    public User getById(Long id) {
        var optionalUser = userAdapterRepositoryJPA.findById(id);

        if (optionalUser.isEmpty())
            throw new UserException(String.format("User with id %s not found", id));

        return userMapper.toDomain(optionalUser.get());
    }

    @Override
    public List<User> getAll() {
        return userAdapterRepositoryJPA.findAll()
                .stream()
                .map(userMapper::toDomain)
                .collect(Collectors.toList());
    }
}
