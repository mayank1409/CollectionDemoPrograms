package io.javamasters.employeescrud.exceptions;

import lombok.Data;

@Data
public class EntityNotFoundException extends RuntimeException{
    private String message;
    public EntityNotFoundException(String message) {
        super();
        this.message = message;
    }
}
