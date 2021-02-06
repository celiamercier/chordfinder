package com.tyalis.chordfinder.service.model;

import com.tyalis.chordfinder.domain.ChordDefinition;

public class EvaluatedChordDefinition implements Comparable<EvaluatedChordDefinition> {

    private ChordDefinition definition;
    private int score;

    public EvaluatedChordDefinition(ChordDefinition definition, int score) {
        this.definition = definition;
        this.score = score;
    }

    public ChordDefinition getDefinition() {
        return definition;
    }

    public int getScore() {
        return score;
    }

    @Override
    public int compareTo(EvaluatedChordDefinition o) {
        if (this.score - o.getScore() > 0) {
            return 1;
        } else if (this.score - o.getScore() < 0) {
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "[def=" + definition + ", score=" + score + ']';
    }
}
