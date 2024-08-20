package com.mindhub.todolist.infrastructure.beanConfiguration.user;

import com.mindhub.todolist.domain.user.port.dao.UserDao;
import com.mindhub.todolist.domain.user.port.repository.IUserRepository;
import com.mindhub.todolist.domain.user.service.*;
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

    @Bean
    public UserDeleteService userDeleteService(UserDao userDao, IUserRepository userRepository) {
        return new UserDeleteService(userDao, userRepository);
    }

    @Bean
    public UserEditService userEditService(UserDao userDao, IUserRepository userRepository) {
        return new UserEditService(userDao, userRepository);
    }

    @Bean
    public UserByUsernameService userByUsernameService(UserDao userDao) {
        return new UserByUsernameService(userDao);
    }

}
