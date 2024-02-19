package com.duck.airline.exception;

public class InternalServerErrorException extends RuntimeException{
    public InternalServerErrorException(String message) {
        super(message);
    }

    public InternalServerErrorException(String internal_server_error_occurred, Exception e) {
    }
}
