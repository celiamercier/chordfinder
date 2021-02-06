package com.tyalis.chordfinder.utils;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class CollectionUtilsTest {

    @Test
    void should_compute_intersection() {
        assertThat(CollectionUtils.numberOfElementContainedIn(
                Set.of("a", "b", "c"),
                Set.of("c", "d", "e", "f")
        )).isEqualTo(1);

       assertThat(CollectionUtils.numberOfElementContainedIn(
               Set.of("a", "b", "c"),
               Set.of("a", "b")
        )).isEqualTo(2);

        assertThat(CollectionUtils.numberOfElementContainedIn(
                Set.of("a", "b", "c"),
                Set.of("a", "b", "c")
        )).isEqualTo(3);

        assertThat(CollectionUtils.numberOfElementContainedIn(
                Set.of("a", "b", "c"),
                Set.of("d", "e", "f")
        )).isEqualTo(0);
    }
}
