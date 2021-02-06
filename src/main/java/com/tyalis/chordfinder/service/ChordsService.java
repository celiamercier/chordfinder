package com.tyalis.chordfinder.service;

import com.tyalis.chordfinder.domain.ChordDefinition;
import com.tyalis.chordfinder.domain.Note;
import com.tyalis.chordfinder.domain.RelativeNote;
import com.tyalis.chordfinder.service.exception.NotEnoughNotesException;
import com.tyalis.chordfinder.service.model.ChordResult;
import com.tyalis.chordfinder.service.model.EvaluatedChordDefinition;
import com.tyalis.chordfinder.service.model.Permutation;
import com.tyalis.chordfinder.service.model.Permutations;
import com.tyalis.chordfinder.utils.Formatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.tyalis.chordfinder.utils.CollectionUtils.numberOfElementContainedIn;

@Service
public class ChordsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ChordsService.class);

    public List<ChordResult> findChords(List<RelativeNote> inputNotes) {
        Set<Note> notes = flattenNotes(inputNotes);
        if (notes.size() < 2) {
            throw new NotEnoughNotesException();
        }
        List<ChordResult> results = Permutations.of(notes).getAll().stream()
                .map(this::findChord)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        if (LOGGER.isDebugEnabled()) {
            results.stream()
                    .map(Formatter::format)
                    .forEach(LOGGER::debug);
        }

        return results;
    }

    private ChordResult findChord(Permutation permutation) {
        List<EvaluatedChordDefinition> possibleChords = new ArrayList<>();
        int bestScore = 0;

        for (ChordDefinition chordDef : ChordDefinition.values()) {
            EvaluatedChordDefinition evaluatedChord;

            int intersect = numberOfElementContainedIn(permutation.getIntervals(), chordDef.getIntervals());
            if (intersect == 0) {
                // nothing match
                continue;
            } else if (intersect == chordDef.getIntervals().size() && intersect == permutation.getIntervals().size()) {
                // exact chord match
                evaluatedChord = new EvaluatedChordDefinition(chordDef, 100);
            } else if (intersect == chordDef.getIntervals().size() && intersect < permutation.getIntervals().size()) {
                // find chord inside permutation, but there is still other notes
                evaluatedChord = new EvaluatedChordDefinition(chordDef, 50);
            } else if (intersect == chordDef.getIntervals().size() && intersect > permutation.getIntervals().size()) {
                // permutation is a part of a chord
                evaluatedChord = new EvaluatedChordDefinition(chordDef, 20);
            } else {
                /* TODO some intervals match but we could not find a whole chord in the permutation
                 * we should try to find the most likely using an heuristic */
                evaluatedChord = new EvaluatedChordDefinition(chordDef, 0);
            }

            possibleChords.add(evaluatedChord);
            if (evaluatedChord.getScore() > bestScore ) {
                bestScore = evaluatedChord.getScore();
            }
        }
        return ChordResult.Builder.builder()
                .permutation(permutation)
                .possibleChords(possibleChords)
                .score(bestScore)
                .build();
    }

    /**
     * We don't care about the level of the notes, we only need the absolute notes
     * and to remove duplicates.
     */
    private Set<Note> flattenNotes(List<RelativeNote> inputNotes) {
        return inputNotes.stream()
                .map(RelativeNote::getNote)
                .collect(Collectors.toSet());
    }
}
