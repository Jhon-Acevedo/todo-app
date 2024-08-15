package com.mindhub.todolist.infrastructure.beanConfiguration.task;

import com.mindhub.todolist.domain.task.port.dao.TaskDao;
import com.mindhub.todolist.domain.task.port.repository.ITaskRepository;
import com.mindhub.todolist.domain.task.service.TaskCreateService;
import com.mindhub.todolist.domain.task.service.TaskDeleteService;
import com.mindhub.todolist.domain.task.service.TaskEditService;
import com.mindhub.todolist.domain.user.port.dao.UserDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TaskBean {

    @Bean
    public TaskCreateService taskCreateService(ITaskRepository taskRepository, UserDao userDao) {
        return new TaskCreateService(taskRepository, userDao);
    }

    @Bean
    public TaskDeleteService taskDeleteService(ITaskRepository taskRepository, TaskDao taskDao) {
        return new TaskDeleteService(taskRepository, taskDao);
    }

    @Bean
    public TaskEditService taskEditService(TaskDao taskDao, ITaskRepository taskRepository) {
        return new TaskEditService(taskDao, taskRepository);
    }

}
