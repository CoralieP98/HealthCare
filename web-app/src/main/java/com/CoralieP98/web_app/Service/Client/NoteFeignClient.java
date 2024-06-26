package com.CoralieP98.web_app.Service.Client;

import com.CoralieP98.web_app.Model.Note;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("note")
public interface NoteFeignClient {

    @PostMapping(value = "/note/createNote", consumes = "application/json")
    public ResponseEntity<Note> createNote(Note note);

    @GetMapping(value = "/note/findNotesByPatientId", consumes = "application/json")
    public ResponseEntity<List<Note>> findNotesByPatientId(@RequestParam Long patientId);

    @GetMapping(value = "/note/findNoteById", consumes = "application/json")
    public ResponseEntity<Note> findNoteById(@RequestParam String id);

    @PutMapping(value = "/note/updateNote", consumes = "application/json")
    public ResponseEntity<Note> updateNote(@RequestParam String id, Note note);

    @DeleteMapping(value = "/note/deleteNote", consumes = "application/json")
    public void deleteNote(@RequestParam String id);



}