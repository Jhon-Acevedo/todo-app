package com.mindhub.todolist.infrastructure.task.rest.advice;

import com.mindhub.todolist.domain.task.model.exception.TaskException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TaskControllerAdvice {

    @ExceptionHandler(TaskException.class)
    public ResponseEntity<String> handleEmptyInput(TaskException emptyInputException){
        return new ResponseEntity<>(emptyInputException.getErrorMessage(), HttpStatus.NOT_FOUND);
    }
}
