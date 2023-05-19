package com.example.todoList.mvc;

import com.example.todoList.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/note")
public class NoteController {
    private final NoteService noteService;
@Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/list")
    public ModelAndView getAllNotes() {
        System.out.println("In getAllNotes()");
        ModelAndView result = new ModelAndView("list");
        result.addObject("list", noteService.listAll());
        return result;
    }
    @PostMapping("/delete")
    public String deleteNote(@RequestParam("id") Long id) {
        System.out.println("In delete");
        System.out.println(id);
        System.out.println(noteService);
        noteService.deleteById(id);
        System.out.println(noteService);
        return "redirect:/note/list";
    }
}
