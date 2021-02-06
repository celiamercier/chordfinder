package com.tyalis.chordfinder.service.exception;

public class NotEnoughNotesException extends RuntimeException {

    public NotEnoughNotesException() {
        super("At least 3 notes are required to make a chord.");
    }
}
