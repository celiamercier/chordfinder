package com.tyalis.chordfinder.service;

import com.tyalis.chordfinder.domain.Interval;
import com.tyalis.chordfinder.domain.Note;
import com.tyalis.chordfinder.service.exception.UnknownInterval;
import org.springframework.stereotype.Service;

@Service
public class IntervalHelper {

    public static Interval between(Note n1, Note n2) {
        int ordinal = computeOrdinal(n1, n2);
        int semitones = computeSemitones(n1, n2);

        for (Interval interval : Interval.values()) {
            if (interval.getOrdinal() == ordinal && interval.getSemitones() == semitones) {
                return interval;
            }
        }
        throw new UnknownInterval(n1, n2, ordinal, semitones);
    }

    /**
     * Count the number of notes from n1 to n2.
     * Order is important :
     * - interval[F, B] : 4 notes
     * - interval[B, F] : 5 notes
     */
    private static int computeOrdinal(Note n1, Note n2) {
        if (n1.getBasicIndex() < n2.getBasicIndex()) {
            // ex: [F, B]
            return n2.getBasicIndex() - n1.getBasicIndex() + 1;
        } else {
            // ex: [B, F]
            return 8 - n1.getBasicIndex() + n2.getBasicIndex();
        }
    }

    /**
     * Count the number of semitones from n1 to n2.
     * Order is important :
     * - interval[G, B] : 4 semitones
     * - interval[B, G] : 5 notes
     */
    private static int computeSemitones(Note n1, Note n2) {
        if (n1.getIndex() < n2.getIndex()) {
            // ex: [G, B]
            return n2.getIndex() - n1.getIndex();
        } else {
            // ex: [B, G]
            return 12 - n1.getIndex() + n2.getIndex();
        }
    }
}
