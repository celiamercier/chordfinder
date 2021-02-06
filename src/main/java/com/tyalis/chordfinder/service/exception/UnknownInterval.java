package com.tyalis.chordfinder.service.exception;

import com.tyalis.chordfinder.domain.Note;

public class UnknownInterval extends RuntimeException {

    public UnknownInterval(Note n1, Note n2, int ordinal, int semitones) {
        super("Unknown interval between notes: " + n1 + " and " + n2 + ". Computed ordinal=" + ordinal + ", semitones=" + semitones);
    }
}
