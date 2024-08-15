package com.mindhub.todolist.domain.user.service;

import com.mindhub.todolist.domain.user.port.dao.UserDao;
import com.mindhub.todolist.domain.user.port.repository.IUserRepository;

public class UserDeleteService {

    private final UserDao userDao;
    private final IUserRepository userRepository;

    public UserDeleteService(UserDao userDao, IUserRepository userRepository) {
        this.userDao = userDao;
        this.userRepository = userRepository;
    }

    public void execute(Long id){
        var user = userDao.getById(id);
        userRepository.deleteById(user.getId());
    }

}
