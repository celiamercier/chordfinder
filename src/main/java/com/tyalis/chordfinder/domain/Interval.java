package com.tyalis.chordfinder.domain;

public enum Interval {
    m2(2, 1), // minor second
    M2(2, 2), // major second
    A2(2, 3), // augmented second = m3

    m3(3, 3), // minor third = A2
    M3(3, 4), // major third
    A3(3, 5), // augmented thrid = P4

    P4(4, 5), // perfect fourth = A3
    A4(4, 6), // augmented fourth = d5

    d5(5, 6), // diminished fifth = A4
    P5(5, 7), // perfect fifth
    A5(5, 8), // augmented fifth = m6

    m6(6, 8), // minor sixth = A5
    M6(6, 9), // major sixth = d7
    A6(6, 10), // augmented sixth = m7

    d7(7, 9), // diminished seventh = M6
    m7(7, 10), // minor seventh = A6
    M7(7, 11), // major seventh
    A7(7, 12), // augmented seventh = octave

    P8(8, 12), // octave = A7

    m9(9, 13), // minor ninth
    M9(9, 14), // major ninth
    A9(9, 15), // augmented ninth

    P11(11, 17), // perfect eleventh
    ;

    Interval(int ordinal, int semitones) {
        this.ordinal = ordinal;
        this.semitones = semitones;
    }

    private int ordinal;
    private int semitones;

    public int getOrdinal() {
        return ordinal;
    }

    public int getSemitones() {
        return semitones;
    }
}
