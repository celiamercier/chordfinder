package com.tyalis.chordfinder.domain;

import com.tyalis.chordfinder.domain.exception.BadNoteFormatException;

import java.util.Objects;

public class RelativeNote {

    private Note note;
    private int level;

    public RelativeNote(Note note, int level) {
        this.note = note;
        this.level = level;
    }

    public Note getNote() {
        return note;
    }

    public int getLevel() {
        return level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RelativeNote that = (RelativeNote) o;
        return level == that.level &&
                note == that.note;
    }

    @Override
    public int hashCode() {
        return Objects.hash(note, level);
    }

    @Override
    public String toString() {
        return note.toString() + level;
    }

    public static RelativeNote parse(String s) {
        s = s.trim();
        Note baseNote = parseBaseNote(s);
        String remaining = s.substring(baseNote.getLabel().length());
        if (remaining.isEmpty()) {
            return new RelativeNote(baseNote, 0);
        }

        try {
            int level = Integer.parseInt(remaining);
            if (level > 9 || level < 0) {
                throw new BadNoteFormatException(s);
            }
            return new RelativeNote(baseNote, level);
        } catch (NumberFormatException e) {
            throw new BadNoteFormatException(s);
        }
    }

    private static Note parseBaseNote(String s) {
        Note match = null;
        for (Note note : Note.values()) {
            if (s.contains(note.getLabel())
                    && (match == null || note.getIndex() > match.getIndex())) {
                match = note;
            }
        }
        if (match == null) {
            throw new BadNoteFormatException(s);
        }
        return match;
    }
}
