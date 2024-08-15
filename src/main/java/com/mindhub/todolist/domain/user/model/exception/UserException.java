package com.mindhub.todolist.domain.user.model.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class UserException extends RuntimeException {

    private String messageError;

}
