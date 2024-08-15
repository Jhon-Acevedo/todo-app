package com.mindhub.todolist.infrastructure.user.adapter.jpa.repository;

import com.mindhub.todolist.domain.user.model.entity.User;
import com.mindhub.todolist.domain.user.port.repository.IUserRepository;
import com.mindhub.todolist.infrastructure.user.adapter.jpa.IUserAdapterRepositoryJPA;
import com.mindhub.todolist.infrastructure.user.adapter.mapper.UserMapper;
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
    public User save(User user) {
        var userToSave = userMapper.toCreateEntity(user);
        var userSaved = userAdapterRepositoryJPA.save(userToSave);
        return userMapper.toDomain(userSaved);
    }

    @Override
    public void deleteById(Long id) {
        userAdapterRepositoryJPA.deleteById(id);
    }

    @Override
    public User update(User user) {
        var userToUpdate = userMapper.toEntity(user);
        var userUpdated = userAdapterRepositoryJPA.save(userToUpdate);
        System.out.println("UserH2Repository.update" + userUpdated);
        return userMapper.toDomain(userUpdated);
    }

}
