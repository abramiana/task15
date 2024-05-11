package com.example.task14.controllers;

import com.example.task14.model.Note;
import com.example.task14.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class NoteRestController {

    @Autowired
    private NoteService noteService;

    // Отримати всі записи
    @GetMapping
    public List<Note> getAllNotes() {
        return noteService.listAll();
    }

    // Отримати запис за id
    @GetMapping("/{id}")
    public Note getNoteById(@PathVariable("id") long id) {
        return noteService.getById(id);
    }

    // Додати нову запис
    @PostMapping
    public Note addNote(@RequestBody Note note) {
        return noteService.add(note);
    }

    // Оновити запис
    @PutMapping("/{id}")
    public Note updateNote(@PathVariable("id") long id, @RequestBody Note note) {
        note.setId(id);
        return noteService.update(note);
    }

    // Видалити запис
    @DeleteMapping("/{id}")
    public void deleteNoteById(@PathVariable("id") long id) {
        noteService.deleteById(id);
    }
}
