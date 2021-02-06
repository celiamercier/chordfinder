package com.tyalis.chordfinder.service.model;

import java.util.Comparator;
import java.util.List;

public class ChordResult implements Comparable<ChordResult> {

    private Permutation permutation;
    private List<EvaluatedChordDefinition> possibleChords;
    private int score;

    private ChordResult(Permutation permutation, List<EvaluatedChordDefinition> possibleChords, int score) {
        this.permutation = permutation;
        this.possibleChords = possibleChords;
        this.score = score;
    }

    public Permutation getPermutation() {
        return permutation;
    }

    public List<EvaluatedChordDefinition> getPossibleChords() {
        return possibleChords;
    }

    public int getScore() {
        return score;
    }

    @Override
    public int compareTo(ChordResult o) {
        if (this.score - o.getScore() > 0) {
            return 1;
        } else if (this.score - o.getScore() < 0) {
            return -1;
        }
        return 0;
    }


    public static final class Builder {
        private Permutation permutation;
        private List<EvaluatedChordDefinition> possibleChords;
        private int score;

        public static Builder builder() {
            return new Builder();
        }

        public Builder permutation(Permutation permutation) {
            this.permutation = permutation;
            return this;
        }

        public Builder possibleChords(List<EvaluatedChordDefinition> possibleChords) {
            this.possibleChords = possibleChords;
            return this;
        }

        public Builder score(int score) {
            this.score = score;
            return this;
        }

        public ChordResult build() {
            this.possibleChords.sort(Comparator.reverseOrder());
            ChordResult chordResult = new ChordResult(permutation, possibleChords, score);
            return chordResult;
        }
    }
}
