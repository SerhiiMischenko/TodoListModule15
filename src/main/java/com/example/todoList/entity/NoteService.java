package com.example.todoList.entity;

import com.example.todoList.data.NoteRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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

    public Note editNoteById(Note note) {
        noteRepository.save(getNoteById(note.getId()));
        return note;
    }

    public void editNote(Note note) {
        noteRepository.save(note);
    }



    public Note getNoteById(Long id) {
        List<Note> noteList = noteRepository.findAll();
        for (Note note : noteList) {
            if (Objects.equals(note.getId(), id)) {
                return note;
            }
        }
        return null;
    }

}
