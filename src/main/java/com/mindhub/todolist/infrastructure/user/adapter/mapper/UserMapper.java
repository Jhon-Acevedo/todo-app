package com.mindhub.todolist.infrastructure.user.adapter.mapper;

import com.mindhub.todolist.domain.user.model.entity.Rol;
import com.mindhub.todolist.domain.user.model.entity.User;
import com.mindhub.todolist.infrastructure.user.adapter.entity.RolEntity;
import com.mindhub.todolist.infrastructure.user.adapter.entity.UserEntity;
import com.mindhub.todolist.infrastructure.user.adapter.jpa.IRolAdapterRepositoryJPA;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserMapper {

    private IRolAdapterRepositoryJPA rolRepository;

    public User toDomain(UserEntity userEntity) {
        if (userEntity == null) return null;
        return new User(
                userEntity.getId(),
                userEntity.getUsername(),
                userEntity.getPassword(),
                userEntity.getEmail(),
                toDomain(userEntity.getRol())
        );
    }

    public UserEntity toEntity(User userDomain) {
        if (userDomain == null) return null;
        return new UserEntity(
                userDomain.getId(),
                userDomain.getUsername(),
                userDomain.getPassword(),
                userDomain.getEmail(),
                toEntity(userDomain.getRol())
        );
    }

    public UserEntity toCreateEntity(User userDomain) {
        if (userDomain == null) return null;
        return new UserEntity(
                userDomain.getUsername(),
                userDomain.getPassword(),
                userDomain.getEmail(),
                rolRepository.findById(userDomain.getRol().getId()).orElse(null)
        );
    }

    private Rol toDomain(RolEntity rolEntity) {
        if (rolEntity == null) return null;
        return new Rol(
                rolEntity.getId(),
                rolEntity.getName()
        );
    }

    private RolEntity toEntity(Rol rol) {
        if (rol == null) return null;
        return new RolEntity(
                rol.getId(),
                rol.getName()
        );
    }
}
