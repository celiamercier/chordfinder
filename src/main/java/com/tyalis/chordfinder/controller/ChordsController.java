package com.tyalis.chordfinder.controller;

import com.tyalis.chordfinder.controller.dto.FindChordRequest;
import com.tyalis.chordfinder.controller.dto.FindChordResponse;
import com.tyalis.chordfinder.domain.Chord;
import com.tyalis.chordfinder.domain.RelativeNote;
import com.tyalis.chordfinder.service.ChordsService;
import com.tyalis.chordfinder.service.model.ChordResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ChordsController {

    @Autowired
    private ChordsService chordsService;

    @PostMapping("/chords")
    FindChordResponse findChords(@RequestBody FindChordRequest request) {
        List<ChordResult> results = chordsService.findChords(map(request));
        if (results.isEmpty()) {
            return new FindChordResponse(Collections.emptyList(), Collections.emptyList());
        }
        return new FindChordResponse(getBestChords(results), results);
    }

    private List<String> getBestChords(List<ChordResult> results) {
        int bestScore = results.get(0).getScore();
        return results.stream()
                .filter(chordResult -> chordResult.getScore() == bestScore)
                .map(chordResult -> new Chord(
                        chordResult.getPermutation().getRoot(),
                        chordResult.getPossibleChords().get(0).getDefinition()))
                .map(Chord::toString)
                .collect(Collectors.toList());
    }

    private List<RelativeNote> map(FindChordRequest request) {
        return request.getNotes().stream()
                .map(RelativeNote::parse)
                .collect(Collectors.toList());
    }
}
