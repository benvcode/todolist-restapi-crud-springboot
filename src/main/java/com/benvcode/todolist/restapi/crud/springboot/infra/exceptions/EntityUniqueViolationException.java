package com.benvcode.todolist.restapi.crud.springboot.infra.exceptions;

public class EntityUniqueViolationException extends RuntimeException {
    public EntityUniqueViolationException(String message) {
        super(message);
    }
}