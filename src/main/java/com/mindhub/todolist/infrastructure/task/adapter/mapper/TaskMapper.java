package com.mindhub.todolist.infrastructure.task.adapter.mapper;

import com.mindhub.todolist.domain.task.model.entity.Task;
import com.mindhub.todolist.domain.user.model.entity.User;
import com.mindhub.todolist.infrastructure.task.adapter.entity.TaskEntity;
import com.mindhub.todolist.infrastructure.user.adapter.entity.UserEntity;
import com.mindhub.todolist.infrastructure.user.adapter.mapper.UserMapper;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {

    private final UserMapper userMapper;

    public TaskMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public Task toDomain(TaskEntity entity){
        if(entity == null) return null;
        User user = userMapper.toDomain(entity.getUserEntity());
        return new Task(
                entity.getId(),
                entity.getTitle(),
                entity.getDescription(),
                entity.getStatus(),
                user
        );
    }

    public TaskEntity toEntity(Task domain){
        if(domain == null) return null;
        UserEntity userEntity = userMapper.toEntity(domain.getUser());
        return new TaskEntity(
                domain.getId(),
                domain.getTitle(),
                domain.getDescription(),
                domain.getStatus(),
                userEntity
        );
    }

    public TaskEntity toCreateEntity(Task domain){
        if(domain == null) return null;
        UserEntity userEntity = userMapper.toEntity(domain.getUser());
        return new TaskEntity(
                domain.getTitle(),
                domain.getDescription(),
                domain.getStatus(),
                userEntity
        );
    }

}
