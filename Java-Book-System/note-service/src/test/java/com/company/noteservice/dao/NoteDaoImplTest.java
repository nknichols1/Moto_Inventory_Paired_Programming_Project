package com.company.noteservice.dao;

import com.company.noteservice.model.Note;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class NoteDaoImplTest {
    @Autowired
    NoteRepo noteRepo;

    private Note note;

   @BeforeEach
    public void setup(){
        Note note = new Note();
        note.setNote("Group project");
        note.setBookId(2);

        clearDatabase();
    }

    @Test
    public void shouldAddGetDeleteNote(){
        note = noteRepo.save(note);
        Note note2;
        note2 = noteRepo.getOne(note.getNoteId());
        assertEquals(note2, note);
        noteRepo.deleteById(note.getNoteId());
        assertNull(noteRepo.getOne(note.getNoteId()));
    }

    @Test
    public void shouldGetAllNotes(){
       note = noteRepo.save(note);
       Note note2 = new Note();
       note2.setNote("Capstone Project");
       note2.setBookId(4);
       noteRepo.save(note2);
       List<Note> noteList = noteRepo.findAll();
       assertEquals(2, noteList.size());
    }

    @Test
    public void shouldGetNotesByBook(){
        note = noteRepo.save(note);
        Note note2 = new Note();
        note2.setNote("Capstone Project");
        note2.setBookId(2);
        noteRepo.save(note2);
        List<Note> noteList = noteRepo.findAll();
        assertEquals(2, noteList.size());
    }

    @Test
    public void shouldUpdateNote(){
       note = noteRepo.save(note);
        Note note2 = new Note();
        note2.setNote("Capstone Project");
        note2.setBookId(4);
        note2.setNoteId(note.getNoteId());
        noteRepo.save(note2);

        assertEquals(note2, noteRepo.getOne(note.getNoteId()));
    }

    // Helper method to clear the database
    public void clearDatabase(){
        List<Note> noteList = noteRepo.findAll();
        for(Note note : noteList){
            noteRepo.deleteById(note.getNoteId());
        }
    }

}
