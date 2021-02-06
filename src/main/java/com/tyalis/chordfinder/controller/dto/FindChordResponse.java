package com.tyalis.chordfinder.controller.dto;

import com.tyalis.chordfinder.service.model.ChordResult;

import java.util.List;

public class FindChordResponse {

    private List<String> bestChords;
    private List<ChordResult> details;

    public FindChordResponse(List<String> bestChords, List<ChordResult> details) {
        this.bestChords = bestChords;
        this.details = details;
    }

    public List<String> getBestChords() {
        return bestChords;
    }

    public void setBestChords(List<String> bestChords) {
        this.bestChords = bestChords;
    }

    public List<ChordResult> getDetails() {
        return details;
    }

    public void setDetails(List<ChordResult> details) {
        this.details = details;
    }
}
