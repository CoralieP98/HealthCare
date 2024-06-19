package com.CoralieP98.note.model;


import java.time.LocalDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("note")
public class Note {

    @Id
    private String id;
    private String note;
    private LocalDate noteDate;
    private Long patientId;
}
