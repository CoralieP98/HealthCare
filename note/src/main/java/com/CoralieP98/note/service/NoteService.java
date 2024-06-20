package com.CoralieP98.note.service;

import com.CoralieP98.note.model.Note;
import com.CoralieP98.note.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public Note createNote(Note note){
        return noteRepository.save(note);
    }

    public List<Note> findAllByPatientId(Long patientId){
        return noteRepository.findNotesByPatientId(patientId);
    }
}
