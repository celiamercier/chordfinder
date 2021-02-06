package com.tyalis.chordfinder.utils;

import com.tyalis.chordfinder.domain.Chord;
import com.tyalis.chordfinder.domain.Note;
import com.tyalis.chordfinder.service.model.ChordResult;
import com.tyalis.chordfinder.service.model.EvaluatedChordDefinition;

public class Formatter {

    public static String format(ChordResult chordResult) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n===========================\n");
        sb.append(chordResult.getPermutation());
        sb.append("\nroot: " + chordResult.getPermutation().getRoot());
        sb.append("\nintervals: " + chordResult.getPermutation().getIntervals());
        sb.append("\nbestScore: " + chordResult.getScore());
        sb.append("\ncandidates: ");
        for (EvaluatedChordDefinition candidate : chordResult.getPossibleChords()) {
            sb.append("\n\t").append(format(chordResult.getPermutation().getRoot(), candidate));
        }
        sb.append("\n===========================\n");
        return sb.toString();
    }

    private static String format(Note root, EvaluatedChordDefinition evaluatedChord) {
        Chord chord = new Chord(root, evaluatedChord.getDefinition());
        StringBuilder sb = new StringBuilder();
        sb.append(chord).append(" = ").append(evaluatedChord.getScore());
        sb.append("\t\t(intervals=").append(evaluatedChord.getDefinition().getIntervals()).append(")");
        return sb.toString();
    }
}
