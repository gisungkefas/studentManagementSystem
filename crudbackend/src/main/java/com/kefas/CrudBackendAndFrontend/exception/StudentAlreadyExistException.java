package com.kefas.CrudBackendAndFrontend.exception;

public class StudentAlreadyExistException extends RuntimeException{

    public StudentAlreadyExistException(String message) {
        super(message);
    }
}
