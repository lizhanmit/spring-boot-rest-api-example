package org.example.restapi.exception;

public class BookNotFoundEx extends RuntimeException {

    public BookNotFoundEx(String message) {
        super(message);
    }
}
