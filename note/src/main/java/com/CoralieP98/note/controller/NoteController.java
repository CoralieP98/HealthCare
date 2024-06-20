package com.CoralieP98.note.controller;

import com.CoralieP98.note.model.Note;
import com.CoralieP98.note.service.NoteService;
import org.aspectj.weaver.ast.Not;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("findNotesByPatientId")
    public List<Note> findNotesByPatientId(@RequestParam Long patientId){
        return noteService.findAllByPatientId(patientId);
    }

    @PostMapping("findNoteById")
    public Note findNoteById(@RequestParam String id){
        return noteService.findNoteById(id);
    }

    @PutMapping("updateNote")
    public Note updateNote(@RequestParam(name = "id")String id,@RequestBody Note note){
        return noteService.updateNote(id,note);
    }

    @DeleteMapping("deleteNote")
    public void deleteNote(@RequestParam String id){
       noteService.deleteNote(id);
    }


}
