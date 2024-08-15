package com.mindhub.todolist.infrastrcuture.user.adapter.mapper;

import com.mindhub.todolist.domain.user.model.dto.UserDto;
import com.mindhub.todolist.domain.user.model.entity.User;
import com.mindhub.todolist.infrastrcuture.user.adapter.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toDomain(UserEntity userEntity) {
        if (userEntity == null) return null;
        return new User(
                userEntity.getId(),
                userEntity.getUsername(),
                userEntity.getPassword(),
                userEntity.getEmail()
        );
    }

    public UserEntity toEntity(User userDomain) {
        if (userDomain == null) return null;
        return new UserEntity(
                userDomain.getUsername(),
                userDomain.getPassword(),
                userDomain.getEmail()
        );
    }

    public UserEntity toCreateEntity(User userDomain) {
        if (userDomain == null) return null;
        return new UserEntity(
                userDomain.getUsername(),
                userDomain.getPassword(),
                userDomain.getEmail()
        );
    }

}
