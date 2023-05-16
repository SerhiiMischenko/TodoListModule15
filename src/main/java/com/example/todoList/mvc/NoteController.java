package com.example.todoList.mvc;

import com.example.todoList.NoteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NoteController {
    @RequestMapping(method = RequestMethod.GET, value = "/note/list")
    public ModelAndView getAllNotes() {
        ModelAndView result = new ModelAndView("list");
        result.addObject("list", new NoteService().listAll());
        return result;
    }

}
