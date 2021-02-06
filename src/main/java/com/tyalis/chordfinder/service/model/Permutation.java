package com.tyalis.chordfinder.service.model;

import com.tyalis.chordfinder.domain.Interval;
import com.tyalis.chordfinder.domain.Note;
import com.tyalis.chordfinder.service.IntervalHelper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Permutation {

    private List<Note> notes;
    private Set<Interval> intervals;

    private Permutation(List<Note> notes) {
        this.notes = notes;

        // compute intervals between the root note and the others
        this.intervals = new HashSet<>();
        for (int i = 1; i < notes.size(); i++) {
            intervals.add(IntervalHelper.between(getRoot(), notes.get(i)));
        }
    }

    public Note getRoot() {
        return notes.get(0);
    }

    public Note getNote(int index) {
        return notes.get(index);
    }

    public Set<Interval> getIntervals() {
        return intervals;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Permutation that = (Permutation) o;
        return Objects.equals(notes, that.notes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(notes);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < notes.size(); i++) {
            if (i > 0) {
                sb.append(",");
            }
            sb.append(notes.get(i).getLabel());
        }
        sb.append("]");
        return sb.toString();
    }

    public static final class Builder {
        private List<Note> notes = new ArrayList<>();

        public static Builder builder() {
            return new Builder();
        }

        public Builder notes(Note... notes) {
            this.notes = List.of(notes);
            return this;
        }

        public Builder notes(List<Note> notes) {
            this.notes.addAll(notes);
            return this;
        }

        public Permutation build() {
            return new Permutation(notes);
        }
    }
}
