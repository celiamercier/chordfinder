package com.tyalis.chordfinder.service;

import com.tyalis.chordfinder.domain.RelativeNote;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.tyalis.chordfinder.domain.Note.A;
import static com.tyalis.chordfinder.domain.Note.D;
import static com.tyalis.chordfinder.domain.Note.E;

public class ChordsServiceITest {

    private ChordsService chordsService = new ChordsService();

    @Test
    void test() {
        chordsService.findChords(List.of(
                new RelativeNote(D, 1),
                new RelativeNote(A, 1),
                new RelativeNote(E, 1)
        ));
    }
}
