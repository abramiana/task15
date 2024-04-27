package com.example.task14.repository;

import com.example.task14.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository  extends JpaRepository<Note, Long> {
}
