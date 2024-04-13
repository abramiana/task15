package com.example.task14.controllers;

import com.example.task14.models.Note;
import com.example.task14.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/note")
public class NoteController {

    @Autowired
    private NoteService noteService;

    // Отримати список всіх нотаток і відобразити на сторінці note-list.html
    @GetMapping("/list")
    public String listNotes(Model model) {
        List<Note> notes = noteService.listAll();
        model.addAttribute("notes", notes);
        return "note-list";
    }

    // Видалити нотатку за її ідентифікатором і перенаправити на сторінку списку нотаток
    @PostMapping("/delete/{id}")
    public String deleteNoteById(@PathVariable("id") long id) {
        noteService.deleteById(id);
        return "redirect:/note/list";
    }

    // Показати форму редагування нотатки за її ідентифікатором
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") long id, Model model) {
        Note note = noteService.getById(id);
        model.addAttribute("note", note);
        return "note-edit";
    }

    // Зберегти відредаговану нотатку та перенаправити на сторінку списку нотаток
    @PostMapping("/edit")
    public String editNote(@ModelAttribute("note") Note note) {
        noteService.update(note);
        return "redirect:/note/list";
    }

    // Показати форму додавання нової нотатки
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("note", new Note());
        return "note-add";
    }

    // Зберегти нову нотатку та перенаправити на сторінку списку нотаток
    @PostMapping("/add")
    public String addNote(@ModelAttribute("note") Note note) {
        noteService.add(note);
        return "redirect:/note/list";
    }
}