package com.mindhub.todolist.infrastrcuture.user.adapter.jpa.repository;

import com.mindhub.todolist.domain.user.model.entity.User;
import com.mindhub.todolist.domain.user.port.repository.IUserRepository;
import com.mindhub.todolist.infrastrcuture.user.adapter.jpa.IUserAdapterRepositoryJPA;
import com.mindhub.todolist.infrastrcuture.user.adapter.mapper.UserMapper;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class UserH2Repository implements IUserRepository {

    private final IUserAdapterRepositoryJPA userAdapterRepositoryJPA;
    private final UserMapper userMapper;

    public UserH2Repository(IUserAdapterRepositoryJPA userAdapterRepositoryJPA, UserMapper userMapper) {
        this.userAdapterRepositoryJPA = userAdapterRepositoryJPA;
        this.userMapper = userMapper;
    }


    @Override
    public User findByUsername(String username) {
        return null;
    }

    @Override
    public User save(User user) {
        var userToSave = userMapper.toCreateEntity(user);
        var userSaved = userAdapterRepositoryJPA.save(userToSave);
        return userMapper.toDomain(userSaved);
    }

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return List.of();
    }

    @Override
    public void delete(User user) {

    }
}
