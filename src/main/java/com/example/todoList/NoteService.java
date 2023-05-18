package com.example.todoList;

import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
@Data
@Service
public class NoteService {
    private List<Note> noteList = Arrays.asList(new Note("First", "Go to school"),
            new Note("First", "Go to school"),new Note("First", "Go to school"),
            new Note("First", "Go to school"),new Note("First", "Go to school"));

    public List<Note> listAll() {
        return noteList;
    }
    public Note add(Note note) {
        if (noteList.contains(note)) {
            throw new IllegalArgumentException("Note with this id already exists.");
        }
        noteList.add(note);
        return note;
    }

    public void deleteById(Long id) {
        boolean removed = noteList.removeIf(n -> n.getId() == id);
        if (!removed) {
            throw new IllegalArgumentException("Note with this id does not exist.");
        }
    }

    public void update(Note note) {
        noteList.forEach(n -> {
            if (n.getId() == note.getId()) {
                n.setTitle(note.getTitle());
                n.setContent(note.getContent());
            }
        });
    }

    public Note getById(long id) {
        return noteList.stream()
                .filter(n -> n.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
