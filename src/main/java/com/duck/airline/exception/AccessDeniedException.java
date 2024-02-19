package com.duck.airline.exception;

public class AccessDeniedException extends RuntimeException {
    public AccessDeniedException(String access_denied_for_role_admin) {
    }
}
