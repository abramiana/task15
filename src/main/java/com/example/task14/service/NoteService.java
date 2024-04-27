package com.example.task14.service;

import com.example.task14.model.Note;
import com.example.task14.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    public List<Note> listAll() {
        return noteRepository.findAll();
    }

    public Note add(Note note) {
        return noteRepository.save(note);
    }

    public void deleteById(long id) {
        noteRepository.deleteById(id);
    }

    public void update(Note note) {
        if (noteRepository.existsById(note.getId())) {
            noteRepository.save(note);
        } else {
            throw new IllegalArgumentException("Note with id " + note.getId() + " does not exist");
        }
    }


    public Note getById(long id) {
        return noteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Note with id " + id + " does not exist"));
    }
}