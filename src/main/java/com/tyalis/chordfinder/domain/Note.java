package com.tyalis.chordfinder.domain;

public enum Note {
    C(0, 0, "C"),
    C_SHARP(1, 0, "C#"),
    D(2, 1, "D"),
    D_SHARP(3, 1, "D#"),
    E(4, 2, "E"),
    F(5, 3, "F"),
    F_SHARP(6, 3, "F#"),
    G(7, 4, "G"),
    G_SHARP(8, 4, "G#"),
    A(9, 5, "A"),
    A_SHARP(10, 5, "A#"),
    B(11, 6, "B");

    Note(int index, int basicIndex, String label) {
        this.index = index;
        this.basicIndex = basicIndex;
        this.label = label;
    }

    private int index;
    private int basicIndex;
    private String label;

    public String getLabel() {
        return label;
    }

    public int getIndex() {
        return index;
    }

    public int getBasicIndex() {
        return basicIndex;
    }

    @Override
    public String toString() {
        return label;
    }
}
