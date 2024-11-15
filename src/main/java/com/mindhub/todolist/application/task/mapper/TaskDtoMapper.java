package com.mindhub.todolist.application.task.mapper;

import com.mindhub.todolist.domain.task.model.dto.TaskDto;
import com.mindhub.todolist.domain.task.model.entity.Task;
import com.mindhub.todolist.domain.user.model.dto.UserIdDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface TaskDtoMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "status", target = "status")
    TaskDto toDto(Task domain);

}
