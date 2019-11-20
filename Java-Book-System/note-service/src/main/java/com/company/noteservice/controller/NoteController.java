package com.company.noteservice.controller;

import com.company.noteservice.dao.NoteRepo;
import com.company.noteservice.model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NoteController {

    @Autowired
    private NoteRepo noteRepo;

    @PostMapping("/notes")
    public Note cerateNote(@RequestBody Note note) {
        return noteRepo.save(note);
    }

    @GetMapping("/notes/{id}")
    public Note getNote(@PathVariable int id){
        return noteRepo.getOne(id);
    }

    @GetMapping("/notes/book/{book_id")
    public List<Note> getNotesByBook(@PathVariable(name="book_id") int bookId){
        return noteRepo.findNoteByBookId(bookId);
    }

    @GetMapping("/notes")
    public List<Note> getAllNotes() {
        return noteRepo.findAll();
    }

    @PutMapping("/note/{id}")
    public void updateNote(@RequestBody Note note, @PathVariable int id){
        note.setNoteId(id);
        noteRepo.save(note);
    }

    @DeleteMapping("/notes/{id}")
    public void deleteNote(@PathVariable int id){
        noteRepo.deleteById(id);
    }


}


