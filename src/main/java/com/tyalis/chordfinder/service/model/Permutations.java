package com.tyalis.chordfinder.service.model;

import com.tyalis.chordfinder.domain.Note;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations {

    private Set<Permutation> permutations;

    private Permutations(Set<Permutation> permutations) {
        this.permutations = permutations;
    }

    public static Permutations of(Set<Note> notes) {
        return new Permutations(buildPermutations(new ArrayList<>(notes)));
    }

    private static Set<Permutation> buildPermutations(List<Note> notes) {
        Set<Permutation> permutations = new HashSet<>();
        permutations.add(Permutation.Builder.builder().notes(notes).build());
        for (int i = 0; i < notes.size(); i++) {
            Collections.rotate(notes, 1);
            permutations.add(Permutation.Builder.builder().notes(notes).build());
        }
        return permutations;
    }

    public Set<Permutation> getAll() {
        return permutations;
    }
}
