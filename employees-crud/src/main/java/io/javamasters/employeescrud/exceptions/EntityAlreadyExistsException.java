package io.javamasters.employeescrud.exceptions;

import lombok.Data;

@Data
public class EntityAlreadyExistsException extends RuntimeException{
    private String message;
    public EntityAlreadyExistsException(String message) {
        super();
        this.message = message;
    }
}
