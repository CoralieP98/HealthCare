package com.CoralieP98.note.controller;

import com.CoralieP98.note.model.Note;
import com.CoralieP98.note.service.NoteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping("createNote")
    public Note createNote(@RequestBody Note note){
        return noteService.createNote(note);
    }
}
