package com.tyalis.chordfinder.controller.dto;

import java.util.List;

public class FindChordRequest {

    private List<String> notes;

    public FindChordRequest() {
    }

    public List<String> getNotes() {
        return notes;
    }

    public void setNotes(List<String> notes) {
        this.notes = notes;
    }
}
