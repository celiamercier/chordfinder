package com.tyalis.chordfinder.domain;

public class Chord {

    private Note root;
    private ChordDefinition chordDefinition;

    public Chord(Note root, ChordDefinition chordDefinition) {
        this.root = root;
        this.chordDefinition = chordDefinition;
    }

    public Note getRoot() {
        return root;
    }

    public ChordDefinition getChordDefinition() {
        return chordDefinition;
    }

    @Override
    public String toString() {
        return root.getLabel() + chordDefinition.getLabel();
    }
}
