package com.duck.airline.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorObject> handleNotFoundException(NotFoundException ex, WebRequest request) {
        return handleException(HttpStatus.NOT_FOUND, ex);
    }

    @ExceptionHandler(InvalidDataException.class)
    public ResponseEntity<ErrorObject> handleInvalidDataException(InvalidDataException ex, WebRequest request) {
        return handleException(HttpStatus.BAD_REQUEST, ex);
    }

    @ExceptionHandler(DuplicateEntryException.class)
    public ResponseEntity<ErrorObject> handleDuplicateEntryException(DuplicateEntryException ex, WebRequest request) {
        return handleException(HttpStatus.CONFLICT, ex);
    }

    @ExceptionHandler(PermissionDeniedException.class)
    public ResponseEntity<ErrorObject> handlePermissionDeniedException(PermissionDeniedException ex, WebRequest request) {
        return handleException(HttpStatus.FORBIDDEN, ex);
    }

    @ExceptionHandler(InternalServerErrorException.class)
    public ResponseEntity<ErrorObject> handleInternalServerErrorException(InternalServerErrorException ex, WebRequest request) {
        return handleException(HttpStatus.INTERNAL_SERVER_ERROR, ex);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorObject> handleBadRequestException(BadRequestException ex, WebRequest request) {
        return handleException(HttpStatus.BAD_REQUEST, ex);
    }

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<ErrorObject> handleConflictException(ConflictException ex, WebRequest request) {
        return handleException(HttpStatus.CONFLICT, ex);
    }

    // Phương thức private để xử lý ngoại lệ chung
    private ResponseEntity<ErrorObject> handleException(HttpStatus status, RuntimeException ex) {
        ErrorObject errorObject = new ErrorObject();
        errorObject.setStatusCode(status.value());
        errorObject.setMessage(ex.getMessage());
        errorObject.setTimestamp(new Date());
        return new ResponseEntity<>(errorObject, status);
    }
}


