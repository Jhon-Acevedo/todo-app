package com.mindhub.todolist.infrastrcuture.beanConfiguration.user;

import com.mindhub.todolist.domain.user.port.dao.UserDao;
import com.mindhub.todolist.domain.user.port.repository.IUserRepository;
import com.mindhub.todolist.domain.user.service.UserAllService;
import com.mindhub.todolist.domain.user.service.UserByIdService;
import com.mindhub.todolist.domain.user.service.UserCreateService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserBean {

    @Bean
    public UserCreateService userCreateService(IUserRepository userRepository) {
        return new UserCreateService(userRepository);
    }

    @Bean
    public UserAllService userAllService(UserDao userDao) {
        return new UserAllService(userDao);
    }

    @Bean
    public UserByIdService userByIdService(UserDao userDao) {
        return new UserByIdService(userDao);
    }

}
