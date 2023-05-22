package com.example.todoList;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.stereotype.Component;
@Data
@Component()
@Entity
public class Note {
    @Id
    @GeneratedValue
    private long id;
    @Column
    private String title;
    @Column
    private String content;

    public Note() {
    }

    public Note(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
