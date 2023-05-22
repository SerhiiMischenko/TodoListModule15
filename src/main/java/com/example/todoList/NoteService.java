package com.example.todoList;

import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
@Data
@Service
public class NoteService {
    private final NoteRepository noteRepository;

    public List<Note> getNoteRepository() {
        return noteRepository.findAll();
    }

    public void createNote(Note note) {
        noteRepository.save(note);
    }

    public void deleteNote(Long id) {
        noteRepository.deleteById(id);
    }

    public Note editNote(Note note) {
        noteRepository.deleteById(note.getId());
        return getNoteById(note.getId());
    }

    public Note getNoteById(Long id) {
        List<Note> noteList = noteRepository.findAll();
        for (Note note : noteList) {
            if (note.getId() == id) {
                return note;
            }
        }
        return null;
    }
}
