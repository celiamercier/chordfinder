package com.tyalis.chordfinder.domain;

import java.util.Set;

import static com.tyalis.chordfinder.domain.Interval.A5;
import static com.tyalis.chordfinder.domain.Interval.M2;
import static com.tyalis.chordfinder.domain.Interval.M3;
import static com.tyalis.chordfinder.domain.Interval.M6;
import static com.tyalis.chordfinder.domain.Interval.M7;
import static com.tyalis.chordfinder.domain.Interval.M9;
import static com.tyalis.chordfinder.domain.Interval.P4;
import static com.tyalis.chordfinder.domain.Interval.P5;
import static com.tyalis.chordfinder.domain.Interval.d5;
import static com.tyalis.chordfinder.domain.Interval.d7;
import static com.tyalis.chordfinder.domain.Interval.m3;
import static com.tyalis.chordfinder.domain.Interval.m7;
import static com.tyalis.chordfinder.domain.Interval.m9;

public enum ChordDefinition {

    MAJOR("", M3, P5),
    MINOR("m", m3, P5),

    DIMINISHED("dim", m3, d5),
    MAJOR_DIMINISHED_FIFTH("(b5)", M3, d5),

    AUGMENTED("+", M3, A5),

    SUSPENDED_2("sus2", M2, P5),
    SUSPENDED_4("sus4", P4, P5),

    SEVENTH("7", M3, P5, m7),
    MAJOR_SEVENTH("maj7", M3, P5, M7),
    MINOR_SEVENTH("m7", m3, P5, m7),
    MINOR_MAJOR_SEVENTH("m(maj7)", m3, P5, M7),
    SEVENTH_DIMINISHED_FIFTH("7(b5)", M3, d5, m7),
    MINOR_SEVENTH_DIMINISHED_FIFTH("m7(b5)", m3, d5, m7),
    SEVENTH_DIMINISHED("dim7", m3, d5, d7),
    SEVENTH_AUGMENTED("+7", M3, A5, m7),
    MAJOR_SEVENTH_AUGMENTED("7M(#5)", M3, A5, M7),

    MAJOR_SIXTH("6", M3, P5, M6),
    MINOR_SIXTH("m6", m3, P5, M6),

    NINTH("9", M3, P5, m7, M9),
    MINOR_NINTH("m9", m3, P5, m7, M9),
    MAJOR_SEVENTH_NINTH("7M9", M3, P5, M7, M9),
    MINOR_NINTH_OF_DOMINATE("7b9", M3, P5, m7, m9), // TODO find a label...
    MINOR_MINOR_NINTH("m7b9", m3, P5, m7, m9), // TODO find a label...
    MINOR_NINTH_DIMINISHED_FIFTH("7b9(b5)", m3, d5, m7, m9), // TODO find a label...
    ;

    ChordDefinition(String label, Interval... intervals) {
        this.label = label;
        this.intervals = Set.of(intervals);
    }

    private Set<Interval> intervals;
    private String label;

    public Set<Interval> getIntervals() {
        return intervals;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return label;
    }
}
