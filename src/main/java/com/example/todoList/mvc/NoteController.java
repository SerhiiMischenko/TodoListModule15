package com.example.todoList.mvc;

import com.example.todoList.Note;
import com.example.todoList.NoteService;
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
        model.addAttribute("list", noteService.listAll());
        return "list";
    }

    @PostMapping("/delete")
    public String deleteNote(@RequestParam("id") Long id) {
        noteService.deleteById(id);
        return "redirect:/note/list";
    }

    @GetMapping("/create")
    public String createNoteForm(Model model) {
        model.addAttribute("note", new Note());
        return "create";
    }

    @PostMapping("/create")
    public String createNoteSubmit(@ModelAttribute("note") Note note) {
        noteService.add(note);
        return "redirect:/note/list";
    }

    @GetMapping("/edit/{id}")
    public String editNoteForm(@PathVariable("id") Long id, Model model) {
        Note note = noteService.getById(id);
        model.addAttribute("note", note);
        return "edit";
    }

    @PostMapping("/edit")
    public String editNoteSubmit(@ModelAttribute("note") Note note) {
        noteService.update(note);
        return "redirect:/note/list";
    }
}
