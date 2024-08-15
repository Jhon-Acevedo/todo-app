package com.mindhub.todolist.domain.task.model.exception;

import lombok.Getter;

@Getter
public class TaskException extends RuntimeException{

    private String errorMessage;

    public TaskException( String errorMessage) {
        this.errorMessage = errorMessage;
    }

}
