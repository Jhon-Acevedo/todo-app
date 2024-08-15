package com.mindhub.todolist.infrastrcuture.user.rest.UserControllerAdvice;

import com.mindhub.todolist.domain.user.model.exception.UserException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserControllerAdvice {

    @ExceptionHandler(UserException.class)
    public ResponseEntity<?> handleUserEmptyException(UserException emptyUserException) {
        return new ResponseEntity<>(emptyUserException.getMessageError(), HttpStatus.NOT_FOUND);
    }

}
