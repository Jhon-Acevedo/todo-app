package com.mindhub.todolist.application.task.mapper;

import com.mindhub.todolist.domain.task.model.dto.TaskCreateDto;
import com.mindhub.todolist.domain.task.model.dto.TaskDto;
import com.mindhub.todolist.domain.task.model.entity.Task;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
@Component
public interface TaskCreateDtoMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "status", target = "status")
    @Mapping(source = "user.id", target = "user")
    TaskCreateDto toDto(Task domain);
}
