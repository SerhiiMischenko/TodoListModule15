package com.example.todoList.mvc;

import com.example.todoList.entity.Note;
import com.example.todoList.entity.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/note")
public class NoteController {
    private final NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/list")
    public String getAllNotes(Model model) {
        model.addAttribute("list", noteService.getNoteRepository());
        return "list";
    }

    @PostMapping("/delete")
    public String deleteNote(@RequestParam("id") Long id) {
        noteService.deleteNote(id);
        return "redirect:/note/list";
    }

    @GetMapping("/create")
    public String createNoteForm(Model model) {
        model.addAttribute("note", new Note());
        return "create";
    }

    @PostMapping("/create")
    public String createNoteSubmit(@ModelAttribute("note") Note note) {
        noteService.createNote(note);
        return "redirect:/note/list";
    }

    @GetMapping("/edit/{id}")
    public String editNoteForm(@PathVariable("id") Long id, Model model) {
        Note note = noteService.editNoteById(noteService.getNoteById(id));
        model.addAttribute("note", note);
        return "edit";
    }

    @PostMapping("/edit")
    public String editNoteSubmit(@ModelAttribute("note") Note note) {
        noteService.editNote(note);
        System.out.println(note);
        return "redirect:/note/list";
    }
}
