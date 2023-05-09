package com.example.todoList;

import lombok.Data;
import org.springframework.stereotype.Component;
@Data
@Component("noteBean")
public class Note {
    private static int idCounter = 0;
    private int id;
    private String title;
    private String content;

}
