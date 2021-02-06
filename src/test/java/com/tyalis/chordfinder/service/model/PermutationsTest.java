package com.tyalis.chordfinder.service.model;

import com.tyalis.chordfinder.domain.Note;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Stream;

import static com.tyalis.chordfinder.domain.Note.A;
import static com.tyalis.chordfinder.domain.Note.B;
import static com.tyalis.chordfinder.domain.Note.C;
import static com.tyalis.chordfinder.domain.Note.D;
import static com.tyalis.chordfinder.domain.Note.E;
import static com.tyalis.chordfinder.domain.Note.F;
import static com.tyalis.chordfinder.domain.Note.G;
import static org.assertj.core.api.Assertions.assertThat;

public class PermutationsTest {

    @Test
    void should_the_right_create_permutations_from_3_elements() {
        Permutations permutations = Permutations.of(new LinkedHashSet<>(List.of(C, D, E)));

        assertThat(permutations.getAll()).containsExactlyInAnyOrder(
                Permutation.Builder.builder().notes(C, D, E).build(),
                Permutation.Builder.builder().notes(D, E, C).build(),
                Permutation.Builder.builder().notes(E, C, D).build()
        );
    }

    @ParameterizedTest
    @MethodSource("getCases")
    void should_create_permutations_for_each_root_note(List<Note> notes) {
        Permutations permutations = Permutations.of(new HashSet<>(notes));

        assertThat(permutations.getAll().size()).isEqualTo(notes.size());
        assertThat(permutations.getAll())
                .extracting(Permutation::getRoot)
                .containsExactlyInAnyOrderElementsOf(notes);
    }

    private static Stream<Arguments> getCases() {
        return Stream.of(
                Arguments.of(List.of(C, D)),
                Arguments.of(List.of(C, D, E)),
                Arguments.of(List.of(C, D, E, F)),
                Arguments.of(List.of(C, D, E, F, G)),
                Arguments.of(List.of(C, D, E, F, G, A)),
                Arguments.of(List.of(C, D, E, F, G, A, B))
        );
    }
}
