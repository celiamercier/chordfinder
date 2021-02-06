package com.tyalis.chordfinder.domain.exception;

public class BadNoteFormatException extends RuntimeException {

    public BadNoteFormatException(String s) {
        super("Bad note format: " + s + ". Expected format is [note][level]. Example: C0 or F#2. Level is supposed to belong to [0,9].");
    }
}
