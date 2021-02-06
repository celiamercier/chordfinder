package com.tyalis.chordfinder.domain;

import com.tyalis.chordfinder.domain.exception.BadNoteFormatException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.tyalis.chordfinder.domain.Note.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class RelativeNoteTest {

    @ParameterizedTest
    @MethodSource("getCases")
    void should_parse_notes(String stringToParse, RelativeNote expectedNote) {
        assertThat(RelativeNote.parse(stringToParse)).isEqualTo(expectedNote);
    }

    @Test
    void should_throw_exception_when_bad_format() {
        assertThatExceptionOfType(BadNoteFormatException.class).isThrownBy(() -> RelativeNote.parse(""));
        assertThatExceptionOfType(BadNoteFormatException.class).isThrownBy(() -> RelativeNote.parse("D10"));
        assertThatExceptionOfType(BadNoteFormatException.class).isThrownBy(() -> RelativeNote.parse("K1"));
        assertThatExceptionOfType(BadNoteFormatException.class).isThrownBy(() -> RelativeNote.parse("CDE3"));
        assertThatExceptionOfType(BadNoteFormatException.class).isThrownBy(() -> RelativeNote.parse("D10"));
        assertThatExceptionOfType(BadNoteFormatException.class).isThrownBy(() -> RelativeNote.parse("1"));
    }

    private static Stream<Arguments> getCases() {
        return Stream.of(
                Arguments.of("  A2  ", new RelativeNote(A, 2)),
                Arguments.of("D", new RelativeNote(D, 0)),
                Arguments.of("C0", new RelativeNote(C, 0)),
                Arguments.of("C#5", new RelativeNote(C_SHARP, 5)),
                Arguments.of("D1", new RelativeNote(D, 1)),
                Arguments.of("D#2", new RelativeNote(D_SHARP, 2)),
                Arguments.of("E2", new RelativeNote(E, 2)),
                Arguments.of("F3", new RelativeNote(F, 3)),
                Arguments.of("F#8", new RelativeNote(F_SHARP, 8)),
                Arguments.of("G4", new RelativeNote(G, 4)),
                Arguments.of("G#0", new RelativeNote(G_SHARP, 0)),
                Arguments.of("A5", new RelativeNote(A, 5)),
                Arguments.of("A#9", new RelativeNote(A_SHARP, 9)),
                Arguments.of("B6", new RelativeNote(B, 6))
        );
    }
}
