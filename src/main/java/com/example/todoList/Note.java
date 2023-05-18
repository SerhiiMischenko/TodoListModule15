package com.example.todoList;

import lombok.Data;
import org.springframework.stereotype.Component;
@Data
@Component()
public class Note {
    private static int idCounter = 0;
    private int id;
    private String title;
    private String content;

    public Note() {
        this.id = idCounter++;
    }

    public Note(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
