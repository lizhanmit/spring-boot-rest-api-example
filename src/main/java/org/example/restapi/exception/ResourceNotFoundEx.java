package org.example.restapi.exception;

public class ResourceNotFoundEx extends RuntimeException {

    public ResourceNotFoundEx(String message) {
        super(message);
    }
}
