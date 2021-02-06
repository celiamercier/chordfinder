package com.tyalis.chordfinder.service;

import com.tyalis.chordfinder.domain.Interval;
import com.tyalis.chordfinder.domain.Note;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.tyalis.chordfinder.domain.Interval.*;
import static com.tyalis.chordfinder.domain.Note.*;
import static org.assertj.core.api.Assertions.assertThat;

public class IntervalHelperTest {

    IntervalHelper intervalHelper = new IntervalHelper();

    @ParameterizedTest
    @MethodSource("getCases")
    void test(Note n1, Note n2, Interval expectedInterval) {
        assertThat(intervalHelper.between(n1, n2)).isEqualTo(expectedInterval);
    }

    private static Stream<Arguments> getCases() {
        return Stream.of(
                Arguments.of(E,F, m2),
                Arguments.of(C,D, M2),
                Arguments.of(C,D_SHARP, A2),

                Arguments.of(D, F, m3),
                Arguments.of(D, F_SHARP, M3),
                Arguments.of(F, A_SHARP, A3),

                Arguments.of(C, F, P4),
                Arguments.of(C, F_SHARP, A4),

                Arguments.of(B, F, d5),
                Arguments.of(C, G, P5),
                Arguments.of(C, G_SHARP, A5),

                Arguments.of(B, G, m6),
                Arguments.of(C, A, M6),
                Arguments.of(C, A_SHARP, A6),

                //Arguments.of(?,?, d7), TODO need bemol or enharmonic...
                Arguments.of(B, A, m7),
                Arguments.of(C, B, M7),
                //Arguments.of(?,?, A7), TODO need bemol or enharmonic...

                Arguments.of(C, C, P8)

                // TODO we should consider m2/m9, M2/M9, A2/A9, P4,P11
                /*Arguments.of(B, C, m9),
                Arguments.of(C, D, M9),
                Arguments.of(C, D_SHARP, A9),
                Arguments.of(C, F, P11)*/
        );
    }
}
