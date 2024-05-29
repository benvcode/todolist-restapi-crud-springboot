package com.benvcode.todolist.restapi.crud.springboot.infra.exceptions;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String message) {
        super(message);
    }
}